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
        self.add_student('Gabriel Lozano', -1)

        # class 1                       c   a   p  mp  ms  op  os   q
        self.alex().grade_class(        1, 10, 10,  0,  0,  0,  0,  0)
        self.franco().grade_class(      1, 10, 10,  0,  0,  0,  0,  0)
        self.belen().grade_class(       1, 10, 10,  0,  0,  0,  0,  0)
        self.federico().grade_class(    1, 10, 10,  0,  0,  0,  0,  0)
        self.andres().grade_class(      1, 10, 10,  0,  0,  0,  0,  0)
        self.francisco().grade_class(   1,  1,  0,  0,  0,  0,  0,  0)
        self.diego().grade_class(       1,  1,  0,  0,  0,  0,  0,  0)
        self.damian().grade_class(      1, 10, 10,  0,  0,  0,  0,  0)
        self.rocio().grade_class(       1, 10, 10,  0,  0,  0,  0,  0)
        self.joaquin().grade_class(     1, 10, 10,  0,  0,  0,  0,  0)
        self.gabriel().grade_class(     1,  1,  0,  0,  0,  0,  0,  0)

        self.alex().add_exercise('1m',      7.5)
        self.franco().add_exercise('1m',    3.0)
        self.belen().add_exercise('1m',     6.0)
        self.federico().add_exercise('1m',  5.5)
        self.andres().add_exercise('1m',    5.5)
        self.francisco().add_exercise('1m', 3.5)
        self.diego().add_exercise('1m',     6.0)
        self.damian().add_exercise('1m',    6.0)
        self.rocio().add_exercise('1m',     4.5)
        self.joaquin().add_exercise('1m',   5.5)
        self.gabriel().add_exercise('1m',   1.0)

        self.alex().add_exercise('1m2',         10.0)
        self.franco().add_exercise('1m2',        1.0)
        self.belen().add_exercise('1m2',        10.0)
        self.federico().add_exercise('1m2',     10.0)
        self.andres().add_exercise('1m2',       10.0)
        self.francisco().add_exercise('1m2',    10.0)
        self.diego().add_exercise('1m2',        10.0)
        self.damian().add_exercise('1m2',        1.0)
        self.rocio().add_exercise('1m2',         8.0)
        self.joaquin().add_exercise('1m2',      10.0)
        self.gabriel().add_exercise('1m2',       1.0)

        self.alex().add_exercise('1o',      10.0)
        self.belen().add_exercise('1o',     10.0)
        self.francisco().add_exercise('1o', 10.0)
        self.diego().add_exercise('1o',     10.0)

        # class 2                       c   a   p  mp  ms  op  os   q
        self.alex().grade_class(        2, 10, 10, 10,  9, 10, 10,  8)
        self.franco().grade_class(      2, 10, 10,  3,  1,  0,  0,  1)
        self.belen().grade_class(       2, 10, 10, 10,  8, 10, 10,  1)
        self.federico().grade_class(    2, 10, 10, 10,  8,  0,  0, 10)
        self.andres().grade_class(      2, 10, 10, 10,  8,  0,  0,  1)
        self.francisco().grade_class(   2, 10, 10, 10,  7, 10, 10,  1)
        self.diego().grade_class(       2, 10, 10, 10,  8, 10, 10,  1)
        self.damian().grade_class(      2, 10, 10,  3,  2,  0,  0,  1)
        self.rocio().grade_class(       2, 10, 10, 10,  6,  0,  0,  1)
        self.joaquin().grade_class(     2, 10, 10, 10,  8,  0,  0,  1)
        self.gabriel().grade_class(     2,  1,  0,  0,  0,  0,  0,  0)

        self.alex().add_exercise('2m',      1.0)
        self.franco().add_exercise('2m',    5.5)
        self.belen().add_exercise('2m',    10.0)
        self.federico().add_exercise('2m', 10.0)
        self.andres().add_exercise('2m',   10.0)
        self.francisco().add_exercise('2m', 1.0)
        self.diego().add_exercise('2m',    10.0)
        self.damian().add_exercise('2m',    1.0)
        self.rocio().add_exercise('2m',     7.5)
        self.joaquin().add_exercise('2m',   1.0)
        self.gabriel().add_exercise('2m',   7.0)

        self.alex().add_exercise('2m2',         1.0)
        self.franco().add_exercise('2m2',       1.0)
        self.belen().add_exercise('2m2',       10.0)
        self.federico().add_exercise('2m2',     1.0)
        self.andres().add_exercise('2m2',      10.0)
        self.francisco().add_exercise('2m2',    1.0)
        self.diego().add_exercise('2m2',        1.0)
        self.damian().add_exercise('2m2',       1.0)
        self.rocio().add_exercise('2m2',        6.0)
        self.joaquin().add_exercise('2m2',      1.0)
        self.gabriel().add_exercise('2m2',      1.0)

        self.diego().add_exercise('2o',        10.0)

        # class 3                       c   a   p  mp  ms  op  os   q
        self.alex().grade_class(       3, 10, 10,  5,  3,  0,  0,  1)
        self.franco().grade_class(     3,  1,  0,  1,  0,  0,  0,  0)
        self.belen().grade_class(      3, 10, 10,  5,  5,  0,  0,  3)
        self.federico().grade_class(   3, 10, 10, 10, 10,  0,  0, 10)
        self.andres().grade_class(     3, 10, 10, 10, 10,  0,  0, 10)
        self.francisco().grade_class(  3, 10, 10,  1,  0,  0,  0, 10)
        self.diego().grade_class(      3, 10, 10,  1,  0,  0,  0, 10)
        self.damian().grade_class(     3, 10, 10,  1,  0,  0,  0,  3)
        self.rocio().grade_class(      3, 10, 10,  8,  7,  0,  0,  5)
        self.joaquin().grade_class(    3,  1,  0,  1,  0,  0,  0,  0)
        self.gabriel().grade_class(    3, 10, 10,  1,  0,  0,  0, 10)

        self.alex().add_exercise('3m',     10.0)
        self.franco().add_exercise('3m',    0.1)
        self.belen().add_exercise('3m',     9.0)
        self.federico().add_exercise('3m',  8.0)
        self.andres().add_exercise('3m',    7.0)
        self.francisco().add_exercise('3m', 8.0)
        self.diego().add_exercise('3m',     7.0)
        self.damian().add_exercise('3m',    0.5)
        self.rocio().add_exercise('3m',     6.5)
        self.joaquin().add_exercise('3m',   1.0)
        self.gabriel().add_exercise('3m',   7.0)

        self.alex().add_exercise('3m2',      3.2)
        self.franco().add_exercise('3m2',    1.0)
        self.belen().add_exercise('3m2',     1.0)
        self.federico().add_exercise('3m2',  2.4)
        self.andres().add_exercise('3m2',    1.0)
        self.francisco().add_exercise('3m2', 1.0)
        self.diego().add_exercise('3m2',     3.5)
        self.damian().add_exercise('3m2',    1.0)
        self.rocio().add_exercise('3m2',     1.0)
        self.joaquin().add_exercise('3m2',   1.0)
        self.gabriel().add_exercise('3m2',   1.8)

        # class 4                       c   a   p  mp  ms  op  os   q
        self.alex().grade_class(       4,  1,  0,  5,  2,  0,  0,  0)
        self.franco().grade_class(     4, 10, 10,  5,  1,  0,  0,  1)
        self.belen().grade_class(      4, 10, 10,  5,  4,  0,  0,  6)
        self.federico().grade_class(   4, 10, 10,  5,  2,  0,  0,  6)
        self.andres().grade_class(     4, 10, 10,  5,  3,  0,  0,  1)
        self.francisco().grade_class(  4, 10, 10,  5,  4,  0,  0, 10)
        self.diego().grade_class(      4, 10, 10, 10,  5,  0,  0,  2)
        self.damian().grade_class(     4, 10,  1,  5,  3,  0,  0,  1)
        self.rocio().grade_class(      4, 10, 10,  5,  3,  0,  0, 10)
        self.joaquin().grade_class(    4, 10, 10,  1,  0,  0,  0,  1)
        self.gabriel().grade_class(    4,  1,  0,  5,  2,  0,  0,  0)

        # class 5                       c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(       5,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     5,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(      5,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   5,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(     5,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  5,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(      5,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(     5,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(      5,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(    5,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(    5,  0,  0,  0,  0,  0,  0,  0)

        # class 6                       c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(       6,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     6,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(      6,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   6,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(     6,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  6,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(      6,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(     6,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(      6,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(    6,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(    6,  0,  0,  0,  0,  0,  0,  0)

        # class 7                       c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(       7,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     7,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(      7,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   7,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(     7,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  7,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(      7,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(     7,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(      7,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(    7,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(    7,  0,  0,  0,  0,  0,  0,  0)

        # class 8                       c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(       8,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     8,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(      8,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   8,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(     8,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  8,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(      8,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(     8,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(      8,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(    8,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(    8,  0,  0,  0,  0,  0,  0,  0)

        # class 9                       c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(       9,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(     9,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(      9,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(   9,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(     9,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class(  9,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(      9,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(     9,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(      9,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(    9,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(    9,  0,  0,  0,  0,  0,  0,  0)

        # class 10                      c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(      10,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    10,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(     10,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  10,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(    10,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 10,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(     10,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(    10,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(     10,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(   10,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(   10,  0,  0,  0,  0,  0,  0,  0)

        # class 11                      c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(      11,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    11,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(     11,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  11,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(    11,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 11,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(     11,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(    11,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(     11,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(   11,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(   11,  0,  0,  0,  0,  0,  0,  0)

        # class 12                      c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(      12,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    12,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(     12,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  12,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(    12,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 12,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(     12,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(    12,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(     12,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(   12,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(   12,  0,  0,  0,  0,  0,  0,  0)

        # class 13                      c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(      13,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    13,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(     13,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  13,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(    13,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 13,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(     13,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(    13,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(     13,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(   13,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(   13,  0,  0,  0,  0,  0,  0,  0)

        # class 14                      c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(      14,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    14,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(     14,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  14,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(    14,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 14,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(     14,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(    14,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(     14,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(   14,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(   14,  0,  0,  0,  0,  0,  0,  0)

        # class 15                      c   a   p  mp  ms  op  os   q
        #self.alex().grade_class(      15,  0,  0,  0,  0,  0,  0,  0)
        #self.franco().grade_class(    15,  0,  0,  0,  0,  0,  0,  0)
        #self.belen().grade_class(     15,  0,  0,  0,  0,  0,  0,  0)
        #self.federico().grade_class(  15,  0,  0,  0,  0,  0,  0,  0)
        #self.andres().grade_class(    15,  0,  0,  0,  0,  0,  0,  0)
        #self.francisco().grade_class( 15,  0,  0,  0,  0,  0,  0,  0)
        #self.diego().grade_class(     15,  0,  0,  0,  0,  0,  0,  0)
        #self.damian().grade_class(    15,  0,  0,  0,  0,  0,  0,  0)
        #self.rocio().grade_class(     15,  0,  0,  0,  0,  0,  0,  0)
        #self.joaquin().grade_class(   15,  0,  0,  0,  0,  0,  0,  0)
        #self.gabriel().grade_class(   15,  0,  0,  0,  0,  0,  0,  0)


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

    def gabriel(self):
        return self.student_by_name('Gabriel Lozano')
