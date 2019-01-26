import java.util.Scanner;
/**
 * Input class, this is where the Scanner class is used
 * This class will only interact with the user
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class Input
{
    private Scanner console = new Scanner(System.in);

    /**
     * Constructor for objects of class Input
     */
    public Input()
    {
        
    }

    /**
     * Start of the, only click enter to continue
     */
    public void gameInput()
    {
        String start;
        start = console.nextLine();
    }
    
    /**
     * Get input from user
     * @return returning user input to gameclass
     */
    public String userInput()
    {
        String start;
        start = console.nextLine().trim();
        return start;
    }
}
