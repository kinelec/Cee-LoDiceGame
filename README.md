Cee-LoDiceGame
==============

A two player non-variant game of Cee-Lo with a GUI

Rules
==============
Each player takes turns rolling all three dice at once and must continue until a recognized combination is rolled.
Whichever player rolls the best combination wins the round and a new one begins. 
In cases where the players tie for the best combination, there is no winner for that round.

The combinations are ranked from best to worst as:
  4-5-6
    The highest possible roll. If you roll 4-5-6, you automatically win the round.
    
  “Trips”
    Rolling three of the same number is known as rolling “trips”.
    Higher trips beat lower trips, so 4-4-4 is better than 3-3-3.
    
	“Point”
		Rolling a pair, and another number, establishes the singleton as a “point”.
		A higher point beats a lower point, so 1-1-3 is better than 6-6-2.
							
	1-2-3
	  The lowest possible roll. If you roll 1-2-3, you automatically lose the round.

The first player to win 3 rounds wins the game.
