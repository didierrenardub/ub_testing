from students.student import Student, Students

class Students2020(Students):
    def __init__(self):
        Students.__init__(self)
        self.add_student('Pablo Jose Achaval Rodriguez', -1)
        self.add_student('Federico Martin Andrade', -1)
        self.add_student('Victoria Aylen Baral Martin', -1)
        self.add_student('Manuel Chiariglione', -1)
        self.add_student('Cristian Arnaldo De Pietro', -1)
        self.add_student('Luis Javier Esquivel Guevara', -1)
        self.add_student('Franco Fiori', -1)
        self.add_student('Yainy Bianellys Garcia Ruiz', -1)
        self.add_student('Francisco Giordano', -1)
        self.add_student('Nazareno Guzman', -1)
        self.add_student('Alan Javier Jones', -1)
        self.add_student('Ricardo Manuel Lozano Melendez', -1)
        self.add_student('Matias Rosofsky', -1)

        # class 1                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       1,  1,  0,  0,  0,  0,  0,  0)
        self.federico().grade_class(    1, 10, 10,  0,  0,  0,  0,  0)
        self.victoria().grade_class(    1, 10, 10,  0,  0,  0,  0,  0)
        self.manuel().grade_class(      1,  1,  0,  0,  0,  0,  0,  0)
        self.cristian().grade_class(    1, 10, 10,  0,  0,  0,  0,  0)
        self.luis().grade_class(        1, 10, 10,  0,  0,  0,  0,  0)
        self.franco().grade_class(      1, 10, 10,  0,  0,  0,  0,  0)
        self.yainy().grade_class(       1, 10, 10,  0,  0,  0,  0,  0)
        self.francisco().grade_class(   1, 10, 10,  0,  0,  0,  0,  0)
        self.nazareno().grade_class(    1, 10, 10,  0,  0,  0,  0,  0)
        self.alan().grade_class(        1, 10, 10,  0,  0,  0,  0,  0)
        self.ricardo().grade_class(     1,  1,  0,  0,  0,  0,  0,  0)
        self.matias().grade_class(      1, 10, 10,  0,  0,  0,  0,  0)

        self.federico().add_exercise('1m',  7.5)
        self.victoria().add_exercise('1m',  7.5)
        self.cristian().add_exercise('1m',  7.0)
        self.luis().add_exercise('1m',      7.5)
        self.franco().add_exercise('1m',    7.0)
        self.yainy().add_exercise('1m',     7.0)
        self.francisco().add_exercise('1m', 8.0)
        self.alan().add_exercise('1m',      4.0)
        self.ricardo().add_exercise('1m',   7.0)
        self.matias().add_exercise('1m',    5.0)

        # class 2                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       2,  1,  0,  1,  0,  0,  0,  0)
        self.federico().grade_class(    2, 10, 10,  1,  8,  0,  0,  0)
        self.victoria().grade_class(    2, 10, 10,  1,  8,  0,  0,  0)
        self.manuel().grade_class(      2,  1,  0,  1,  0,  0,  0,  0)
        self.cristian().grade_class(    2, 10, 10, 10,  7,  0,  0,  0)
        self.luis().grade_class(        2, 10, 10,  1,  8,  0,  0,  0)
        self.franco().grade_class(      2, 10, 10, 10,  7,  0,  0,  0)
        self.yainy().grade_class(       2, 10, 10, 10,  7,  0,  0,  0)
        self.francisco().grade_class(   2, 10, 10, 10,  8,  0,  0,  0)
        self.nazareno().grade_class(    2,  1,  0,  1,  0,  0,  0,  0)
        self.alan().grade_class(        2, 10, 10, 10,  4,  0,  0,  0)
        self.ricardo().grade_class(     2, 10, 10,  1,  7,  0,  0,  0)
        self.matias().grade_class(      2, 10, 10, 10,  5,  0,  0,  0)

        self.federico().add_exercise('2m',  10.0)
        self.victoria().add_exercise('2m',  10.0)
        self.luis().add_exercise('2m',      10.0)
        self.franco().add_exercise('2m',    10.0)
        self.yainy().add_exercise('2m',     10.0)
        self.alan().add_exercise('2m',      10.0)
        #self.ricardo().add_exercise('2m',   10.0)
        self.matias().add_exercise('2m',    10.0)

        self.pablo().add_exercise('2o1',    10.0)

        self.alan().add_exercise('2o2',     10.0)
        self.ricardo().add_exercise('2o2',  10.0)

        # class 3                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       3, 10, 10,  1,  0,  0,  0,  0)
        self.federico().grade_class(    3, 10, 10, 10, 10,  0,  0,  0)
        self.victoria().grade_class(    3, 10, 10,  5, 10,  0,  0,  0)
        self.manuel().grade_class(      3, 10, 10,  1,  0,  0,  0,  0)
        self.cristian().grade_class(    3, 10, 10,  1,  0,  0,  0,  0)
        self.luis().grade_class(        3, 10, 10,  6, 10,  0,  0,  0)
        self.franco().grade_class(      3, 10, 10, 10, 10,  0,  0,  0)
        self.yainy().grade_class(       3, 10, 10, 10, 10,  0,  0,  0)
        self.francisco().grade_class(   3, 10, 10,  1,  0,  0,  0,  0)
        self.nazareno().grade_class(    3,  1,  0,  1,  0,  0,  0,  0)
        self.alan().grade_class(        3, 10, 10, 10, 10,  0,  0,  0)
        self.ricardo().grade_class(     3, 10, 10,  3,  0,  0,  0,  0)
        self.matias().grade_class(      3, 10, 10, 10, 10,  5, 10,  0)

        self.yainy().add_exercise('1m',     1.5)
        self.alan().add_exercise('1m',      2.3)

        # class 4                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       4,  1,  0,  0,  0,  0,  0,  0)
        self.federico().grade_class(    4, 10, 10,  0,  0,  0,  0,  0)
        self.victoria().grade_class(    4, 10, 10,  0,  0,  0,  0,  0)
        self.manuel().grade_class(      4, 10, 10,  0,  0,  0,  0,  0)
        self.cristian().grade_class(    4, 10, 10,  0,  0,  0,  0,  0)
        self.luis().grade_class(        4, 10, 10,  0,  0,  0,  0,  0)
        self.franco().grade_class(      4, 10, 10,  0,  0,  0,  0,  0)
        self.yainy().grade_class(       4, 10, 10,  0,  0,  0,  0,  0)
        self.francisco().grade_class(   4, 10, 10,  0,  0,  0,  0,  0)
        self.nazareno().grade_class(    4,  1,  0,  0,  0,  0,  0,  0)
        self.alan().grade_class(        4, 10, 10,  8,  3,  1,  5,  0)
        self.ricardo().grade_class(     4, 10, 10,  0,  0,  0,  0,  0)
        self.matias().grade_class(      4, 10, 10,  0,  0,  0,  0,  0)

        # class 5                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       5, 10, 10,  1,  0,  0,  0,  0)
        self.federico().grade_class(    5, 10, 10,  1,  0,  0,  0,  0)
        self.victoria().grade_class(    5, 10, 10,  1,  0,  0,  0,  0)
        self.manuel().grade_class(      5, 10, 10,  1,  0,  0,  0,  0)
        self.cristian().grade_class(    5, 10, 10,  1,  0,  0,  0,  0)
        self.luis().grade_class(        5, 10, 10,  1,  0,  0,  0,  0)
        self.franco().grade_class(      5,  1,  0,  1,  0,  0,  0,  0)
        self.yainy().grade_class(       5, 10, 10,  1,  0,  0,  0,  0)
        self.francisco().grade_class(   5, 10, 10,  1,  0,  0,  0,  0)
        self.nazareno().grade_class(    5,  1,  0,  1,  0,  0,  0,  0)
        self.alan().grade_class(        5, 10, 10,  1,  0,  0,  0,  0)
        self.ricardo().grade_class(     5, 10, 10,  1,  0,  0,  0,  0)
        self.matias().grade_class(      5, 10, 10,  1,  0,  0,  0,  0)

        # class 6                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       6,  1,  0,  1,  0,  0,  0,  0)
        self.federico().grade_class(    6, 10, 10,  1,  0,  0,  0,  0)
        self.victoria().grade_class(    6,  4, 10,  1,  0,  0,  0,  0)
        self.manuel().grade_class(      6,  1,  0,  1,  0,  0,  0,  0)
        self.cristian().grade_class(    6, 10, 10,  1,  0,  0,  0,  0)
        self.luis().grade_class(        6, 10, 10,  1,  0,  0,  0,  0)
        self.franco().grade_class(      6,  1,  0,  1,  0,  0,  0,  0)
        self.yainy().grade_class(       6, 10, 10,  1,  0,  0,  0,  0)
        self.francisco().grade_class(   6, 10, 10,  1,  0,  0,  0,  0)
        self.nazareno().grade_class(    6,  1,  0,  1,  0,  0,  0,  0)
        self.alan().grade_class(        6, 10, 10,  1,  0,  0,  0,  0)
        self.ricardo().grade_class(     6, 10, 10,  1,  0,  0,  0,  0)
        self.matias().grade_class(      6, 10, 10,  1,  0,  0,  0,  0)

        # class 7                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       7, 10, 10,  0,  0,  0,  0,  0)
        self.federico().grade_class(    7, 10, 10,  0,  0,  0,  0,  0)
        self.victoria().grade_class(    7,  4, 10,  0,  0,  0,  0,  0)
        self.manuel().grade_class(      7,  1,  0,  0,  0,  0,  0,  0)
        self.cristian().grade_class(    7, 10, 10,  0,  0,  0,  0,  0)
        self.luis().grade_class(        7, 10, 10,  0,  0,  0,  0,  0)
        self.franco().grade_class(      7,  1,  0,  0,  0,  0,  0,  0)
        self.yainy().grade_class(       7, 10, 10,  0,  0,  0,  0,  0)
        self.francisco().grade_class(   7, 10, 10,  0,  0,  0,  0,  0)
        self.nazareno().grade_class(    7,  1,  0,  0,  0,  0,  0,  0)
        self.alan().grade_class(        7, 10, 10,  0,  0,  0,  0,  0)
        self.ricardo().grade_class(     7,  1,  0,  0,  0,  0,  0,  0)
        self.matias().grade_class(      7, 10, 10,  0,  0,  0,  0,  0)

        # class 8                       c   a   p  mp  ms  op  os   q
        self.pablo().grade_class(       8,  6,  0,  0,  0,  0,  0,  0)
        self.federico().grade_class(    8, 10,  0,  0,  0,  0,  0,  0)
        self.victoria().grade_class(    8,  0,  0,  0,  0,  0,  0,  0)
        self.manuel().grade_class(      8,  0,  0,  0,  0,  0,  0,  0)
        self.cristian().grade_class(    8, 10,  0,  0,  0,  0,  0,  0)
        self.luis().grade_class(        8, 10,  0,  0,  0,  0,  0,  0)
        self.franco().grade_class(      8,  0,  0,  0,  0,  0,  0,  0)
        self.yainy().grade_class(       8, 10,  0,  0,  0,  0,  0,  0)
        self.francisco().grade_class(   8, 10,  0,  0,  0,  0,  0,  0)
        self.nazareno().grade_class(    8,  1,  0,  0,  0,  0,  0,  0)
        self.alan().grade_class(        8, 10,  0,  0,  0,  0,  0,  0)
        self.ricardo().grade_class(     8,  0,  0,  0,  0,  0,  0,  0)
        self.matias().grade_class(      8, 10,  0,  0,  0,  0,  0,  0)

        # class 9 (exam)                c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(       9,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(    9,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(    9,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(      9,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(    9,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(        9,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(      9,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(       9,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(   9,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(    9,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(        9,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(     9,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(      9,  0,  0,  0,  0,  0,  0,  0)

        # class 10                      c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(      10,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   10,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(   10,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(     10,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(   10,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(       10,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     10,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(      10,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  10,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(   10,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(       10,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(    10,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(     10,  0,  0,  0,  0,  0,  0,  0)

        # class 11                      c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(      11,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   11,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(   11,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(     11,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(   11,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(       11,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     11,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(      11,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  11,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(   11,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(       11,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(    11,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(     11,  0,  0,  0,  0,  0,  0,  0)

        # class 12                      c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(      12,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   12,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(   12,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(     12,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(   12,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(       12,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     12,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(      12,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  12,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(   12,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(       12,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(    12,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(     12,  0,  0,  0,  0,  0,  0,  0)

        # class 13                      c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(      13,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   13,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(   13,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(     13,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(   13,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(       13,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     13,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(      13,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  13,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(   13,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(       13,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(    13,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(     13,  0,  0,  0,  0,  0,  0,  0)

        # class 14                      c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(     14,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  14,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(  14,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(    14,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(  14,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(      14,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    14,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(     14,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 14,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(  14,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(      14,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(   14,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(    14,  0,  0,  0,  0,  0,  0,  0)

        # class 15                      c   a   p  mp  ms  op  os   q
        #self.pablo().grade_class(     15,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  15,  0,  0,  0,  0,  0,  0,  0)
        #self.victoria().grade_class(  15,  0,  0,  0,  0,  0,  0,  0)
        #self.manuel().grade_class(    15,  0,  0,  0,  0,  0,  0,  0)
        #self.cristian().grade_class(  15,  0,  0,  0,  0,  0,  0,  0)
        #self.luis().grade_class(      15,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    15,  0,  0,  0,  0,  0,  0,  0)
        #self.yainy().grade_class(     15,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 15,  0,  0,  0,  0,  0,  0,  0)
        #self.nazareno().grade_class(  15,  0,  0,  0,  0,  0,  0,  0)
        #self.alan().grade_class(      15,  0,  0,  0,  0,  0,  0,  0)
        #self.ricardo().grade_class(   15,  0,  0,  0,  0,  0,  0,  0)
        #self.matias().grade_class(    15,  0,  0,  0,  0,  0,  0,  0)

    def pablo(self):
        return self.student_by_name('Pablo Jose Achaval Rodriguez')

    def federico(self):
        return self.student_by_name('Federico Martin Andrade')

    def victoria(self):
        return self.student_by_name('Victoria Aylen Baral Martin')

    def manuel(self):
        return self.student_by_name('Manuel Chiariglione')

    def cristian(self):
        return self.student_by_name('Cristian Arnaldo De Pietro')

    def luis(self):
        return self.student_by_name('Luis Javier Esquivel Guevara')

    def franco(self):
        return self.student_by_name('Franco Fiori')

    def yainy(self):
        return self.student_by_name('Yainy Bianellys Garcia Ruiz')

    def francisco(self):
        return self.student_by_name('Francisco Giordano')

    def nazareno(self):
        return self.student_by_name('Nazareno Guzman')

    def alan(self):
        return self.student_by_name('Alan Javier Jones')

    def ricardo(self):
        return self.student_by_name('Ricardo Manuel Lozano Melendez')

    def matias(self):
        return self.student_by_name('Matias Rosofsky')
