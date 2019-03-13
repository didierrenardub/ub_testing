from students.students2019 import Students2019
from common.connie import Table

if __name__ == '__main__':
    s = Students2019()

    t = Table(4, len(s.students()) + 1)
    t.cell(0, 0).set_text('Alumno')
    t.cell(1, 0).set_text('Asist')
    t.cell(2, 0).set_text('Perm')
    t.cell(3, 0).set_text('Prom')

    ss = s.students().copy()
    ss.sort(reverse=True, key=lambda st: st.grades_average())
    cur_row = 1
    for st in ss:
        t.cell(0, cur_row).set_text(st.name())
        t.cell(1, cur_row).set_text(str(st.attendance()))
        t.cell(2, cur_row).set_text(str(st.permanence()))
        t.cell(3, cur_row).set_text(str(st.grades_average()))
        cur_row = cur_row + 1
    t.render()