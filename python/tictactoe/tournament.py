from tictactoe.match import Match
from functools import cmp_to_key
from common.connie import UIInterface, Table, TableCell
import random
import os

def better_player(a, b):
    if a.points() > b.points():
        return -1
    elif b.points() > a.points():
        return 1
    return 0


class Tournament():
    def __init__(self, print_wait_time=0.25):
        self._players = []
        self._matches = []
        self._print_wait_time = print_wait_time

    def add_player(self, player):
        if player is not None and player.name() is not None and player.name() != '':
            self._players.append(player)
        return self

    def play(self):
        for i in range(0, len(self._players)):
            for j in range(i + 1, len(self._players)):
                self._matches.append(Match(self._players[i], self._players[j], self._print_wait_time))
                self._matches.append(Match(self._players[j], self._players[i], self._print_wait_time))
        random.shuffle(self._matches)
        for m in self._matches:
            w = m.play()
            if w is not None:
                w.add_won()
                if w == m.home():
                    m.away().add_lost()
                else:
                    m.home().add_lost()
            else:
                m.home().add_drawn()
                m.away().add_drawn()
        self._players.sort(key=cmp_to_key(better_player))
        
        iface = UIInterface()
        iface.set_w_h(50, 24)
        headers = [ 'Player', 'Points', 'Won', 'Drawn', 'Lost' ]
        t = Table(len(headers), len(self._players) + 1)
        for i in range(0, len(headers)):
            t.cell(i, 0).set_text(headers[i])
        row = 1
        for p in self._players:
            vals = [ p.name(), p.points(), p.won(), p.drawn(), p.lost() ]
            for i in range(0, len(vals)):
                t.cell(i, row).set_text(str(vals[i]))
            row = row + 1
        iface.add_child(t)
        iface.render()
            #print(p.name() + ': ' + str(p.points()) + ' - ' + str(p.diff_flips()) + ' (' + str(p.total_flips()) + '/' + str(p.against_flips()) + ') - W: ' + str(p.won()) + ' D: ' + str(p.drawn()) + ' L: ' + str(p.lost()))
