from common.connie import UIInterface, MessageWindow, UIColor, Frame
from common.utils import TimeoutCall
from flipcards.board import Board
from flipcards.card import Card
import time
import random

MESSAGE_DELAY = 0.25

class Match(UIInterface):
    def __init__(self, home, away, same_deck=True, message_delay=MESSAGE_DELAY):
        UIInterface.__init__(self)
        self._home = home
        self._away = away
        self._board = Board()
        self._turn = home
        self._message_delay = message_delay

        self.set_w_h(50, 24)
        self._board.set_x_y(1, 1)
        self._log = MessageWindow.with_xywh(self._board.position().x() + self._board.size().width() + 1, self._board.position().y(), self.size().width() - self._board.size().width() - 2, self._board.size().height())
        self._decks = Frame.with_xywh(self._board.position().x(), self._board.position().y() + self._board.size().height(), self.size().width(), 5)
        self.add_child(self._log)
        self.add_child(self._decks)

        self._home_deck = []
        self._away_deck = []

        self.add_child(self._board)

        card_distribution = {
                30 : 1,
                27 : 2,
                24 : 2,
                21 : 3,
                18 : 3
            }

        if same_deck:
            deck = []
            deck.append(Card.with_points(None, 30))
            for dist, count in card_distribution.items():
                for _ in range(0, count):
                    self.add_unique_card(deck, None, dist)
            for c in deck:
                self._home_deck.append(c.clone().set_owner(self._home))
                self._away_deck.append(c.clone().set_owner(self._away))
        else:
            for dist, count in card_distribution.items():
                for _ in range(0, count):
                    self.add_unique_card(self._home_deck, self._home, 27)
                    self.add_unique_card(self._away_deck, self._away, 27)

        random.shuffle(self._home_deck)
        random.shuffle(self._away_deck)

    def home(self):
        return self._home

    def away(self):
        return self._away

    def add_unique_card(self, to_list, owner, points):
        to_add = Card.with_points(owner, points)
        while not self.add_unique(to_list, to_add):
            to_add = Card.with_points(owner, points)

    def add_unique(self, to_list, card):
        for c in to_list:
            if c.equals(card):
                return False
        to_list.append(card)
        return True

    def add_message(self, msg, color):
        self._log.add_message(msg, color)
        return self

    def update_decks_ui(self):
        self._decks.clear_children()
        i = 0
        for c in self._home_deck[:5]:
            c = c.clone()
            c.set_x_y(1 + c.size().width() * i + i, 1)
            self._decks.add_child(c)
            i = i + 1
        for c in self._away_deck[:5]:
            c = c.clone()
            c.set_x_y(1 + c.size().width() * i + i, 1)
            self._decks.add_child(c)
            i = i + 1

    def find_card(self, card, where):
        for c in where:
            if c.equals(card):
                return c
        return None

    def play(self):
        while not self._board.full() and len(self._home_deck) > 0 and len(self._away_deck) > 0:
            self.render()
            self.add_message(self._turn.name() + '\'s turn:', UIColor.light_yellow())
            time.sleep(self._message_delay)
            l = self._home_deck
            if self._turn == self._away:
                l = self._away_deck
            self.update_decks_ui()
            card = None
            x = -1
            y = -1

            tc = TimeoutCall(3, self._turn.play, self._board.read_only(), l[:5])
            if not tc.start():
                self.add_message(self._turn.name() + ' developed a crappy AI, disqualifying', UIColor.light_red())
                winner = self._home
                if self._turn == self._home:
                    winner = self._away
                self._home.reset()
                self._away.reset()
                self.render()
                time.sleep(self._message_delay * 2)
                return winner
            else:
                card, x, y = tc.result()

            card = self.find_card(card, l)

            if card in l and self._board.play_card(card, x, y):
                if self._board.last_move_flips() > 0:
                    self.add_message(self._turn.name() + ' flipped ' + str(self._board.last_move_flips()) + ' cards!', self._turn.color())
                    self._turn.add_flips(self._board.last_move_flips())
                else:
                    self.add_message(self._turn.name() + ' did not flip any card', UIColor.dark_gray())
                self.add_message(self._home.name() + ': ' + str(self._home.current_flips()), self._home.color())
                self.add_message(self._away.name() + ': ' + str(self._away.current_flips()), self._away.color())
                c = self._board.last_played()
                if c is not None:
                    l.remove(c)
            else:
                self.add_message(self._turn.name() + ' MADE AN ILEGAL MOVE', UIColor.light_red())
            if self._turn == self._home:
                self._turn = self._away
            else:
                self._turn = self._home
        winner = self._away
        if self._home.current_flips() > self._away.current_flips():
            winner = self._home
        elif self._home.current_flips() == self._away.current_flips():
            winner = None
        if winner is not None:
            self.add_message(winner.name() + ' has won the match!', winner.color())
        else:
            self.add_message('It\'s a tie', UIColor.dark_gray())
        self._home.add_against_flips(self._away.current_flips())
        self._away.add_against_flips(self._home.current_flips())
        self._home.reset()
        self._away.reset()
        self.render()
        time.sleep(self._message_delay * 2)
        return winner
