from tictactoe.player import Tictacbot
from tictactoe.tournament import Tournament
from common.connie import *
import random
import importlib
import time
import os

def load_players(colors):
    current_color = 0
    players = []
    created = []
    for obj in os.listdir(os.path.join(os.path.dirname(sys.argv[0]), 'tictactoe', 'players')):
        if obj.endswith('.py'):
            players.append(obj.rstrip('.py'))
    players.remove('__init__')
    for player_name in players:
        player = importlib.import_module('tictactoe.players.' + player_name)
        p = None
        try:
            p = getattr(player, 'create')(colors[current_color])
        except:
            pass
        if p is not None:
            created.append(p)
        current_color = current_color + 1
        if current_color >= len(colors):
            current_color = 0
    return created

if __name__ == '__main__':
    start = time.time()
    colors = [ UIColor.light_blue(), UIColor.light_red(), UIColor.light_green(), UIColor.light_yellow(), UIColor.light_magenta() ]
    t = Tournament(1.0)
    for player in load_players(colors):
        t.add_player(player)
    t.play()
    print('\nRun time: ' + str(time.time() - start))
