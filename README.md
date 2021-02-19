# Monte-Carlo-Simulation
Monte Carlo Simulation of a Random Walk 


The game starts with X dollars in the user posession.
  | X amount
--- | --- 
 1| $10
 2| $100
 3| $1000
 
 | Number        |X amount           
| ------------- |-----:|
| 1      | $10 |
| 2      |  $100     |
| 3 |    $1000 |
 
 The original number of runs of each game is 50. this number also depends on the amount of money the user has at the end of each run. 
 The user is allowed to play the next run until he loses all the money or until he wins 100 in addition to the amount of money
 he started with (X+100).
 
 To determine if the user gets an additional dollar or loses a dollar, the probability of winning Y is used.
 
   | Y probability
--- | --- 
 1| 0.40
 2| 18/37 (roulette odds)
 3| 0.50
 
 
 There are 9 combinations of starting amount of money and the porbability. 
 
The objective of the program is to find the following:
    a) the number of times needed to win the game;
    b) the number of bets on average is necessary to make in order to complete the game, meaning to win or lose the game.
 
