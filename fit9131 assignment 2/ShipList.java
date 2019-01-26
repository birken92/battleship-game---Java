import java.util.ArrayList;
/**
 * ArrayList of ship
 * Stores the ships in an Array List that is used by the game class
 * 
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class ShipList
{
    private ArrayList<Ship> ships;

    /**
     * Default Constructor for objects of class ShipList
     */
    public ShipList()
    {
        ships = new ArrayList<>();
    }

    /**
     * Adding ships to the arrayList, taking the inputs from game class and saving it in an ArrayList
     * @param shipName name of the individual ship
     * @param xPos the x position given by player
     * @param yPos the x position given by player
     * @param noOfHitsmade the number of hits made
     * @param noOfHitsNeeded the number of hits needed
     */
    public void addShipName(String shipName, int xPos, int yPos, int noOfHitsMade, int noOfHitsNeeded)
    {
        ships.add(new Ship(shipName, xPos, yPos, noOfHitsMade, noOfHitsNeeded));
    }

    /**
     * checking if all ships are destroyed. 
     * If all are destroyed then the game ends
     * @param xPos the x position given by computer or player
     * @param yPos the x position given by computer or player
     * @return returns true or false if x and y pos is the same as another ship
     */
    public boolean checkIfAllDestroyed()
    {
        for (int i = 0; i < ships.size(); i++)
        {
            if (ships.get(i).getNoNeeded() == 0)   
                continue;    
            return false;
        }
        return true;
    }

    /**
     * Will check if the ship have 1 life left
     * if one life is left then the ship will be destroyed
     * @param xPos the x position given by computer or player
     * @param yPos the x position given by computer or player
     * @return returns true or false if x and y pos is the same as another ship
     * @return returns true if getNoNeeded not equal to 0
     */
    public boolean checkIf1LifeLeft(int xPos, int yPos)
    {
        for (int i = 0; i < ships.size(); i++)
        {
            if ((xPos == ships.get(i).getXPos()) && (yPos == ships.get(i).getYPos()))
            {
                if (ships.get(i).getNoNeeded() != 0)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    /**
     * Checking if the position is filled, if the position is filled
     * the the computer needs to put the ship in another position
     * @param xPos the x position given by computer or player
     * @param yPos the x position given by computer or player
     * @return returns true or false if x and y pos is the same as another ship
     */
    public boolean checkPosition(int xPos, int yPos)
    {
        for (int i = 0; i < ships.size(); i++)
        {
            if (xPos == ships.get(i).getXPos() && yPos == ships.get(i).getYPos())
                return false;
        }
        return true;
    }

    /**
     * Goal of this method is to check if the ship is damaged,
     * if the ship is damaged then it changes into a D
     * @param xPos the x position given by computer or player
     * @param yPos the x position given by computer or player
     * @return returns true if ship is damaged
     */
    public boolean checkIfShipDamaged(int xPos, int yPos)
    {
        for (int i = 0; i < ships.size(); i++)
        {
            if ((xPos == ships.get(i).getXPos()) && (yPos == ships.get(i).getYPos()))
            {
                if (ships.get(i).getNoMade() > 0)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    /**
     * Checking if the computer or player hit a ship
     * if it does not hit the ship, then it becomes false
     * xPos and yPos comes from user input or computer input that is randomly generated
     * @param xPos the x position given by computer or player
     * @param yPos the x position given by computer or player
     * @return returns true or false if x and y pos is the same as another ship
     * @return checks if getNoNeeded is greater than 0, if so then it returns true
     */
    public boolean checkShipHit(int xPos, int yPos)
    {
        for (int i = 0; i < ships.size(); i++)
        {
            if ((xPos == ships.get(i).getXPos()) && (yPos == ships.get(i).getYPos()))
            {
                if (ships.get(i).getNoNeeded() > 0)
                {
                    int made = ships.get(i).getNoMade();
                    System.out.println("These are the number of hits: " + (made + 1));
                    ships.get(i).setHitsMade(made+1);
                    int needed = ships.get(i).getNoNeeded();
                    ships.get(i).setHitsNeed(needed -1);
                    if (ships.get(i).getNoNeeded() == 0)
                    {
                        System.out.println(ships.get(i).getShipName() + "Have been Destroyed!");
                        System.out.println("The ship is destroyed!!!!");
                    }
                    return true;
                }
                else
                {
                    System.out.println("The ship is already destroyed!!!!");
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * xPos and yPos comes from user input or computer input that is randomly generated
     * @param xPos the x position given by computer or player
     * @param yPos the x position given by computer or player
     * @return returns true or false if x and y pos is the same as another ship
     */
    public boolean setShips(int xPos, int yPos)
    {
        for (int i = 0; i < ships.size(); i++)
        {
            if ((xPos == ships.get(i).getXPos()) && (yPos == ships.get(i).getYPos()))
                return true;
        }
        return false;
    }
}
