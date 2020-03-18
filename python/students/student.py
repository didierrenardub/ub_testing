from students.exercise import Exercise

class Student:
    def __init__(self, name, registration_number):
        self._name = name
        self._registration_number = registration_number
        self._exercises = []
        self._grades = {}
        pass

    def name(self):
        return self._name

    def registration_number(self):
        return self._registration_number

    def add_exercise(self, ex_id, grade):
        self._exercises.append(Exercise(ex_id, grade))
        return self

    def exercise(self, with_id):
        for ex in self._exercises:
            if ex.id() == with_id:
                return ex
        return None

    def grades(self):
        return self._grades

    def class_average(self, class_id):
        avg = 0.0
        ex_count = 0
        for ex in self._exercises:
            if ex.id().startswith(str(class_id) + 'm') or ex.id().startswith(str(class_id) + 'o'):
                avg = avg + ex.grade()
                ex_count = ex_count + 1
        
        gradables = 0
        for v in self._grades[class_id]:
            if v > 0:
                gradables = gradables + 1
                if v > 10:
                    v = v / 10
                avg = avg + v
        
        avg = avg / max([ex_count + gradables, 1])
        return avg

    def grades_average(self):
        avg = 0.0
        for ex in self._exercises:
            avg = avg + ex.grade()
        
        gradables = 0
        for k, v in self._grades.items():
            for g in range(0, len(v)):
                if g > 1:
                    grade = v[g]
                    if not v[g] == 0:
                        gradables = gradables + 1
                        if grade > 10:
                            grade = grade / 10
                        avg = avg + grade
        
        avg = avg / max([len(self._exercises) + gradables, 1])
        return avg

    def grade_class(self, class_number, attendance, permanence, mandatory_assignments, mandatory_grade, optional_assignments, optional_grade, question):
        if class_number in self._grades:
            self._grades[class_number][0] = attendance
            self._grades[class_number][1] = permanence
            self._grades[class_number][2] = mandatory_assignments
            self._grades[class_number][3] = mandatory_grade
            self._grades[class_number][4] = optional_assignments
            self._grades[class_number][5] = optional_grade
            self._grades[class_number][6] = question
        else:
            self._grades[class_number] = [ attendance, permanence, mandatory_assignments, mandatory_grade, optional_assignments, optional_grade, question ]
        return self

    def attendance(self):
        a = 0
        for k, v in self._grades.items():
            if v[0] > 1:
                a = a + 1
        return a / len(self._grades) * 100.0

    def permanence(self):
        p = 0
        c = 0
        for k, v in self._grades.items():
            if v[1] > 1:
                p = p + v[1]
                c = c + 1
            elif v[1] == 1:
                c = c + 1
        if c > 0:
            return p / (c * 10.0) * 100.0
        return p / 10.0 * 100.0


class Students:
    def __init__(self):
        self._students = []

    def students(self):
        return self._students

    def add_student(self, name, registration_number):
        self._students.append(Student(name, registration_number))
        return self

    def student_by_name(self, name):
        for student in self.students():
            if student.name() == name:
                return student
        return None

    def student_by_reg(self, reg_number):
        for student in self.students():
            if student.registration_number() == reg_number:
                return student
        return None

    def print_students(self):
        ss = self.students().copy()
        ss.sort(reverse=True, key=lambda s: s.grades_average())
        for s in ss:
            print(s.name() + ' (a: ' + str(s.attendance()) + '%; p: ' + str(s.permanence()) + '%): ' + str(s.grades_average()))

    def print_evolution(self):
        for s in self.students():
            print(s.name() + ': ', end='')
            for k, _ in s.grades().items():
                print(str(s.class_average(k)) + ' ', end='')
            print('')
