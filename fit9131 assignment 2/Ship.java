/**
 * This is the creation of ship class
 * Used to create, get and change ships
 * 
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class Ship
{
    private String shipName;
    private int xPos;
    private int yPos;
    private int noOfHitsMade;
    private int noOfHitsNeeded;

    /**
     * default constructor
     */
    public Ship()
    {
        shipName = "";
        xPos = 0;
        yPos = 0;
        noOfHitsMade = 0;
        noOfHitsNeeded = 0;
    }

    /**
     * non default Constructor for objects of class Ship
     * @param shipName name of the individual ship
     * @param xPos the x position given by player
     * @param yPos the x position given by player
     * @param noOfHitsmade the number of hits made
     * @param noOfHitsNeeded the number of hits needed
     */
    public Ship(String newName, int newXpos, int newYpos, int newHitsMade, int newHitsNeed)
    {
        shipName = newName;
        xPos = newXpos;
        yPos = newYpos;
        noOfHitsMade = newHitsMade;
        noOfHitsNeeded = newHitsNeed;
    }

    /**
     * Getting number of hits made on ship
     * @return returning number of hits made
     */
    public int getNoMade()
    {
        return noOfHitsMade;
    }
    
    /**
     * Getting number of hits needed to destroy ship!
     * @return returning number of hits needed to destroy ship
     */
    public int getNoNeeded()
    {
        return noOfHitsNeeded;
    }

    /**
     * Getting shipname
     * @return returning name of ship
     */
    public String getShipName()
    {
        return shipName;
    }

    /**
     * Getting y position
     * @return returning yPosition of ship
     */
    public int getYPos()
    {
        return yPos;
    }

    /**
     * Getting x position
     * @return returning xPosition of ship
     */
    public int getXPos()
    {
        return xPos;
    }
    
    /**
     * Setting number of hits made
     * @param newHits setting noOfHitsMade after each hit on the ship
     */
    public void setHitsMade(int newHits)
    {
        noOfHitsMade = newHits;
    }

    /**
     * Setting number of hits needed to destroy ship
     * @param newHitsNeeded set noOfHitsNeeded to newHitsNeeded inserted by user or computer
     */
    public void setHitsNeed(int newHitsNeeded)
    {
        noOfHitsNeeded = newHitsNeeded;
    }

    /**
     * Setting ship name
     * @param newName set shipName to newName inserted by user
     */
    public void setShipName(String newName)
    {
        shipName = newName;
    }

    /**
     * Setting x position
     * @param newXPos set xPos to newXPos inserted by user
     */
    public void setXPos(int newXPos)
    {
        xPos = newXPos;
    }
    
    /**
     * Setting y position
     * @param newYPos set yPos to newYPos inserted by user
     */
    public void setYPos(int newYPos)
    {
        yPos = newYPos;
    }
}
