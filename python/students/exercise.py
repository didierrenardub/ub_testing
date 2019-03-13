
class Exercise:
    def __init__(self, ex_id, grade):
        self._id = ex_id
        self._grade = grade

    def id(self):
        return self._id

    def grade(self):
        return self._grade
