from __future__ import print_function
import platform
import sys
from common.utils import read_input

def print_wrapper(to_p):
    print(to_p, end='')
    sys.stdout.flush()

from ctypes import Structure, c_long, c_ulong, c_short, c_ushort, byref

class ConsoleCoord(Structure):
    _fields_ = [
    ("X", c_short),
    ("Y", c_short)]

class ConsoleRect(Structure):
    _fields_ = [
    ("Left", c_short),
    ("Top", c_short),
    ("Right", c_short),
    ("Bottom", c_short)]

class ConsoleBuffer(Structure):
    _fields_ = [
    ("dwSize", ConsoleCoord),
    ("dwCursorPosition", ConsoleCoord),
    ("wAttributes", c_ushort),
    ("srWindow", ConsoleRect),
    ("dwMaximumWindowSize", ConsoleCoord)]

class WRAP_MODE:
    TRUNCATE = 0
    WORD = 1

class ALIGNMENT:
    BEGIN = 0
    CENTER = 1
    END = 2

class COLOR:
    BLACK = 0
    BLUE = 1
    GREEN = 2
    CYAN = 3
    RED = 4
    MAGENTA = 5
    YELLOW = 6
    GRAY = 7
    DARK_GRAY = 8
    LIGHT_BLUE = 9
    LIGHT_GREEN = 10
    LIGHT_CYAN = 11
    LIGHT_RED = 12
    LIGHT_MAGENTA = 13
    LIGHT_YELLOW = 14
    WHITE = 15
    TRANSPARENT = 16

if platform.system() == 'Windows':
    class CONSOLE_COLOR_BASE:
        BLACK = 0x00
        BLUE = 0x01
        GREEN = 0x02
        CYAN = 0x03
        RED = 0x04
        MAGENTA = 0x05
        YELLOW = 0x06
        GRAY = 0x07
        INTENSITY = 0x08
else:
    class CONSOLE_COLOR_BASE:
        BLACK = 0x00
        RED = 0x01
        GREEN = 0x02
        YELLOW = 0x03
        BLUE = 0x04
        MAGENTA = 0x05
        CYAN = 0x06
        GRAY = 0x07
        INTENSITY = 0x08

class CONSOLE_COLOR(CONSOLE_COLOR_BASE):
    color = CONSOLE_COLOR_BASE.GRAY | ((CONSOLE_COLOR_BASE.BLACK << 4) & 0xF0)

    @staticmethod
    def translate(c):
        if c is COLOR.BLACK:
            return CONSOLE_COLOR.BLACK
        elif c is COLOR.BLUE:
            return CONSOLE_COLOR.BLUE
        elif c is COLOR.GREEN:
            return CONSOLE_COLOR.GREEN
        elif c is COLOR.CYAN:
            return CONSOLE_COLOR.CYAN
        elif c is COLOR.RED:
            return CONSOLE_COLOR.RED
        elif c is COLOR.MAGENTA:
            return CONSOLE_COLOR.MAGENTA
        elif c is COLOR.YELLOW:
            return CONSOLE_COLOR.YELLOW
        elif c is COLOR.GRAY:
            return CONSOLE_COLOR.GRAY
        elif c is COLOR.DARK_GRAY:
            return CONSOLE_COLOR.BLACK | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.LIGHT_BLUE:
            return CONSOLE_COLOR.BLUE | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.LIGHT_GREEN:
            return CONSOLE_COLOR.GREEN | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.LIGHT_CYAN:
            return CONSOLE_COLOR.CYAN | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.LIGHT_RED:
            return CONSOLE_COLOR.RED | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.LIGHT_MAGENTA:
            return CONSOLE_COLOR.MAGENTA | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.LIGHT_YELLOW:
            return CONSOLE_COLOR.YELLOW | CONSOLE_COLOR.INTENSITY
        elif c is COLOR.WHITE:
            return CONSOLE_COLOR.GRAY | CONSOLE_COLOR.INTENSITY
        
        return COLOR.TRANSPARENT

    @staticmethod
    def translate_fb(f, b):
        return CONSOLE_COLOR.translate(f) | ((CONSOLE_COLOR.translate(b) << 4) & 0xF0)

    @staticmethod
    def colors():
        return CONSOLE_COLOR.color

    @staticmethod
    def set_colors(c):
        CONSOLE_COLOR.color = c
        if platform.system() == 'Windows':
            try:
                import msvcrt
                import ctypes
                handle = msvcrt.get_osfhandle(sys.stdout.fileno())
                ctypes.windll.kernel32.SetConsoleTextAttribute(handle, c)
            except:
                pass
        else:
            bgc = 0
            fgc = 30 + (c & 0xF & ~CONSOLE_COLOR.INTENSITY)
            if (((c & 0xF0) >> 4) & CONSOLE_COLOR.INTENSITY) is not 0:
                bgc = 100 + (((c & 0xF0) >> 4) & ~CONSOLE_COLOR.INTENSITY)
            else:
                bgc = 0 + ((c & 0xF0) >> 4)

            if ((c & 0xF) & CONSOLE_COLOR.INTENSITY) is not 0:
                print_wrapper("\033[%d;%d;1m" % (bgc, fgc))
            else:
                print_wrapper("\033[%d;%dm" % (bgc, fgc))
            #if (c & 0xF0) is not 0:
            #print_wrapper("\033[4%d;3%dm" % (((c & 0xF0) & ~(CONSOLE_COLOR.INTENSITY << 4)) >> 4, (c & 0x0F) & ~CONSOLE_COLOR.INTENSITY))
            #print_wrapper("\033[%d;3%dm" % (102, (c & 0x0F) & ~CONSOLE_COLOR.INTENSITY))
            #else:
                #print_wrapper("\033[3%dm" % ((c & 0x0F) & ~CONSOLE_COLOR.INTENSITY))

def set_cursor_position(pos):
    if platform.system() == 'Windows':
        try:
            import msvcrt
            import ctypes
            handle = msvcrt.get_osfhandle(sys.stdout.fileno())
            ctypes.windll.kernel32.SetConsoleCursorPosition(handle, c_ulong(pos.x() + (pos.y() << 16)))
        except Exception as e:
            print(str(e))
    else:
        if pos.x() < 0 or pos.y() < 0:
            pass
        print_wrapper('\033[%d;%dH' % (pos.y() + 1, pos.x() + 1))

def set_cursor_x_y(x, y):
    set_cursor_position(Position(x, y))

class Position:
    def __init__(self, x=0, y=0):
        self._x = x
        self._y = y

    def set(self, x, y):
        self.set_x(x)
        self.set_y(y)
        return self

    def x(self):
        return self._x

    def set_x(self, x):
        self._x = x
        return self

    def y(self):
        return self._y

    def set_y(self, y):
        self._y = y
        return self

class Size:
    def __init__(self, w=0, h=0):
        self._w = w
        self._h = h

    def set(self, w, h):
        self.set_width(w)
        self.set_height(h)
        return self

    def width(self):
        return self._w

    def set_width(self, w):
        self._w = w
        return self

    def height(self):
        return self._h

    def set_height(self, h):
        self._h = h
        return self

class UIColor:
    def __init__(self, c=COLOR.TRANSPARENT):
        self._c = c
    
    def get(self):
        return self._c

    def set(self, c):
        self._c = c
        return self

    @staticmethod
    def black():
        return UIColor(COLOR.BLACK)

    @staticmethod
    def blue():
        return UIColor(COLOR.BLUE)
    
    @staticmethod
    def green():
        return UIColor(COLOR.GREEN)

    @staticmethod
    def cyan():
        return UIColor(COLOR.CYAN)

    @staticmethod
    def red():
        return UIColor(COLOR.RED)
    
    @staticmethod
    def magenta():
        return UIColor(COLOR.MAGENTA)

    @staticmethod
    def yellow():
        return UIColor(COLOR.YELLOW)

    @staticmethod
    def gray():
        return UIColor(COLOR.GRAY)

    @staticmethod
    def dark_gray():
        return UIColor(COLOR.DARK_GRAY)

    @staticmethod
    def light_blue():
        return UIColor(COLOR.LIGHT_BLUE)

    @staticmethod
    def light_green():
        return UIColor(COLOR.LIGHT_GREEN)

    @staticmethod
    def light_cyan():
        return UIColor(COLOR.LIGHT_CYAN)

    @staticmethod
    def light_red():
        return UIColor(COLOR.LIGHT_RED)

    @staticmethod
    def light_magenta():
        return UIColor(COLOR.LIGHT_MAGENTA)

    @staticmethod
    def light_yellow():
        return UIColor(COLOR.LIGHT_YELLOW)

    @staticmethod
    def white():
        return UIColor(COLOR.WHITE)

    @staticmethod
    def transparent():
        return UIColor(COLOR.TRANSPARENT)

class UIElement:
    def __init__(self):
        self._fore = UIColor.gray()
        self._back = UIColor.transparent()
        self._pos = Position()
        self._size = Size()
        self._max_size = Size()
        self._clip_pos = Position()
        self._clip_size = Size()
        self._clip_children = False
        self._clip_tl_offset = Position()
        self._clip_br_offset = Position()
        self._children = []
        self._parent = None
        self._visible = True

    def fore_color(self):
        return self._fore

    def set_fore_color(self, c):
        self._fore = c
        return self

    def back_color(self):
        return self._back
    
    def set_back_color(self, c):
        self._back = c
        return self

    def absolute_position(self):
        p = Position(self.position().x(), self.position().y())
        parent = self.parent()
        while parent is not None:
            p.set(p.x() + parent.position().x(), p.y() + parent.position().y())
            parent = parent.parent()
        return p

    def position(self):
        return self._pos

    def set_position(self, p):
        self._pos = p
        return self
        
    def set_x_y(self, x, y):
        self._pos.set_x(x)
        self._pos.set_y(y)
        return self

    def size(self):
        return self._size

    def set_size(self, s):
        self._size = s
        self._check_size()
        return self

    def set_w_h(self, w, h):
        self._size.set_width(w)
        self._size.set_height(h)
        self._check_size()
        return self

    def size_to_fit_children(self):
        max_x = 0
        max_y = 0

        for child in self.children():
            right_edge = child.position().x() + child.size().width()
            if right_edge > max_x:
                max_x = right_edge
            bottom_edge = child.position().y() + child.size().height()
            if bottom_edge > max_y:
                max_y = bottom_edge

        self.set_w_h(max_x, max_y)

    def max_size(self):
        return self._max_size

    def set_max_size(self, s):
        self._max_size = s
        self._check_size()
        return self

    def set_max_w_h(self, w, h):
        self._max_size.set_width(w)
        self._max_size.set_height(h)
        self._check_size()
        return self

    def children(self):
        return self._children

    def add_child(self, c):
        self._children.append(c)
        c._parent = self
        return self

    def remove_child(self, c):
        c._parent = None
        self._children.remove(c)

    def clear_children(self):
        for child in self.children():
            child._parent = None
        self._children = []

    def remove_from_parent(self):
        if self.parent() is not None:
            self.parent().remove_child(self)

    def render(self):
        old_colors = CONSOLE_COLOR.colors()
        colors = CONSOLE_COLOR.translate_fb(self.fore_color().get(), self.back_color().get())

        if self.back_color() == COLOR.TRANSPARENT:
            colors = CONSOLE_COLOR.translate(self.fore_color().get()) | (old_colors & 0xF0)
        if self.fore_color() == COLOR.TRANSPARENT:
            colors = CONSOLE_COLOR.translate(self.back_color().get()) & 0x0F

        set_cursor_position(self.absolute_position())
        CONSOLE_COLOR.set_colors(colors)

        self.draw()

        me_cp = self.clip_position()
        me_cp.set(me_cp.x() + self.clip_tl_offset().x(), me_cp.y() + self.clip_tl_offset().y())
        me_cs = self.clip_size()
        me_cs.set(me_cs.width() - self.clip_br_offset().x(), me_cs.height() - self.clip_br_offset().y())

        if me_cs.width() <= 0:
            me_cs.set_width(self.size().width() - self.clip_br_offset().x())
        if me_cs.height() <= 0:
            me_cs.set_height(self.size().height() - self.clip_br_offset().y())

        edge = Position(me_cs.width() + me_cp.x(), me_cs.height() + me_cp.y())

        for child in self.children():
            if not child.visible():
                continue
            c_pos = child.position()
            c_size = child.size()
            old_cp = child.clip_position()
            old_cs = child.clip_size()

            if not self.clip_children() or c_pos.x() + c_size.width() >= me_cp.x() or c_pos.x() <= self.size().width():
                if self.clip_children() and (c_pos.x() > me_cp.x() + me_cs.width() or c_pos.x() + c_size.width() < me_cp.x() or c_pos.y() > me_cp.y() + me_cs.height() or c_pos.y() + c_size.height() < me_cp.y()):
                    continue

                new_cp = Position()
                new_cs = Size()

                if c_pos.x() < me_cp.x():
                    diff = me_cp.x() - c_pos.x()
                    if diff < old_cp.x():
                        new_cp.set_x(old_cp.x())
                    else:
                        new_cp.set_x(diff)
                    
                    if old_cs.width() == 0:
                        new_cs.set_width(me_cs.width())
                    else:
                        old_right_clip = old_cp.x() + old_cs.width()
                        new_cs.set_width(old_right_clip - new_cp.x())
                
                if c_pos.x() + c_size.width() > edge.x():
                    new_cp.set_x(old_cp.x())

                    if old_cs.width() == 0 or new_cp.x() + old_cs.width() >= edge.x():
                        new_cs.set_width(edge.x() - new_cp.x())
                    else:
                        new_cs.set_width(old_cs.width())

                if c_pos.y() < me_cp.y():
                    diff = me_cp.y() - c_pos.y()
                    if diff < old_cp.y():
                        new_cp.set_y(old_cp.y())
                    else:
                        new_cp.set_y(diff)
                    
                    if old_cs.height() == 0:
                        new_cs.set_height(me_cs.height())
                    else:
                        old_bottom_clip = old_cp.y() + old_cs.height()
                        new_cs.set_height(old_bottom_clip - new_cp.y())

                if c_pos.y() + c_size.height() > edge.y():
                    new_cp.set_y(old_cp.y())

                    if old_cs.width() == 0 or new_cp.y() + old_cs.height() >= edge.y():
                        new_cs.set_height(edge.y() - new_cp.y())
                    else:
                        new_cs.set_height(old_cs.height())

                if self.clip_children():
                    child.set_clip(new_cp, new_cs)
                
                child.render()

                if self.clip_children():
                    child.set_clip(old_cp, old_cs)

        CONSOLE_COLOR.set_colors(old_colors)

    def draw(self):
        print_wrapper('UIElement::draw() NOT IMPLEMENTED!!!')

    def clip_position(self):
        return self._clip_pos

    def clip_size(self):
        return self._clip_size

    def set_clip(self, pos, size):
        self._clip_pos = pos
        self._clip_size = size
        return self

    def set_clip_area(self, x, y, w, h):
        self._clip_pos.set_x(x)
        self._clip_pos.set_y(y)
        self._clip_size.set_width(w)
        self._clip_size.set_height(h)
        return self

    def clip_children(self):
        return self._clip_children

    def set_clip_children(self, c):
        self._clip_children = c
        return self

    def clip_tl_offset(self):
        return self._clip_tl_offset

    def clip_br_offset(self):
        return self._clip_br_offset

    def set_clip_offsets(self, top, left, bottom, right):
        self._clip_tl_offset.set_x(left)
        self._clip_tl_offset.set_y(top)
        self._clip_br_offset.set_x(right)
        self._clip_br_offset.set_y(bottom)
        return self

    def visible(self):
        return self._visible

    def set_visible(self, v):
        self._visible = v
        return self

    def parent(self):
        return self._parent

    def _check_size(self):
        if self.size().width() > self.max_size().width() and self.max_size().width() > 0:
            self._size.set_width(self.max_size().width())

        if self.size().height() > self.max_size().height() and self.max_size().height() > 0:
            self._size.set_height(self.max_size().height())

class UIInterface(UIElement):
    def __init__(self):
        UIElement.__init__(self)

    def draw(self):
        if self.back_color() is not COLOR.TRANSPARENT:
            pos = self.absolute_position()

            c_pos = Position(self.clip_position().x() + pos.x(), pos.y() + self.clip_position().y())
            c_size = self.clip_size()

            if c_size.width() == 0:
                c_size.set_width(self.size().width() + pos.x() - c_pos.x())

            if c_size.height() == 0:
                c_size.set_height(self.size().height() + pos.y() - c_pos.y())
            
            buffer = ''
            for _ in range(c_pos.x() - pos.x(), c_size.width()):
                buffer = buffer + ' '
            
            if pos.y() >= c_pos.y():
                set_cursor_position(c_pos)
                print_wrapper(buffer)
                buffer = ''

            for _ in range(c_pos.x() - pos.x(), c_size.width()):
                buffer = buffer + ' '
            
            for i in range(c_pos.y() - pos.y() + 1, c_size.height()):
                set_cursor_position(Position(c_pos.x(), c_pos.y() + i))
                print_wrapper(buffer)

            buffer = ''

            for _ in range(c_pos.x() - pos.x(), c_size.width()):
                buffer = buffer + ' '

            if pos.y() + self.size().height() <= c_pos.y() + c_size.height():
                set_cursor_position(Position(pos.x(), pos.y() + self.size().height() - 1))
                print_wrapper(buffer)

class Frame(UIElement):
    def __init__(self):
        UIElement.__init__(self)
        self._v_border = '|'
        self._h_border = '-'
        self._corner = '+'
        self.set_back_color(UIColor.black())

    @staticmethod
    def with_graphics(v_b='|', h_b='-', c='+'):
        f = Frame()
        f._v_border = v_b
        f._h_border = h_b
        f._corner = c
        return f

    @staticmethod
    def with_fore(f_c):
        f = Frame()
        f.set_fore_color(f_c)
        return f

    @staticmethod
    def with_rect(pos, size):
        f = Frame()
        f.set_position(pos)
        f.set_size(size)
        return f

    @staticmethod
    def with_xywh(x, y, w, h):
        f = Frame()
        f.set_x_y(x, y)
        f.set_w_h(w, h)
        return f

    @staticmethod
    def with_fore_rect(c, pos, size):
        f = Frame()
        f.set_fore_color(c)
        f.set_position(pos)
        f.set_size(size)
        return f

    @staticmethod
    def with_fore_xywh(c, x, y, w, h):
        f = Frame()
        f.set_fore_color(c)
        f.set_x_y(x, y)
        f.set_w_h(w, h)
        return f

    def draw(self):
        pos = self.absolute_position()

        c_pos = Position(self.clip_position().x() + pos.x(), pos.y() + self.clip_position().y())
        c_size = self.clip_size()

        if c_size.width() == 0:
            c_size.set_width(self.size().width() + pos.x() - c_pos.x())

        if c_size.height() == 0:
            c_size.set_height(self.size().height() + pos.y() - c_pos.y())

        buffer = ''
        for i in range(c_pos.x() - pos.x(), c_size.width()):
            if i == 0 or i == self.size().width() - 1:
                buffer = buffer + self.corner()
            else:
                buffer = buffer + self.horizontal_border()

        if pos.y() >= c_pos.y():
            set_cursor_position(c_pos)
            print_wrapper(buffer)
            buffer = ''

        for j in range(c_pos.x() - pos.x(), c_size.width()):
            if j == 0 or j == self.size().width() - 1:
                buffer = buffer + self.vertical_border()
            else:
                buffer = buffer + ' '

        for i in range(c_pos.y() - pos.y() + 1, c_size.height() - 1):
            set_cursor_position(Position(c_pos.x(), c_pos.y() + i))

            if self.back_color().get() is not COLOR.TRANSPARENT:
                print_wrapper(buffer)
            elif self.fore_color().get() is not COLOR.TRANSPARENT:
                print_wrapper(buffer[0])
                set_cursor_position(Position(c_pos.x() + len(buffer) - 1, c_pos.y() + i))
                print_wrapper(buffer[-1])

        buffer = ''

        for i in range(c_pos.x() - pos.x(), c_size.width()):
            if i == 0 or i == self.size().width() - 1:
                buffer = buffer + self.corner()
            else:
                buffer = buffer + self.horizontal_border()

        if pos.y() + self.size().height() <= c_pos.y() + c_size.height():
            set_cursor_position(Position(pos.x(), pos.y() + self.size().height() - 1))
            print_wrapper(buffer)

    def vertical_border(self):
        return self._v_border

    def set_vertical_border(self, v_b):
        self._v_border = v_b
        return self

    def horizontal_border(self):
        return self._h_border

    def set_horizontal_border(self, h_b):
        self._h_border = h_b
        return self

    def corner(self):
        return self._corner

    def set_corner(self, c):
        self._corner = c
        return self
    
    def set_graphics(self, v_b, v_h, c):
        self.set_vertical_border(v_b)
        self.set_horizontal_border(v_h)
        self.set_corner(c)
        return self

    def size_to_fit_children(self):
        self.size_to_fit_children()
        self.set_w_h(self.size().width() + 1, self.size().height() + 1)
        return self

class ScrollerFrame(Frame):
    def __init__(self):
        Frame.__init__(self)

    @staticmethod
    def with_graphics(v_b='|', h_b='-', c='+'):
        f = ScrollerFrame()
        f._v_border = v_b
        f._h_border = h_b
        f._corner = c
        return f

    @staticmethod
    def with_fore(f_c):
        f = ScrollerFrame()
        f.set_fore_color(f_c)
        return f

    @staticmethod
    def with_rect(pos, size):
        f = ScrollerFrame()
        f.set_position(pos)
        f.set_size(size)
        return f

    @staticmethod
    def with_xywh(x, y, w, h):
        f = ScrollerFrame()
        f.set_x_y(x, y)
        f.set_w_h(w, h)
        return f

    @staticmethod
    def with_fore_rect(c, pos, size):
        f = ScrollerFrame()
        f.set_fore_color(c)
        f.set_position(pos)
        f.set_size(size)
        return f

    @staticmethod
    def with_fore_xywh(c, x, y, w, h):
        f = ScrollerFrame()
        f.set_fore_color(c)
        f.set_x_y(x, y)
        f.set_w_h(w, h)
        return f

    def add_child(self, c):
        c.set_max_w_h(self.size().width() - 2, 0)
        c.set_w_h(self.size().width() - 2, c.size().height())
        
        Frame.add_child(self, c)

        bottom_y = self.size().height() - 1
        for child in reversed(self.children()):
            child.set_x_y(1, bottom_y - child.size().height())
            bottom_y = child.position().y()
    
class Label(UIElement):
    def __init__(self):
        UIElement.__init__(self)
        self._text = ''
        self._t_v_align = ALIGNMENT.BEGIN
        self._t_h_align = ALIGNMENT.BEGIN
        self._wrap = WRAP_MODE.WORD
        self._multiline = True

    @staticmethod
    def with_text(t):
        l = Label()
        l.set_text(t)
        return l

    @staticmethod
    def with_rect(p, s):
        l = Label()
        l.set_position(p)
        l.set_size(s)
        return l

    @staticmethod
    def with_xywh(x, y, w, h):
        l = Label()
        l.set_x_y(x, y)
        l.set_w_h(w, h)
        return l

    @staticmethod
    def with_text_rect(t, p, s):
        l = Label()
        l.set_text(t)
        l.set_position(p)
        l.set_size(s)
        return l

    @staticmethod
    def with_text_xywh(t, x, y, w, h):
        l = Label()
        l.set_text(t)
        l.set_x_y(x, y)
        l.set_w_h(w, h)
        return l

    def draw(self):
        pos = self.absolute_position()
        buffer = ''

        if self.back_color().get() is not COLOR.TRANSPARENT:
            for y in range(0, self.size().height()):
                set_cursor_position(Position(pos.x() + self.clip_position().x(), pos.y() + y))

                min_x = pos.x()
                max_w = self.size().width()
                if self.clip_position().x() is not 0:
                    min_x = self.clip_position().x()
                if self.clip_size().width() is not 0:
                    max_w = min(self.clip_size().width(), self.size().width())
                
                for _ in range(min_x, min_x + max_w):
                    buffer = buffer + ' '
                
                if self.clip_size().height() == 0 or (y >= self.clip_position().y() and y < self.clip_position().y() + self.clip_size().height()):
                    print_wrapper(buffer)
                buffer = ''

        buffer = ''
        set_cursor_x_y(pos.x(), pos.y())

        lines = []
        last_char_idx = 0

        while last_char_idx < len(self.text()):
            if len(lines) == 0 or ((len(lines[-1]) + len(buffer) > self.size().width()) and len(lines) < self.size().height()):
                lines.append('')
            elif ((len(lines) > 0 and len(lines[-1]) + len(buffer) > self.size().width() and (not self.multiline() or len(lines) >= self.size().height()))):
                break

            next = self.text()[last_char_idx]
            if next == '\n' and self.multiline():
                if self.wrap_mode() == WRAP_MODE.WORD:
                    lines[-1] = lines[-1] + buffer
                    buffer = ''
                lines.append('')
                last_char_idx = last_char_idx + 1
                continue
            
            if self.wrap_mode() == WRAP_MODE.TRUNCATE:
                lines[-1] = lines[-1] + next
            elif self.wrap_mode() == WRAP_MODE.WORD:
                if next == ' ':
                    if len(lines) == 0:
                        lines.append(buffer)
                    else:
                        lines[-1] = lines[-1] + buffer + next
                    buffer = ''
                else:
                    buffer = buffer + next
            last_char_idx = last_char_idx + 1
        
        if not buffer == '':
            if (len(lines) == 0 or ((len(lines[-1]) + len(buffer) >= self.size().width() and self.multiline() and len(buffer) <= self.size().width() and len(lines) < self.size().height()))):
                lines.append(buffer)
            elif len(lines) > 0 and len(lines[-1]) + len(buffer) <= self.size().width() and (self.wrap_mode() == WRAP_MODE.TRUNCATE or last_char_idx >= len(self.text())):
                lines[-1] = lines[-1] + buffer

        for i in range(0, len(lines)):
            line_start_x = 0
            line_start_y = 0

            r = lines[i]
            if self.wrap_mode() == WRAP_MODE.TRUNCATE:
                r = r.rstrip()
            
            if self.text_h_align() == ALIGNMENT.CENTER:
                line_start_x = (self.size().width() / 2 - len(r) / 2)
            elif self.text_h_align() == ALIGNMENT.END:
                line_start_x = self.size().width() - len(r)

            if self.text_v_align() == ALIGNMENT.CENTER:
                line_start_y = (self.size().height() / 2 - len(lines) / 2)
            elif self.text_v_align() == ALIGNMENT.END:
                line_start_y = self.size().height() - len(lines)

            sub_idx = 0
            sub_len = len(r)
            if line_start_x <= self.clip_position().x():
                sub_idx = self.clip_position().x() - line_start_x
                line_start_x = self.clip_position().x()
                sub_len = sub_len - sub_idx

            if not self.clip_size().width() == 0 and line_start_x + sub_len >= self.clip_position().x() + self.clip_size().width():
                sub_len = sub_len - self.clip_position().x() + self.clip_size().width() - (line_start_x + sub_len)

            test_clip_y = line_start_y + i
            print_y = pos.y() + test_clip_y
            set_cursor_x_y(pos.x() + int(line_start_x), int(print_y))

            if print_y >= 0 and sub_len > 0 and (self.clip_size().height() == 0 or (test_clip_y >= self.clip_position().y() and test_clip_y < self.clip_position().y() + self.clip_size().height())):
                print_wrapper(r[int(sub_idx):(int(sub_idx) + int(sub_len))])

    def text(self):
        return self._text

    def set_text(self, t):
        self._text = t
        self.set_w_h(len(t), 1)
        return self

    def size_to_fit_text(self):
        self.set_w_h(len(self.text()), 1)
        return self

    def text_v_align(self):
        return self._t_v_align

    def set_text_v_align(self, a):
        self._t_v_align = a
        return self
    
    def text_h_align(self):
        return self._t_h_align

    def set_text_h_align(self, a):
        self._t_h_align = a
        return self

    def multiline(self):
        return self._multiline

    def set_multiline(self, m):
        self._multiline = m
        return self

    def wrap_mode(self):
        return self._wrap

    def set_wrap_mode(self, w):
        self._wrap = w
        return self

    def _check_size(self):
        UIElement._check_size(self)

        buffer = ''
        lines = []
        last_char_idx = 0

        while last_char_idx < len(self.text()):
            if len(lines) == 0 or ((len(lines[-1]) + len(buffer) >= self.size().width() and self.multiline() and (self.max_size().height() == 0 or len(lines) < self.max_size().height()))):
                lines.append('')
            elif (len(lines) > 0 and len(lines[-1]) + len(buffer) >= self.size().width() and not self.multiline()) or (len(lines) > self.max_size().height() and not self.max_size().height() == 0):
                break

            next = self.text()[last_char_idx]

            if next == '\n' and self.multiline():
                if self.wrap_mode() == WRAP_MODE.WORD:
                    lines[-1] = lines[-1] + buffer
                    buffer = ''

                lines.append('')
                last_char_idx = last_char_idx + 1
                continue
            
            if self.wrap_mode() == WRAP_MODE.TRUNCATE:
                lines[-1] = lines[-1] + next
            elif self.wrap_mode() == WRAP_MODE.WORD:
                if next == ' ':
                    lines[-1] = lines[-1] + buffer + next
                    buffer = ''
                else:
                    buffer = buffer + next
            last_char_idx = last_char_idx + 1
        
        if not buffer == '':
            fits_in_line = len(lines[-1]) + len(buffer) <= self.size().width()
            buffer_fits = len(buffer) <= self.size().width()

            if len(lines) == 0 or (not fits_in_line and self.multiline() and buffer_fits and (self.max_size().height() == 0 or len(lines) < self.max_size().height())):
                lines.append(buffer)
            elif len(lines) > 0 and fits_in_line:
                lines[-1] = lines[-1] + buffer

        if len(lines) > self.size().height():
            self._size = Size(self.size().width(), len(lines))
        else:
            self._size = Size(self.size().width(), self.size().height())

        UIElement._check_size(self)

class ProgressBar(UIElement):
    def __init__(self):
        UIElement.__init__(self)
        self._progress = 0
        self._graphic = chr(219) if platform.system() == 'Windows' else u'\u2588'
        self._bar = Label()
        self._bar.set_x_y(0, 0)
        self._bar.set_w_h(0, 1)

    @staticmethod
    def with_rect(p, s):
        p = ProgressBar()
        p.set_position(p)
        p.set_size(s)
        return p

    @staticmethod
    def with_xywh(x, y, w, h):
        p = ProgressBar()
        p.set_x_y(x, y)
        p.set_w_h(w, h)
        return p

    def progress(self):
        return self._progress

    def set_progress(self, p):
        if self._bar.parent() is None:
            self.add_child(self._bar)

        self._progress = p

        self._bar.set_w_h(int(self.size().width() * p / 100.0), self.size().height())

        t = ''

        for _ in range(0, self._bar.size().width()):
            if not self.graphic() == 0:
                t = t + self.graphic()
            else:
                t = t + ' '

        self._bar.set_text(t)

        return self

    def graphic(self):
        return self._graphic

    def set_graphic(self, g):
        self._graphic = g
        self.set_progress(self.progress())
        return self

    def fore_color(self):
        return self._bar.fore_color()

    def set_fore_color(self, c):
        if not self._bar.text() == '':
            self._bar.set_fore_color(c)
            self._bar.set_back_color(UIColor.transparent())
        else:
            self._bar.set_back_color(c)

    def draw(self):
        for _ in range(0, self.size().width()):
            print_wrapper(' ')

class TextField(Label):
    def __init__(self):
        Label.__init__(self)

    @staticmethod
    def with_text(t):
        tf = TextField()
        tf.set_text(t)
        return tf

    @staticmethod
    def with_text_rect(t, p, s):
        tf = TextField()
        tf.set_text(t)
        tf.set_position(p)
        tf.set_size(s)
        return tf
    
    @staticmethod
    def with_text_xywh(t, x, y, w, h):
        tf = TextField()
        tf.set_text(t)
        tf.set_x_y(x, y)
        tf.set_w_h(w, h)
        return tf

    def focus(self):
        pos = self.absolute_position()
        set_cursor_position(Position(pos.x() + len(self.text()), pos.y()))

    def read(self):
        self.focus()
        return read_input()

class MessageWindow(ScrollerFrame):
    def __init__(self):
        ScrollerFrame.__init__(self)
        self.set_w_h(30, 10)
        self.set_fore_color(UIColor.green())
        self.set_back_color(UIColor.black())

    @staticmethod
    def with_graphics(v_b='|', h_b='-', c='+'):
        f = MessageWindow()
        f._v_border = v_b
        f._h_border = h_b
        f._corner = c
        return f

    @staticmethod
    def with_fore(f_c):
        f = MessageWindow()
        f.set_fore_color(f_c)
        return f

    @staticmethod
    def with_rect(pos, size):
        f = MessageWindow()
        f.set_position(pos)
        f.set_size(size)
        return f

    @staticmethod
    def with_xywh(x, y, w, h):
        f = MessageWindow()
        f.set_x_y(x, y)
        f.set_w_h(w, h)
        return f

    @staticmethod
    def with_fore_rect(c, pos, size):
        f = MessageWindow()
        f.set_fore_color(c)
        f.set_position(pos)
        f.set_size(size)
        return f

    @staticmethod
    def with_fore_xywh(c, x, y, w, h):
        f = MessageWindow()
        f.set_fore_color(c)
        f.set_x_y(x, y)
        f.set_w_h(w, h)
        return f

    def add_message(self, msg, c):
        l = Label.with_text(msg)
        l.set_fore_color(c)
        l.set_back_color(UIColor.black())
        self.add_child(l)

    def _check_size(self):
        self.set_clip_children(True)
        self.set_clip_area(0, 0, self.size().width(), self.size().height())
        return ScrollerFrame._check_size(self)


class TableCell(UIElement):
    def __init__(self, text=''):
        self._text = text

    def text(self):
        return self._text

    def set_text(self, text):
        self._text = text
        return self


class Table(Frame):
    def __init__(self, cols=0, rows=0):
        Frame.__init__(self)
        self._cells = []
        for row in range(0, rows):
            self._cells.append([])
            for col in range(0, cols):
                self._cells[row].append(TableCell())

    def add_column(self, count=1):
        for row in self._cells:
            for _ in range(0, count):
                row.append(TableCell())
        return self

    def remove_column(self, idx):
        for r in range(0, len(self._cells)):
            if idx >= 0 and idx < len(self._cells[r]):
                del self._cells[r][idx]
        return self

    def add_row(self, row=1):
        self._cells.append([])
        for _ in range(0, len(self._cells[0])):
            self._cells[-1].append(TableCell())
        return self

    def remove_row(self, idx):
        if idx >= 0 and idx < len(self._cells):
            del self._cells[idx]
        return self

    def column_count(self):
        if len(self._cells) > 0:
            return len(self._cells[0])
        return 0

    def row_count(self):
        return len(self._cells)

    def cell(self, col, row):
        if row >= 0 and row < len(self._cells):
            if col >= 0 and col <= len(self._cells[row]):
                return self._cells[row][col]
        return None

    def _row_division(self, col_widths):
        buffer = '+'
        pos = self.absolute_position()
        c_pos = Position(self.clip_position().x() + pos.x(), pos.y() + self.clip_position().y())
        c_size = self.clip_size()
        if c_size.width() == 0:
            c_size.set_width(self.size().width() + pos.x() - c_pos.x())
        if c_size.height() == 0:
            c_size.set_height(self.size().height() + pos.y() - c_pos.y())
        for col in range(0, len(col_widths)):
            for i in range(0, col_widths[col] + 1):
                if i == col_widths[col]:
                    buffer = buffer + self.corner()
                else:
                    buffer = buffer + self.horizontal_border()
        return buffer

    def draw(self):
        pos = self.absolute_position()

        buffer = ''
        col_widths = []
        total_width = 0

        if len(self._cells) > 0:
            for col in range(0, len(self._cells[0])):
                maxW = 0
                for row in range(0, len(self._cells)):
                    w = len(self._cells[row][col].text()) + 2
                    if w > maxW:
                        maxW = w
                col_widths.append(maxW)
                total_width = total_width + maxW
        else:
            return

        self.set_w_h(total_width, len(self._cells) * 2 + 1)

        c_pos = Position(self.clip_position().x() + pos.x(), pos.y() + self.clip_position().y())
        c_size = self.clip_size()
        if c_size.width() == 0:
            c_size.set_width(self.size().width() + pos.x() - c_pos.x())
        if c_size.height() == 0:
            c_size.set_height(self.size().height() + pos.y() - c_pos.y())

        if pos.y() >= c_pos.y():
            set_cursor_position(c_pos)
            print_wrapper(self._row_division(col_widths))
        buffer = ''

        for r in range(0, len(self._cells)):
            for c in range(0, len(self._cells[r])):
                buffer = buffer + self.vertical_border() + ' ' + self.cell(c, r).text()
                for _ in range(0, col_widths[c] - len(self.cell(c, r).text()) - 1):
                    buffer = buffer + ' '
            buffer = buffer + self.vertical_border()
            if pos.y() + r + 1 * (r + 1) >= c_pos.y() and pos.y() + r + 1 * (r + 1) <= c_pos.y() + c_size.height():
                set_cursor_position(Position(c_pos.x(), pos.y() + r + 1 * (r + 1)))
                print_wrapper(buffer)
                if pos.y() + r + 1 * (r + 1) + 1 >= c_pos.y() and pos.y() + r + 1 * (r + 1) + 1 <= c_pos.y() + c_size.height():
                    set_cursor_position(Position(c_pos.x(), pos.y() + r + 1 * (r + 1) + 1))
                    print_wrapper(self._row_division(col_widths))
            buffer = ''

if __name__ == '__main__':
    iface = UIInterface()
    iface.set_w_h(80, 25)

    f = Frame()
    f.set_w_h(40, 10)
    f.set_fore_color(UIColor.light_red())

    l = Label.with_text('Test of a long long text and an even longer one... Wait, there\'s more!')
    l.set_fore_color(UIColor.light_red())
    l.set_back_color(UIColor.white())
    l.set_max_w_h(f.size().width() / 2, 4)
    l.set_w_h(l.max_size().width(), 4)
    l.set_x_y(f.size().width() / 2 - l.size().width() / 2, f.size().height() / 2 - l.size().height() / 2)
    l.set_wrap_mode(WRAP_MODE.TRUNCATE)
    l.set_text_h_align(ALIGNMENT.CENTER)
    l.set_text_v_align(ALIGNMENT.CENTER)

    p = ProgressBar()
    p.set_x_y(1, 1)
    p.set_w_h(20, 1)
    p.set_progress(20.0)
    p.set_back_color(UIColor.gray())
    p.set_fore_color(UIColor.light_red())

    f.add_child(l)
    f.add_child(p)
    iface.add_child(f)

    iface.render()
    set_cursor_x_y(0, 10)