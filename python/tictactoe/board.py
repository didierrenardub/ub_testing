from common.connie import Frame, UIColor, Label

class Board(Frame):
    def __init__(self, w=3, h=3):
        Frame.__init__(self)
        self._board_width = w
        self._board_height = h
        self._board = []
        for x in range(0, w):
            self._board.append([])
            for y in range(0, h):
                self._board[x].append(None)
        self.set_w_h(w + 2, h + 2) # +2: borders
        self.set_back_color(UIColor.black())

    def board_width(self):
        return self._board_width

    def board_height(self):
        return self._board_height

    def tile(self, x, y):
        if self.valid(x, y):
            return self._board[x][y]
        return None

    def valid(self, x, y):
        return x >= 0 and x < len(self._board) and y >= 0 and y < len(self._board[0])

    def play(self, player, x, y):
        pnn = player is not None
        val = self.valid(x, y)
        emp = self.tile(x, y) is None
        sym = player.symbol() is not None
        if player is not None and self.valid(x, y) and self.tile(x, y) is None and player.symbol() is not None:
            self._board[x][y] = player.symbol()
            l = Label()
            l.set_text(player.symbol())
            l.set_fore_color(player.color())
            l.set_x_y(x + 1, y + 1) # +1: border
            self.add_child(l)
            return True
        return False

    def check_win(self):
        for x in range(0, len(self._board)):
            for y in range(0, len(self._board[x])):
                s = self.tile(x, y)
                if s is None:
                    continue
                h_win = self.tile(x - 1, y) == s and self.tile(x + 1, y) == s
                v_win = self.tile(x, y - 1) == s and self.tile(x, y + 1) == s
                d_win = self.tile(x - 1, y - 1) == s and self.tile(x + 1, y + 1) == s
                d2_win = self.tile(x - 1, y + 1) == s and self.tile(x + 1, y - 1) == s
                if h_win or v_win or d_win or d2_win:
                    return s
        return None

    def full(self):
        for x in self._board:
            for y in x:
                if y is None:
                    return False
        return True

    def read_only(self):
        b = Board(self._board_width, self._board_height)
        for x in range(0, len(self._board)):
            for y in range(0, len(self._board[x])):
                b._board[x][y] = self.tile(x, y)
        return b
