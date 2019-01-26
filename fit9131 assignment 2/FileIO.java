import java.io.*;
import java.util.*;
/**
 * Fileo class
 * will read and edit a text file
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class FileIO
{
    private Scanner fileName;

    /**
     * Constructor for objects of class FILEIO
     */
    public FileIO()
    {

    }

    /**
     * Read information from gamesettings.txt file
     * Which is used to set the gamesettings for the battleship game
     * @return name returns the value and information from the file gamesettings.txt
     * @return name this value is used in gameclass for designing how the game is played
     * @throws exception for if the file does not exist or other errors
     */
    public String readLinesToFile()
    {
        String fileNames = ("gamesettings.txt");
        String name = "";
        try
        {
            FileReader inputFile = new FileReader(fileNames);
            try
            {
                Scanner parser = new Scanner(inputFile);
                name = parser.nextLine();
                System.out.println(name);
                while (parser.hasNextLine())
                {
                    name = parser.nextLine();
                    System.out.println(name);
                }
            }
            finally
            {
                System.out.println("Finally.... closing file");
                inputFile.close();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(fileNames + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
        
        return name;
        
        
    }

    /**
     * Writes to file whos name is Gameoutcome
     * Giving the final game outcome the values and who won
     * @param playerscore is the players score
     * @param compscore is the computers score for the game
     * @throws exception for if the file does not exist or other errors
     */
    public void writeToFile(int playerscore, int compscore)
    {
        String filenames = ("gameoutcome.txt");
        try
        {
            PrintWriter outputFile = new PrintWriter(filenames);
            try 
            {
                if (playerscore > compscore)

                    outputFile.println("Player Wins! Final score Player:" + "(" + playerscore + ")" + 
                        "and Computer: (" + compscore + ")" );
                else 
                    outputFile.println("Computer Wins! Final score Computer:" + "(" + compscore + ")" + 
                        "and Player: (" + playerscore + ")" );
            }
            finally
            {
                outputFile.close();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(filenames + " not found");
        }
        catch (IOException e)
        {
            System.out.println("Unexpected I/O exception occurs");
        }

    }
}