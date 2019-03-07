import sys
import random
import multiprocessing

from common.namegen import LetterProviderBase
from common.math import Probability

def is_python_3():
	return sys.version_info >= (3, 0)

def read_input():
    if is_python_3():
        return input()
    else:
        return raw_input()

class CallWrapper():
    def __init__(self, result_holder, call, *args):
        self._call = call
        self._args = args
        self._result = result_holder

    def __call__(self):
        self._result.put(self._call(*self._args))

class TimeoutCall():
    def __init__(self, timeout, call, *args):
        self._timeout = timeout
        self._call = call
        self._args = args
        try:
            self._result = multiprocessing.Queue()
        except ImportError:
            self._timeout = -1
            self._result = None

    def start(self):
        if self._result is not None:
            p = multiprocessing.Process(target=CallWrapper(self._result, self._call, *self._args))
            p.start()
            p.join(self._timeout)
            if p.is_alive():
                p.terminate()
                p.join()
                return False
            return True
        else:
            self._result = self._call(*self._args)
            return True
        return False
    
    def result(self):
        if self._timeout is not -1:
            return self._result.get()
        return self._result

class ProbLetterProvider(LetterProviderBase):
    def __init__(self):
        LetterProviderBase.__init__(self)
        kMaxProbability = 20
        kJProb = 10
        kQProb = 2

        self._prob = {}
        self._prob['a'] = Probability('a').add('b', kMaxProbability).add('c', kMaxProbability).add('d', kMaxProbability).add('e', kMaxProbability).add('f', kMaxProbability).add('g', kMaxProbability).add('h', 15).add('i', kMaxProbability).add('j', kJProb).add('k', kMaxProbability).add('l', kMaxProbability).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('q', kQProb).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', kMaxProbability).add('w', 10).add('x', 5).add('y', kMaxProbability).add('z', kMaxProbability)
        self._prob['b'] = Probability('a').add('a', kMaxProbability).add('b', kMaxProbability).add('c', kMaxProbability).add('d', kMaxProbability).add('e', kMaxProbability).add('f', kMaxProbability).add('g', kMaxProbability).add('i', kMaxProbability).add('j', kJProb).add('k', 5).add('l', kMaxProbability).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 2)
        self._prob['c'] = Probability('a').add('a', kMaxProbability).add('c', 10).add('d', kMaxProbability).add('e', kMaxProbability).add('f', kMaxProbability).add('g', kMaxProbability).add('h', kMaxProbability).add('i', kMaxProbability).add('j', kJProb).add('k', 10).add('l', kMaxProbability).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', 10).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 5)
        self._prob['d'] = Probability('a').add('a', kMaxProbability).add('b', kMaxProbability).add('c', 15).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', 15).add('i', kMaxProbability).add('j', kJProb).add('k', 10).add('l', 15).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('r', kMaxProbability).add('s', 15).add('t', 15).add('u', kMaxProbability).add('v', 2).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 2)
        self._prob['e'] = Probability('a').add('a', 15).add('b', kMaxProbability).add('c', kMaxProbability).add('d', kMaxProbability).add('e', kMaxProbability).add('f', kMaxProbability).add('g', kMaxProbability).add('h', 10).add('i', kMaxProbability).add('j', kJProb).add('k', kMaxProbability).add('l', kMaxProbability).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('q', kQProb).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', kMaxProbability).add('w', 10).add('x', 5).add('y', kMaxProbability).add('z', kMaxProbability)
        self._prob['f'] = Probability('a').add('a', kMaxProbability).add('b', 10).add('c', 10).add('d', 10).add('e', kMaxProbability).add('f', kMaxProbability).add('g', 10).add('i', kMaxProbability).add('j', kJProb / 2).add('k', 15).add('l', kMaxProbability).add('m', 15).add('n', 15).add('o', kMaxProbability).add('p', 15).add('r', kMaxProbability).add('s', 15).add('t', 15).add('u', kMaxProbability).add('v', 5).add('y', kMaxProbability).add('z', 2)
        self._prob['g'] = Probability('a').add('a', kMaxProbability).add('b', 15).add('c', 10).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', kMaxProbability).add('i', kMaxProbability).add('j', kJProb / 2).add('k', 10).add('l', kMaxProbability).add('m', 15).add('n', 15).add('o', kMaxProbability).add('p', 15).add('r', kMaxProbability).add('s', 15).add('t', 15).add('u', kMaxProbability).add('v', 10).add('w', 5).add('y', kMaxProbability).add('z', 10)
        self._prob['h'] = Probability('a').add('a', kMaxProbability).add('e', kMaxProbability).add('i', kMaxProbability).add('k', 10).add('l', 10).add('m', 15).add('n', 15).add('o', kMaxProbability).add('r', 10).add('t', 10).add('u', kMaxProbability).add('y', kMaxProbability).add('z', 10)
        self._prob['i'] = Probability('a').add('a', kMaxProbability).add('b', kMaxProbability).add('c', kMaxProbability).add('d', kMaxProbability).add('e', kMaxProbability).add('f', kMaxProbability).add('g', kMaxProbability).add('h', 15).add('j', kJProb).add('k', kMaxProbability).add('l', kMaxProbability).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('q', kQProb).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', kMaxProbability).add('w', 10).add('x', 5).add('y', 5).add('z', kMaxProbability)
        self._prob['j'] = Probability('a').add('a', kMaxProbability).add('b', 10).add('c', 5).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', 10).add('i', kMaxProbability).add('k', 15).add('l', 10).add('m', 10).add('n', 10).add('o', kMaxProbability).add('p', 10).add('r', 10).add('s', 10).add('t', 10).add('u', kMaxProbability).add('v', 5).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 5)
        self._prob['k'] = Probability('a').add('a', kMaxProbability).add('b', 10).add('d', 10).add('e', kMaxProbability).add('f', 10).add('g', 10).add('h', 5).add('i', kMaxProbability).add('j', kJProb / 2).add('k', kMaxProbability).add('l', 10).add('m', 10).add('n', 10).add('o', kMaxProbability).add('p', 10).add('r', 15).add('s', 10).add('t', 15).add('u', kMaxProbability).add('v', 5).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 10)
        self._prob['l'] = Probability('a').add('a', kMaxProbability).add('b', 15).add('c', 15).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', 15).add('i', kMaxProbability).add('j', kJProb / 2).add('k', kMaxProbability).add('l', kMaxProbability).add('m', kMaxProbability).add('n', 15).add('o', kMaxProbability).add('p', kMaxProbability).add('r', 10).add('s', 10).add('t', 15).add('u', kMaxProbability).add('v', 15).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 5)
        self._prob['m'] = Probability('a').add('a', kMaxProbability).add('b', kMaxProbability).add('c', 10).add('d', 10).add('e', kMaxProbability).add('f', 10).add('g', 10).add('h', 5).add('i', kMaxProbability).add('j', kJProb / 2).add('k', 10).add('l', 10).add('m', kMaxProbability).add('n', 10).add('o', kMaxProbability).add('p', 10).add('r', 10).add('s', 10).add('t', 10).add('u', kMaxProbability).add('v', 5).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 10)
        self._prob['n'] = Probability('a').add('a', kMaxProbability).add('b', 5).add('c', 5).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', 15).add('h', 5).add('i', kMaxProbability).add('j', kJProb / 2).add('k', 15).add('l', 10).add('m', 5).add('n', kMaxProbability).add('o', kMaxProbability).add('p', 15).add('r', 10).add('s', 15).add('t', 15).add('u', kMaxProbability).add('v', 10).add('w', 2).add('x', 2).add('y', 15).add('z', 15)
        self._prob['o'] = Probability('a').add('a', kMaxProbability).add('b', kMaxProbability).add('c', kMaxProbability).add('d', kMaxProbability).add('e', kMaxProbability).add('f', kMaxProbability).add('g', kMaxProbability).add('h', 15).add('i', kMaxProbability).add('j', kJProb).add('k', kMaxProbability).add('l', kMaxProbability).add('m', kMaxProbability).add('n', kMaxProbability).add('o', kMaxProbability).add('p', kMaxProbability).add('q', kQProb).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', kMaxProbability).add('w', 10).add('x', 5).add('y', 15).add('z', kMaxProbability)
        self._prob['p'] = Probability('a').add('a', kMaxProbability).add('b', 10).add('c', 10).add('d', 10).add('e', kMaxProbability).add('f', 15).add('g', 15).add('h', 10).add('i', kMaxProbability).add('j', kJProb).add('k', 15).add('l', kMaxProbability).add('m', 15).add('n', 10).add('o', kMaxProbability).add('p', kMaxProbability).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', 10).add('w', 2).add('x', 2).add('y', 15).add('z', 10)
        self._prob['q'] = Probability('a').add('u', kMaxProbability)
        self._prob['r'] = Probability('a').add('a', kMaxProbability).add('b', 15).add('c', 15).add('d', kMaxProbability).add('e', kMaxProbability).add('f', 15).add('g', 15).add('h', 10).add('i', kMaxProbability).add('j', kJProb / 2).add('k', kMaxProbability).add('l', 15).add('m', 15).add('n', 10).add('o', kMaxProbability).add('p', 15).add('r', kMaxProbability).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', 10).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 15)
        self._prob['s'] = Probability('a').add('a', kMaxProbability).add('b', 10).add('c', 10).add('d', 10).add('e', kMaxProbability).add('f', 15).add('g', 15).add('h', 10).add('i', kMaxProbability).add('j', kJProb / 2).add('k', kMaxProbability).add('l', 5).add('m', 15).add('n', 15).add('o', kMaxProbability).add('p', 15).add('r', 15).add('s', kMaxProbability).add('t', kMaxProbability).add('u', kMaxProbability).add('v', 10).add('w', 2).add('x', 2).add('y', kMaxProbability).add('z', 5)
        self._prob['t'] = Probability('a').add('a', kMaxProbability).add('b', 10).add('c', 10).add('d', 10).add('e', kMaxProbability).add('f', 15).add('g', 10).add('h', 15).add('i', kMaxProbability).add('j', kJProb / 2).add('k', 10).add('l', 15).add('m', 10).add('n', 10).add('o', kMaxProbability).add('p', 15).add('r', 15).add('s', 15).add('t', kMaxProbability).add('u', kMaxProbability).add('v', 5).add('w', 2).add('x', 2).add('y', 15).add('z', 10)
        self._prob['u'] = Probability('a').add('a', kMaxProbability).add('b', 15).add('c', 15).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', 15).add('h', 10).add('i', kMaxProbability).add('j', kJProb).add('k', 15).add('l', 15).add('m', 15).add('n', 15).add('o', kMaxProbability).add('p', 15).add('r', 15).add('s', 15).add('t', 15).add('v', 15).add('w', 10).add('x', 10).add('y', 15).add('z', 15)
        self._prob['v'] = Probability('a').add('a', kMaxProbability).add('c', 5).add('d', 5).add('e', kMaxProbability).add('f', 5).add('g', 5).add('i', kMaxProbability).add('j', kJProb / 4).add('k', 5).add('l', 5).add('m', 5).add('n', 5).add('o', kMaxProbability).add('p', 5).add('r', 5).add('s', 5).add('t', 15).add('u', kMaxProbability).add('y', kMaxProbability).add('z', 5)
        self._prob['w'] = Probability('a').add('a', kMaxProbability).add('b', 5).add('c', 5).add('d', 5).add('e', kMaxProbability).add('f', 5).add('g', 5).add('i', kMaxProbability).add('j', kJProb / 4).add('k', 10).add('l', 10).add('m', 5).add('n', 5).add('o', kMaxProbability).add('p', 5).add('r', 10).add('s', 10).add('t', 10).add('u', kMaxProbability).add('x', 2).add('y', 15).add('z', 10)
        self._prob['x'] = Probability('a').add('a', kMaxProbability).add('b', 5).add('d', 5).add('e', kMaxProbability).add('f', 5).add('g', 5).add('i', kMaxProbability).add('j', kJProb / 4).add('k', 5).add('l', 5).add('m', 5).add('n', 5).add('o', kMaxProbability).add('p', 5).add('r', 5).add('s', 5).add('t', 5).add('u', kMaxProbability).add('v', 5).add('y', kMaxProbability).add('z', 5)
        self._prob['y'] = Probability('a').add('a', kMaxProbability).add('b', 15).add('c', 15).add('d', 15).add('e', kMaxProbability).add('f', 15).add('g', 15).add('i', kMaxProbability).add('j', kJProb).add('k', kMaxProbability).add('l', 15).add('m', kMaxProbability).add('n', 10).add('o', kMaxProbability).add('p', 15).add('r', kMaxProbability).add('s', 10).add('t', 15).add('u', kMaxProbability).add('v', 10).add('w', 2).add('x', 5).add('z', 10)
        self._prob['z'] = Probability('a').add('a', kMaxProbability).add('b', 5).add('c', 5).add('d', 5).add('e', kMaxProbability).add('f', 5).add('g', 5).add('i', kMaxProbability).add('j', kJProb / 4).add('k', 10).add('l', 5).add('m', 5).add('n', 5).add('o', kMaxProbability).add('p', 5).add('r', 5).add('t', 5).add('u', kMaxProbability).add('v', 5).add('y', 15).add('z', kMaxProbability)

    def letter(self, last=''):
        if last in self._prob:
            return self._prob[last].random_object()
        return self._prob['a'].random_object()

class Manager:
    def __init__(self):
        self._objects = []

    def objects(self):
        return self._objects

    def add(self, obj):
        if obj not in self._objects:
            self._objects.append(obj)
        return self

    def remove(self, obj):
        self._objects.remove(obj)
        return self

    def find(self, prop_method, compare_to):
        for obj in self.objects():
            if prop_method(obj) == compare_to:
                return obj
        return None

    def at(self, idx):
        if idx < len(self.objects()):
            return self.objects()[idx]
        return None

    def random(self):
        if len(self.objects()) > 0:
            if len(self.objects()) > 1:
                return self.objects()[random.randint(0, len(self.objects()) - 1)]
            else:
                return self.at(0)
        return None

class ManagerKey(Manager):
    def __init__(self, obj_get_key_method=None):
        Manager.__init__(self)
        self._get_key_method = obj_get_key_method

    def get(self, key):
        if self._get_key_method is not None:
            return self.find(self._get_key_method, key)
        return None

    def __getitem__(self, key):
        return self.get(key)
