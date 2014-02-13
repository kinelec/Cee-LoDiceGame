package kinel.emily.dicegame;
import java.util.Random;


/**
 * Die class creates a die to be rolled
 * using java.util.Random to generate
 * a random integer between 1 and n.
 * @author Emily Kinel
 * October 7th, 2013
 */
public class Die implements Comparable<Object>{
	/* instance variables */
	private int numSides;
	private static final int MAX = 6;
	private int topFace;
	private static Random rng = new Random();

	/**Default constructor
	 * sets numSides equal to 6
	 * sets initial topFace to a random integer between 1 and 6
	 */
	public Die()
	{
		numSides = MAX;
		roll();		/* initial top to random integer */
	}
	
		
	/**Rolls the die by setting topFace equal 
	 * to a random integer between 1 and 6 
	 * using the Random() method
	 * @return topFace */
	public int roll()
	{
		return (topFace = rng.nextInt(numSides) + 1);
	}
		
	/**Accessor method
	 * @return topFace*/
	public int getTop()
	{
		return topFace;
	}
	
	/** Overrides equals(): 
	 * tests for equality by seeing if the values of topFace 
	 * of two die are the same. 
	 */
	public boolean equals(Object o)
	{
		if(o == this)
			return true;
		if(!(o instanceof Die))
			return false;
		Die cd = (Die) o;
		return (this.getTop() == cd.getTop());
	}

	/**Overrides hashCode(): 
	 * generates an integer hash value for a given die. 
	 * @return result
	 */
	public int hashCode()
	{
		int result = 17;
		result = 31 * result + getTop();
		return result;
	}
	
	/** Overrides toString(): 
	 * returns a String that describes a given die 
	 * by its numSides and topFace.
	 */
	public String toString()
	{
		return ("\nTop of the die: " + getTop());
	}
	
	/** Compares two dice by looking at the values returned of their
	 * getTop() method. 
	 * 
	 * If the value of topFace returned by the getTop() method 
	 * of the first Die is less than the value of the Die we're comparing it with, 
	 * it will return -1.
	 * 
	 * If the value of topFace returned by the getTop() method
	 * of the first Die is greater than the value of the Die we're comparing it with,
	 * it will return 1.
	 * 
	 * Else it will return 0.
	 */
	public int compareTo(Object o)
	{
		Die other = (Die) o;
		if(this.getTop() < other.getTop())
			return -1;
		if(this.getTop() > other.getTop())
			return 1;
		return 0;
	}
}
