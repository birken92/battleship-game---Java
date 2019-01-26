import java.util.Random;
/**
 * Write a description of class CoordinateGenerator here.
 * 
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class CoordinateGenerator
{
    private int minimumValue;
    private int maximumValue;

    /**
     * Constructor for objects of class CoordinateGenerator
     */
    public CoordinateGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
    }

    /**
     * Random number generator
     * Putting in the min and max number, this will be used in the game class. 
     * So that the computer can work and play against you. 
     * @param minimum value given by the system
     * @param maximum value given by the system used in gameclass
     * @return a random number from min and max given by the system
     */
    public int randomNumberGenerator(int min, int max)
    {
        Random coordinator = new Random();
        return coordinator.nextInt(max - min) + min;
    }
    
    public int generateRandom(int maximumNumber, int minimumNumber)
    {
        return (int)(Math.random() * (maximumNumber)%(maximumNumber - minimumNumber +1) + minimumNumber);
    }
}
