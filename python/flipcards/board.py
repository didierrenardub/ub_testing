from common.connie import Frame, UIColor

CARD_SIZE = 3

class Board(Frame):
    def __init__(self, w=3, h=4):
        Frame.__init__(self)
        self._board_width = w
        self._board_height = h
        self._board = []
        for x in range(0, w):
            self._board.append([])
            for y in range(0, h):
                self._board[x].append(None)
        self._last_played = None
        self._last_move_flips = 0
        self.set_w_h(w * CARD_SIZE + 2, h * CARD_SIZE + 2) # +2: borders
        self.set_back_color(UIColor.black())

    def board_width(self):
        return self._board_width

    def board_height(self):
        return self._board_height

    def card(self, x, y):
        if self.valid(x, y):
            return self._board[x][y]
        return None

    def valid(self, x, y):
        return x >= 0 and x < len(self._board) and y >= 0 and y < len(self._board[0])

    def last_played(self):
        ret = self._last_played
        self._last_played = None
        return ret

    def last_move_flips(self):
        return self._last_move_flips

    def play_card(self, card, x, y):
        self._last_played = card
        self._last_move_flips = 0
        if self.valid(x, y) and self.card(x, y) is None and card is not None:
            if self.empty():
                card.set_invincible(True)
            else:
                for x2 in self._board:
                    for y2 in x2:
                        if y2 is not None:
                            y2.set_invincible(False)
            self._board[x][y] = card
            card.set_x_y(x * card.size().width() + 1, y * card.size().height() + 1) # +1: border
            self.add_child(card)
            if x > 0:
                other = self.card(x - 1, y)
                if other is not None and other.flip(card.owner(), card.left(), other.right()):
                    self._last_move_flips = self._last_move_flips + 1
            if x < len(self._board):
                other = self.card(x + 1, y)
                if other is not None and other.flip(card.owner(), card.right(), other.left()):
                    self._last_move_flips = self._last_move_flips + 1
            if y > 0:
                other = self.card(x, y - 1)
                if other is not None and other.flip(card.owner(), card.up(), other.down()):
                    self._last_move_flips = self._last_move_flips + 1
            if y < len(self._board[0]):
                other = self.card(x, y + 1)
                if other is not None and other.flip(card.owner(), card.down(), other.up()):
                    self._last_move_flips = self._last_move_flips + 1
            return True
        return False

    def full(self):
        for x in self._board:
            for y in x:
                if y is None:
                    return False
        return True

    def empty(self):
        for x in self._board:
            for y in x:
                if y is not None:
                    return False
        return True

    def read_only(self):
        b = Board(self._board_width, self._board_height)
        b._last_played = self._last_played
        b._last_move_flips = self._last_move_flips
        for x in range(0, len(self._board)):
            for y in range(0, len(self._board[x])):
                c = self.card(x, y)
                if c is not None:
                    b.play_card(c.clone(), x, y)
                else:
                    b.play_card(None, x, y)
        return b
