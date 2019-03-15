import random

class Player():
    def __init__(self, name, color):
        self._name = name
        self._color = color
        self._won = 0
        self._lost = 0
        self._drawn = 0
        self._symbol = 'X'

    def set_name(self, name):
        self._name = name
        return self

    def set_color(self, color):
        self._color = color
        return self

    def name(self):
        return self._name

    def color(self):
        return self._color

    def won(self):
        return self._won

    def lost(self):
        return self._lost

    def drawn(self):
        return self._drawn

    def play(self, board):
        raise Exception('Player::play NOT IMPLEMENTED')
        #return 0, 0 # x, y

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

    def symbol(self):
        return self._symbol

    def set_symbol(self, symbol):
        self._symbol = symbol
        return self


class Tictacbot(Player):
    def __init__(self, name, color):
        Player.__init__(self, name, color)

    def play(self, board):
        x = random.randint(0, board.board_width() - 1)
        y = random.randint(0, board.board_height() - 1)
        while board.tile(x, y) is not None:
            x = random.randint(0, board.board_width() - 1)
            y = random.randint(0, board.board_height() - 1)
        return x, y
