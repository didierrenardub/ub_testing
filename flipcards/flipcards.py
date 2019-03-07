from flipcards.player import Flipbot
from flipcards.tournament import Tournament
from common.connie import *
import random
import time

if __name__ == '__main__':
    start = time.time()
    t = Tournament(0.1)
    t.add_player(Flipbot('Didier', UIColor.light_blue()))
    t.play()
    print('\nRun time: ' + str(time.time() - start))
