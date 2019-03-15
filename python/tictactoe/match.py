from common.connie import UIInterface, MessageWindow, UIColor, Frame
from common.utils import TimeoutCall
from tictactoe.board import Board
import time
import random

MESSAGE_DELAY = 1.0

class Match(UIInterface):
    def __init__(self, home, away, message_delay=MESSAGE_DELAY):
        UIInterface.__init__(self)
        self._home = home
        self._home.set_symbol('X')
        self._away = away
        self._away.set_symbol('O')
        self._board = Board()
        self._turn = home
        self._message_delay = message_delay

        self.set_w_h(50, 24)
        self._board.set_x_y(1, 1)
        self._log = MessageWindow.with_xywh(self._board.position().x() + self._board.size().width() + 1, self._board.position().y(), self.size().width() - self._board.size().width() - 2, self._board.size().height())
        self.add_child(self._log)
        
        self._home_deck = []
        self._away_deck = []

        self.add_child(self._board)

    def home(self):
        return self._home

    def away(self):
        return self._away

    def add_message(self, msg, color):
        self._log.add_message(msg, color)
        return self

    def disqualify(self, message):
        self.add_message(message, UIColor.light_red())
        winner = self._home
        if self._turn == self._home:
            winner = self._away
        self.render()
        time.sleep(2)
        return winner

    def play(self):
        while self._board.check_win() is None and not self._board.full():
            self.render()
            self.add_message(self._turn.name() + '\'s turn:', UIColor.light_yellow())
            time.sleep(self._message_delay)
            x = -1
            y = -1

            tc = TimeoutCall(3, self._turn.play, self._board.read_only())
            if not tc.start():
                return self.disqualify(self._turn.name() + ' developed a crappy AI, disqualifying')
            else:
                try:
                    x, y = tc.result()
                except:
                    return self.disqualify(self._turn.name() + ' returned an ill-formed touple, disqualifying')

            if self._board.play(self._turn, x, y):
                self.add_message(self._turn.name() + ' played ' + self._turn.symbol() + ' at (' + str(x) + ', ' + str(y) + ')', self._turn.color())
            else:
                return self.disqualify(self._turn.name() + ' made an ilegal move, disqualifying')
            if self._turn == self._home:
                self._turn = self._away
            else:
                self._turn = self._home
        winner = self._away
        if self._board.check_win() == self._home.symbol():
            winner = self._home
        elif self._board.check_win() is None:
            winner = None
        if winner is not None:
            self.add_message(winner.name() + ' has won the match!', winner.color())
        else:
            self.add_message('It\'s a tie', UIColor.dark_gray())
        self.render()
        time.sleep(self._message_delay * 2)
        return winner
