from students.student import Student, Students

class Students2019(Students):
    def __init__(self):
        Students.__init__(self)
        self.add_student('Alexander Lehmacher', -1)
        self.add_student('Franco Alfaro', -1)
        self.add_student('Maria Belen De Vicente', -1)
        self.add_student('Federico Franco', -1)
        self.add_student('Andres Lacruz', -1)
        self.add_student('Francisco Migliardi', -1)
        self.add_student('Diego Moran', -1)
        self.add_student('Damian Perez', -1)
        self.add_student('Rocio Rodriguez', -1)
        self.add_student('Joaquin Rodriguez', -1)

        # class 1
        self.alex().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.franco().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.belen().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.federico().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.andres().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.francisco().grade_class(1, 1, 0, 0, 0, 0, 0, 0)
        self.diego().grade_class(1, 1, 0, 0, 0, 0, 0, 0)
        self.damian().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.rocio().grade_class(1, 10, 10, 0, 0, 0, 0, 0)
        self.joaquin().grade_class(1, 10, 10, 0, 0, 0, 0, 0)

        self.alex().add_exercise('1m', 7.5)
        self.franco().add_exercise('1m', 3.0)
        self.belen().add_exercise('1m', 6.0)
        self.federico().add_exercise('1m', 5.5)
        self.andres().add_exercise('1m', 5.5)
        self.francisco().add_exercise('1m', 3.5)
        self.diego().add_exercise('1m', 6.0)
        self.damian().add_exercise('1m', 6.0)
        self.rocio().add_exercise('1m', 1)
        self.joaquin().add_exercise('1m', 1)

        self.alex().add_exercise('1m2', 1)
        self.franco().add_exercise('1m2', 1)
        self.belen().add_exercise('1m2', 10.0)
        self.federico().add_exercise('1m2', 10.0)
        self.andres().add_exercise('1m2', 1)
        self.francisco().add_exercise('1m2', 1)
        self.diego().add_exercise('1m2', 1)
        self.damian().add_exercise('1m2', 1)
        self.rocio().add_exercise('1m2', 1)
        self.joaquin().add_exercise('1m2', 1)

        # class 2
        # self.alex().grade_class(1, 10, 10, 3, 2, 0, 0, 0)
        # self.franco().grade_class(1, 10, 10, 3, 1, 0, 0, 0)
        # self.belen().grade_class(1, 10, 10, 10, 8, 0, 0, 0)
        # self.federico().grade_class(1, 10, 10, 10, 8, 0, 0, 0)
        # self.andres().grade_class(1, 10, 10, 3, 2, 0, 0, 0)
        # self.francisco().grade_class(1, 1, 0, 3, 1, 0, 0, 0)
        # self.diego().grade_class(1, 1, 0, 3, 2, 0, 0, 0)
        # self.damian().grade_class(1, 10, 10, 3, 2, 0, 0, 0)
        # self.rocio().grade_class(1, 10, 10, 1, 1, 0, 0, 0)
        # self.joaquin().grade_class(1, 10, 10, 1, 1, 0, 0, 0)

    def alex(self):
        return self.student_by_name('Alexander Lehmacher')

    def franco(self):
        return self.student_by_name('Franco Alfaro')

    def belen(self):
        return self.student_by_name('Maria Belen De Vicente')

    def federico(self):
        return self.student_by_name('Federico Franco')

    def andres(self):
        return self.student_by_name('Andres Lacruz')

    def francisco(self):
        return self.student_by_name('Francisco Migliardi')

    def diego(self):
        return self.student_by_name('Diego Moran')

    def damian(self):
        return self.student_by_name('Damian Perez')

    def rocio(self):
        return self.student_by_name('Rocio Rodriguez')

    def joaquin(self):
        return self.student_by_name('Joaquin Rodriguez')
