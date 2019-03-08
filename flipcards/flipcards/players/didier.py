from flipcards.player import Player

def create(color):
    return FlipAI('Didier', color)

class FlipAI(Player):
    def __init__(self, name, color):
        Player.__init__(self, name, color)

    class Play():
        def __init__(self, card, x, y):
            self._card = card
            self._x = x
            self._y = y
            self._flips = 0
            self._risk = 0
            self._plays = []

        def card(self):
            return self._card

        def x(self):
            return self._x

        def y(self):
            return self._y

        def flips(self):
            return self._flips

        def risk(self):
            return self._risk

        def add_flip(self):
            self._flips = self._flips + 1
            return self

        def add_risk(self, by=1):
            self._risk = self._risk + by
            return self

        def reduce_risk(self, by=1):
            self._risk = self._risk - by
            return self

        def value(self, level=0):
            v = self.flips() * 100 - self.risk()
            if len(self._plays) > 0:
                v = v + self._plays[0].value(level + 1)
            return v if level % 2 == 0 else -v

        def add_play(self, p):
            return self.add_plays([p])

        def add_plays(self, ps):
            self._plays.extend(ps)
            self._plays.sort(key=lambda p: p.value(), reverse=True)
            return self

    def analyze_play_card(self, play, against, fxc, fxa, axis, bound):
        if against is not None and fxc(play.card()) > fxa(against) and not against.invincible():
            play.add_flip()
        elif (against is None and axis == bound) or (against is not None and against.invincible()):
            play.reduce_risk((10 - fxc(play.card())) ** 2)
        elif against is not None:
            play.reduce_risk(10)
        elif against is None:
            play.add_risk((10 - fxc(play.card())) ** 2)

    def analyze_play(self, play, board, cards, depth=0):
        self.analyze_play_card(play, board.card(play.x() + 1, play.y()), Card.right, Card.left, play.x(), board.board_width() - 1)
        self.analyze_play_card(play, board.card(play.x() - 1, play.y()), Card.left, Card.right, play.x(), 0)
        self.analyze_play_card(play, board.card(play.x(), play.y() - 1), Card.up, Card.down, play.y(), 0)
        self.analyze_play_card(play, board.card(play.x(), play.y() + 1), Card.down, Card.up, play.y(), board.board_height() - 1)
        if depth > 0:
            b = board.read_only()
            b.play_card(play.card(), play.x(), play.y())
            play.add_plays(self.play_internal(b, cards, depth - 1))
        return play

    def play_internal(self, board, cards, depth=0):
        plays = []
        for x in range(0, board.board_width()):
            for y in range(0, board.board_height()):
                if board.card(x, y) is None:
                    for mc in cards:
                        plays.append(self.analyze_play(FlipAI.Play(mc, x, y), board, cards, 0))
        plays.sort(key=lambda p: p.value(), reverse=True)
        plays = plays[0:min([5, len(plays)])]
        for p in plays:
            self.analyze_play(p, board, cards, depth)
        plays.sort(key=lambda p: p.value(), reverse=True)
        return plays

    def play(self, board, cards):
        plays = self.play_internal(board, cards, 2)
        return plays[0].card(), plays[0].x(), plays[0].y()
