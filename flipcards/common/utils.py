import sys
import random
import multiprocessing

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
