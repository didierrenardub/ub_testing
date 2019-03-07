import random

from flipcards.card import Card

class Player():
    def __init__(self, name, color):
        self._name = name
        self._color = color
        self._total_flips = 0
        self._current_flips = 0
        self._against_flips = 0
        self._won = 0
        self._lost = 0
        self._drawn = 0

    def set_name(self, name):
        self._name = name
        return self

    def set_color(self, color):
        self._color = color
        return self

    def add_flips(self, flips):
        self._current_flips = self._current_flips + flips
        self._total_flips = self._total_flips + flips
        return self

    def add_against_flips(self, flips):
        self._against_flips = self._against_flips + flips
        return self

    def name(self):
        return self._name

    def color(self):
        return self._color

    def total_flips(self):
        return self._total_flips

    def current_flips(self):
        return self._current_flips

    def against_flips(self):
        return self._against_flips

    def diff_flips(self):
        return self._total_flips - self._against_flips

    def won(self):
        return self._won

    def lost(self):
        return self._lost

    def drawn(self):
        return self._drawn

    def reset(self):
        self._current_flips = 0
        return self

    def play(self, board, cards):
        raise Exception('Player::play NOT IMPLEMENTED')
        #return cards[0], 0, 0 # card, x, y

    def add_won(self):
        self._won = self._won + 1
        return self

    def add_lost(self):
        self._lost = self._lost + 1
        return self

    def add_drawn(self):
        self._drawn = self._drawn + 1
        return self

    def points(self):
        return self.won() * 3 + self.drawn()


class Flipbot(Player):
    def __init__(self, name, color):
        Player.__init__(self, name, color)

    def play(self, board, cards):
        x = random.randint(0, board.board_width() - 1)
        y = random.randint(0, board.board_height() - 1)
        while board.card(x, y) is not None:
            x = random.randint(0, board.board_width() - 1)
            y = random.randint(0, board.board_height() - 1)
        return cards[random.randint(0, len(cards) - 1)], x, y
