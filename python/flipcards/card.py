import random
from common.connie import Label, ALIGNMENT, COLOR, UIColor

class Card(Label):
    def __init__(self, owner, up, down, left, right):
        Label.__init__(self)
        self._up = up
        self._down = down
        self._left = left
        self._right = right
        self.set_text(str(self.up()) + '\n' + str(self.left()) + ' ' + str(self.right()) + '\n' + str(self.down()))
        self.set_text_h_align(ALIGNMENT.CENTER)
        self.set_text_v_align(ALIGNMENT.CENTER)
        self.set_w_h(3, 3)
        self.set_max_w_h(3, 3)
        self._invincible = False
        self.set_owner(owner)

    @staticmethod
    def with_points(owner, points):
        values = [ 0, 0, 0, 0 ]
        for _ in range(0, points):
            r = random.randint(0, len(values) - 1)
            if values[r] < 9:
                values[r] = values[r] + 1
            else:
                points = points + 1
        return Card(owner, values[0], values[1], values[2], values[3])

    def set_owner(self, owner):
        self._owner = owner
        if owner is not None:
            if owner.color().get() == COLOR.YELLOW or owner.color().get() == COLOR.LIGHT_YELLOW or owner.color().get() == COLOR.LIGHT_GREEN:
                self.set_fore_color(UIColor.black())
            else:
                self.set_fore_color(UIColor.white())
            self.set_back_color(self._owner.color())
        return self

    def set_invincible(self, invincible):
        self._invincible = invincible
        return self

    def up(self):
        return self._up

    def down(self):
        return self._down

    def left(self):
        return self._left

    def right(self):
        return self._right

    def owner(self):
        return self._owner

    def invincible(self):
        return self._invincible

    def equals(self, other):
        return type(other) == Card and self.up() == other.up() and self.down() == other.down() and self.left() == other.left() and self.right() == other.right()

    def flip(self, by, by_value, my_value):
        if by_value > my_value and not by == self.owner() and not self.invincible():
            self.set_owner(by)
            return True
        return False

    def clone(self):
        c = Card(self.owner(), self.up(), self.down(), self.left(), self.right())
        c.set_invincible(self.invincible())
        return c

    def __str__(self):
        return str(self.up()) + str(self.left()) + str(self.down()) + str(self.right()) + ' ' + Label.__str__(self)
    