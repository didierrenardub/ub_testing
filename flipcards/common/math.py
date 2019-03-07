import random

def random_bool():
    return random.randint(0, 1) == 0

class Probability:
    def __init__(self, none_value=None):
        self._none = none_value
        self._total = 0.0
        self._objects = []

    def add(self, obj, probability=50.0):
        self._total = self._total + probability
        self._objects.append([obj, probability])
        return self

    def remove(self, obj):
        for o in self._objects:
            if o[0] == obj:
                self._total = self._total - o[1]
                self._objects.remove(o)
                break
        return self

    def count(self):
        return len(self._objects)

    def set_none_value(self, none_value):
        self._none = none_value
        return self

    def none_value(self):
        return self._none

    def random_object(self):
        res = random.uniform(0.0, self._total)
        current = 0.0
        for o in self._objects:
            if res < o[1] + current:
                return o[0]
            current = current + o[1]
        return self._none
