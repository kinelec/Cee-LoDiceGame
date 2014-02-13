package kinel.emily.dicegame;


import java.util.ArrayList;
import java.util.List;

/**
 * DiceGame is the logic behind the GUI.
 * It creates an ArrayList of 3 die and determines who wins each round/the game.
 * @author EmilyK
 *
 */
public class DiceGame{
	List<Die> dice;
	private int point = 0;
	private int triples = 0;
	private boolean reroll = true;
	private boolean win;
	private boolean lose;
	private int player1Score;
	private int player2Score;
	private boolean lastTrips;
	private boolean lastDoubs;
	private boolean player1 = true;
	private boolean player2;
	private int lastRoll;
	private int thisRoll;
	private boolean tie;
	private int round = 1;
	
	/**
	 * Constructor: creates an ArrayList of three Die
	 */
	public DiceGame(){
		 dice = new ArrayList<Die>(); // parameterized list

	     dice.add(new Die());
	     dice.add(new Die());
	     dice.add(new Die());
	}
	
	/**
	 * Rolls each die in the ArrayList
	 */
	public void rollDice(){
		for (Die d : dice) 
	         d.roll(); 
	}
	
	/**
	 * Accessor Method
	 * @return the top of first die in the ArrayList
	 */
	public int getTopD1(){
		return dice.get(0).getTop();
	}
	
	/**
	 * Accessor Method
	 * @return the top of the second die in the ArrayList
	 */
	public int getTopD2(){
		return dice.get(1).getTop();
	}
	
	/**
	 * Accessor Method
	 * @return the top of the third die in the ArrayList
	 */
	public int getTopD3(){
		return dice.get(2).getTop();
	}
	
	/**
	 * Checks to see if the tops of the die in the ArrayList are 4, 5, and 6 in any order.
	 * If it is, then the boolean value reroll is set to false 
	 * and the boolean value win is set to true
	 * @return true if a 4-5-6 (in any order) was rolled, and false if not
	 */
	public boolean autoWin(){
		if(getTopD1() == 4 && getTopD2() == 5 && getTopD3() == 6){
			reroll = false;
			win = true;
			return true;
		}
		if(getTopD1() == 4 && getTopD2() == 6 && getTopD3() == 5){
			reroll = false;
			win = true;
			return true;
		}
		if(getTopD1() == 5 && getTopD2() == 4 && getTopD3() == 6){
			reroll = false;
			win = true;
			return true;
		}
		if(getTopD1() == 5 && getTopD2() == 6 && getTopD3() == 4){
			reroll = false;
			win = true;
			return true;
		}
		if(getTopD1() == 6 && getTopD2() == 4 && getTopD3() == 5){
			reroll = false;
			win = true;
			return true;
		}
		if(getTopD1() == 6 && getTopD2() == 5 && getTopD3() == 4){
			reroll = false;
			win = true;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks to see if the tops of the die in the ArrayList are 1, 2, and 3 in any order.
	 * If it is, then the boolean value reroll is set to false 
	 * and the boolean value lose is set to true
	 * @return true if 1-2-3 (in any order) was rolled, and false if not
	 */
	public boolean autoLose(){
		if(getTopD1() == 1 && getTopD2() == 2 && getTopD3() == 3){
			reroll = false;
			lose = true;
			return true;
		}
		if(getTopD1() == 1 && getTopD2() == 3 && getTopD3() == 2){
			reroll = false;
			lose = true;
			return true;
		}
		if(getTopD1() == 2 && getTopD2() == 1 && getTopD3() == 3){
			reroll = false;
			lose = true;
			return true;
		}
		if(getTopD1() == 2 && getTopD2() == 3 && getTopD3() == 1){
			reroll = false;
			lose = true;
			return true;
		}
		if(getTopD1() == 3 && getTopD2() == 1 && getTopD3() == 2){
			reroll = false;
			lose = true;
			return true;
		}
		if(getTopD1() == 3 && getTopD2() == 2 && getTopD3() == 1){
			reroll = false;
			lose = true;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks to see if all three of the tops of the die in the ArrayList equal.
	 * If they are, then the boolean value reroll is set to false 
	 * and the ints thisRoll and triples is set to the top of the first die
	 * @return true if the tops of all three die are the same, and false if not
	 */
	public boolean trips(){
		if((getTopD1() == getTopD2()) && (getTopD1() == getTopD3())){
			reroll = false;
			triples = getTopD1();
			thisRoll = triples;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks to see if two of the tops of the die in the ArrayList are equal and one is not.
	 * If this is the case, then the boolean value reroll is set to false 
	 * and the ints thisRoll and point are set equal to the top of whatever die in the ArrayList 
	 * is not equal to the other two.
	 * @return true if two tops of the die are the same and one is different, and false if not
	 */
	public boolean point(){
		if((getTopD1() == getTopD2()) && (getTopD1() != getTopD3())){
			reroll = false;
			point = getTopD3();
			thisRoll = point;
			return true;
		}
		if((getTopD1() == getTopD3()) && (getTopD1() != getTopD2())){
			reroll = false;
			point = getTopD2();
			thisRoll = point;
			return true;
		}
		if((getTopD2() == getTopD3()) && (getTopD2() != getTopD1())){
			reroll = false;
			point = getTopD1();
			thisRoll = point;
			return true;
		}
		else
			return false;	
	}
	
	/**
	 * When triples or doubles are rolled, this method figures out which player won or lost the round, or if it was a tie.
	 * 
	 * If both players rolled triples or both players rolled doubles, 
	 * it compares the values of thisRoll and lastRoll,
	 * setting win equal to true if thisRoll is greater than lastRoll,
	 * setting lose equal to true if thisRoll is less than lastRoll,
	 * or setting tie equal to true if thisRoll is equal to lastRoll.
	 * 
	 * If the current player rolled triples and the other player rolled doubles,
	 * win is set to true.
	 * 
	 * If the current player rolled doubles and the other player rolled triples,
	 * loase is set to true.
	 */
	public void tripsPointLogic(){
		if(lastTrips == true && trips() == true){
			if(thisRoll > lastRoll){
				win = true;
			}
			if(thisRoll > lastRoll){
				lose = true;
			}
			if(thisRoll == lastRoll){
				tie = true;
			}
		}
		if(trips() == true && lastDoubs == true){
			win = true;
		}
		if(point() == true && lastTrips == true){
			lose = true;
		}
		if(lastDoubs == true && point() == true){
			if(thisRoll > lastRoll){
				win = true;
			}
			if(thisRoll < lastRoll){
				lose = true;
			}
			if(thisRoll == lastRoll){
				tie = true;
			}
		}
	}
	
	/**
	 * Keeps track of the score of the two players.
	 * If win is true then whatever player is also true (player1 or player2)
	 * gets one point added to their current score.
	 * If lose is true then whatever player is false (player1 or player2)
	 * gets one point added to their current score.
	 */
	public void score(){
		if(win == true && player1 == true){
			player1Score = player1Score + 1;
		}
		else if(lose == true && player1 == true){
			player2Score = player2Score + 1;
			
		}
		if(win == true && player2 == true){
			player2Score = player2Score + 1;
		}
		else if(lose == true && player2 == true){
			player1Score = player1Score + 1;
		}
	}
	
	/**
	 * If triples or doubles were rolled, it sets lastRoll equal to thisRoll,
	 * then sets thisRoll equal to 0, and sets lastTrips equal to true if triples were rolled
	 * and sets lastDoubs equal to true if doubles were rolled
	 */
	public void setLastRoll(){
		if(reroll == false){
			if(trips() == true && thisRoll == triples){
				lastRoll = thisRoll;
				thisRoll = 0;
				lastTrips = true;
			}
			if(point() == true && thisRoll == point){
				lastRoll = thisRoll;
				thisRoll = 0;
				lastDoubs = true;
			}
		}
	}
	
	/**
	 * Accessor Method
	 * @return true if the boolean value of tie is true, otherwise returns false
	 */
	public boolean isTie(){
		if(tie == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Accessor Method
	 * @return thisRoll
	 */
	public int getThisRoll(){
		return thisRoll;
	}
	
	/**
	 * Accessor Method
	 * @return player1Score
	 */
	public int getPlayer1Score(){
		return player1Score;
	}
	
	/**
	 * Accessor Method
	 * @return player2Score
	 */
	public int getPlayer2Score(){
		return player2Score;
	}
	
	/**
	 * Returns whether or not player1 has won a round.
	 * @return true if player1 is true & win is true or if player2 is true and lose is true, otherwise it returns false
	 */
	public boolean player1Win(){
		if(win == true && player1 == true)
			return true;
		if(lose == true && player1 == true)
			return false;
		if(win == true && player2 == true)
			return false;
		if(lose == true && player2 == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Switches between players. 
	 * If it is currently player1's turn (player1 is set to true), 
	 * then it sets player1 to false, and player2 to true.
	 * If it is currently player2's turn (player2 is set to true),
	 * then it sets player2 to false and player1 to true.
	 */
	public void switchPlayers(){
		if(player1 == true){
			player1 = false;
			player2 = true;
		}
		else{
			player2 = false;
			player1 = true;
		}
	}
	
	/**
	 * Ends a player's turn
	 * Switches players, sets reroll equal to true, and clears the values of point and triples
	 */
	public void endTurn(){
		if(reroll == false){
			switchPlayers();
			reroll = true;
			point = 0;
			triples = 0;
		}
	}
	
	/**
	 * Accessor Method
	 * @return true if player1 is true, otherwise returns false
	 */
	public boolean player1Turn(){
		if(player1 == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Accessor Method
	 * @return true if reroll is true, otherwise returns false
	 */
	public boolean isReroll(){
		if(reroll == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Accessor Method
	 * @return round
	 */
	public int getRounds(){
		return round;
	}
	
	/**
	 * Checks to see if the game is over
	 * @return true if either players score is set to 3, otherwise returns false
	 */
	public boolean gameOver(){
		if(player1Score == 3){
			return true;
		}
		if(player2Score == 3){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Ends a round.
	 * Clears the values of thisRoll and lastRoll,
	 * sets win, lose, tie, lastTrips, and lastDoubs all equal to false,
	 * and increments the value of round by 1
	 */
	public void endRound(){
		lastRoll = 0;
		thisRoll = 0;
		lastTrips = false;
		win = false;
		lose = false;
		lastDoubs = false;
		tie = false;
		round++;
	}
	
	/**
	 * Accessor Method
	 * @return true if win, lose, or tie are equal to true, otherwise returns false
	 */
	public boolean isEndRound(){
		if(win == true || lose == true)
			return true;
		if(tie == true)
			return true;
		else
			return false;
	}
	
	/**
	 * Prints out the results after each roll. 
	 */
	public void getResults(){
		System.out.println("----------");
		System.out.println("ROUND " + round);
		System.out.println("----------");
		if(player1 == true){
			System.out.println("Player 1's roll:");
		}
		if(player2 == true){
			System.out.println("Player 2's roll:");
		}
		System.out.println("Die 1: " + getTopD1());
		System.out.println("Die 2: " + getTopD2());
		System.out.println("Die 3: " + getTopD3());
		if(autoWin() == true)
			System.out.println("AUTOWIN!");
		if(autoLose() == true)
			System.out.println("AUTOLOSE :(");
		if(trips() == true){
			System.out.println("TRIPLES!");
			System.out.println("Triple " + triples + "'s rolled.");
		}
		if(point() == true){
			System.out.println("DOUBLES!");
			System.out.println("Point:" + point);
		}
		if(isReroll() == true)
			System.out.println("Please reroll.");
		if(isEndRound() == true){
			System.out.println("End of round.");
			if(player1Win() == true){
				System.out.println("Player 1 wins round " + round);
			}
			else if(player1Win() == false)
				System.out.println("Player 2 wins round " + round);
			else
				System.out.println("It's a tie! No one wins roud " + round);
			System.out.println("-------------------------");
			System.out.println("Score after round " + round + ":");
			System.out.println("-------------------------");
			System.out.println("Player 1: " + getPlayer1Score() + "\nPlayer 2: " + getPlayer2Score());
			endRound();
			if(gameOver() == true){
				System.out.println("GAME OVER");
				if(player1Score == 5)
						System.out.println("Player 1 wins!");
				else
					System.out.println("Player 2 wins!");
			}
		}
		endTurn();
	}
	
}

