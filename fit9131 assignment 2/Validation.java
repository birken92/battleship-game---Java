/**
 * Class validations
 * used to make sure the inputs are valid, so the game do not crash!
 * 
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class Validation
{

    /**
     * Constructor for objects of class Validation
     */
    public Validation()
    {

    }
    
    /**
     * Check if the length of Ship name is between 3 to 15 characters. 
     * Used in previous assignment
     * @param shipname is the name entered by user
     * @return check if the length of shipname is between 3-15 character
     */
    public boolean stringLengthWithinRange(String shipname)
    {
        int numberLength = shipname.length();
        if (numberLength <= 15 && numberLength >= 3)
            return true;
        else
        {    
            System.out.println("*******************************************************");
            System.out.println("Ship Name must be between 3 to 15 characters!");
            System.out.println("*******************************************************\n");
            return false;
        }
    }
    
    /**
     * Check that the value of X and Y is between 0- or the size
     * This is defined in the file gamesettings.txt.
     * @param xyPos is the x or y position given by the user
     * @return check if position entered is between the grid size, else gives false
     */
    public boolean checkPositionXY(int number, int size)
    {
        // checks if the number is greater than 0 (which is given by the user)
        // and less than size specified
        if (number >= 0 && number <= (size-1))
            return true;
        else 
        {
            System.out.println("Please enter a number between 0 and " + (size-1));
            return false;
        }
    }
    
    /**
     * Checking if the value is numeric, so both X and Y are numeric values
     * @param xyPos is the x or y position given by the user
     * @return checking if the value given by user only contains numbers, else returns false
     */
    public boolean checkNumeric(String xyPos)
    {
        // if nothing is added written in it returns false
        if (xyPos.length() == 0)
            return false;
        int position = 0;
        // checks if every position is a number and not a character
        while (position < xyPos.length())
        {
            char thisNumeric = xyPos.charAt(position);
            if (thisNumeric < '0' || thisNumeric > '9')
                return false;
            position++;
        }
        return true;
    }
}
