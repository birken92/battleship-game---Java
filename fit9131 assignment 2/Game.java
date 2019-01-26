/**
 * Gameclass
 * This is where the game grid is initialised
 * Where it is played and where it is started
 * createGame() starts the game
 * @author (Thomas Birkenes) 
 * @version (10 October 2018)
 */
public class Game
{
    private ShipList playerShips;
    private ShipList computerShips;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        playerShips = new ShipList();
        computerShips = new ShipList();
    }

    public static void main()
    {
        Game myGame = new Game();
        myGame.startGame();
    }

    public void test()
    {
        String s1 = new String("hey");
        String s2 = new String("num2");
        String s3 = s1;
        
        System.out.println(s1 + "" + s2 + " " + s3 );
        s1 = "ralph";
        System.out.println(s1 + "" + s2 + " " + s3 );/Users/thomasbirkenes/Downloads/WechatIMG24.jpeg

    }

    /**
     * Creating the game and initialising the game
     * @param takes input from other classes and sends values towards them
     */
    public void startGame()
    {
        System.out.println("==succeeded");

        FileIO rows = new FileIO();
        Input input = new Input();
        String reading = rows.readLinesToFile();
        String[] gameString = reading.split(",");
        //Splitting the information from file into 4 different Strings
        String gridSize = gameString[0].trim();
        String multipleHits = gameString[1].trim();
        String shipVisibility = gameString[2].trim();
        String shipNumber = gameString[3].trim();
        //converting the string into integer and boolean
        int size = Integer.parseInt(gridSize);
        boolean hits = Boolean.valueOf(multipleHits);
        boolean shipvisible = Boolean.valueOf(shipVisibility);
        int number = Integer.parseInt(shipNumber);

        showMenu(size, number, hits, shipvisible); //Prints the Menu
        input.gameInput();

        createShip(hits, number, size); // Create playerships
        System.out.println("+**********************************************+");
        System.out.println("This is the Player Grid!");
        printBattleShipPlayer(size);

        System.out.println("+**********************************************+\n");
        System.out.println("Loading Computer settings:");
        System.out.println("Press enter to continue");
        input.gameInput();
        System.out.println("Computer will now create ships!\n");
        //creating computer ships
        createComputerShips(hits, size, number);
        System.out.println("+**********************************************+");
        System.out.println("This is the Computer Grid!");
        printBattleShipComp(size, shipvisible);
        System.out.println("+**********************************************+");

        System.out.println("Press enter to Start the game!");
        input.gameInput();

        int playerScore = 0;
        int compScore = 0;
        boolean startGame = true; //when either the playerships or computerships
        // are destroyed the game stop
        while (startGame)
        {
            int index = 1;
            System.out.println("Round:  " + index);
            System.out.println("Player Score: " + playerScore);
            System.out.println("Computer Score: " + compScore);

            int yPos = playerHitY(size);
            int xPos = playerHitX(size);
            if (computerShips.checkShipHit(yPos, xPos))
            {
                System.out.println("+**********************************************+");
                System.out.println("Player HIT!!!!!!");
                System.out.println("+**********************************************+");
                if (computerShips.checkIf1LifeLeft(xPos, yPos))
                {
                    playerScore = playerScore + 10;
                }
                else 
                {
                    playerScore = playerScore + 10;
                }
            }
            else
            {
                System.out.println("+**********************************************+");
                System.out.println("PLAYER MISSES!!!!!!");
                System.out.println("+**********************************************+");
            }

            int compX = compTurn(size);
            int compY = compTurn(size);
            if (playerShips.checkShipHit(compX, compY))
            {
                System.out.println("COMPUTER HIT!!!!!!");
                if (playerShips.checkIf1LifeLeft(xPos, yPos))
                {
                    compScore = compScore + 10;
                }
                else
                {
                    compScore = compScore + 10;
                }
            }
            else
            {
                System.out.println("COMPUTER MISSES!!!!!!");
            }
            System.out.println("*****************************************************");
            System.out.println("Player Grid!");
            printBattleShipPlayer(size);
            System.out.println("*****************************************************");
            System.out.println("Computer Grid!");
            printBattleShipComp(size, shipvisible);
            System.out.println("*****************************************************");

            if (computerShips.checkIfAllDestroyed())
            {
                System.out.println("The user have won! Congratulation!!!!");
                System.out.println("Thank you for playing Battleship game!");
                startGame = false;
                rows.writeToFile(playerScore, compScore);
                return;
            }

            if (playerShips.checkIfAllDestroyed())
            {
                System.out.println("The computer have won!!!");
                System.out.println("Thank you for playing Battleship game!");
                startGame = false;
                rows.writeToFile(playerScore, compScore);
                return;
            }
            System.out.println("Click enter for next round!");
            input.gameInput();
            index++;
        }
    }

    /**
     * Random x and y cordinates for the computers turn
     * Using random number generator, used for computers try to destroy ships
     * @param size Gets the size of grid
     * @return xyPos returns the xyPosition given by the random number generator
     */
    public int compTurn(int size)
    {
        CoordinateGenerator coordinates = new CoordinateGenerator();
        int xyPos = 0;
        //xyPos = coordinates.randomNumberGenerator(0, (size-1));
        xyPos = coordinates.generateRandom(0, (size-1));
        return xyPos;
    }

    /**
     * Returning x positoon given by the user
     * @param size Gets the size of grid
     * @return xPos the x position of player
     */
    public int playerHitX(int size)
    {
        Input input = new Input();
        Validation validate = new Validation();
        int xPos = 0;
        System.out.println("Player make a guess");
        boolean xLoop = true;
        while (xLoop)
        {
            System.out.println("Enter X coordinates for Ship");
            String newXYPos = input.userInput();
            if (validate.checkNumeric(newXYPos))
            {
                int newyPos = Integer.valueOf(newXYPos);
                if (validate.checkPositionXY(newyPos, size))
                {
                    xPos = newyPos;
                    xLoop = false;
                }

                else 
                {
                    System.out.println("Please enter a valid number");
                }
            }
        }
        return xPos;
    }

    /**
     * This will validate Y position that is given by the user
     * @param size Gets the size of grid
     * @return yPos the y position of player
     */
    public int playerHitY(int size)
    {
        Input input = new Input();
        Validation validate = new Validation();
        int yPos = 0;
        boolean yLoop = true;
        while (yLoop)
        {
            System.out.println("Enter Y coordinates for Ship");
            String newYPos = input.userInput();
            if(validate.checkNumeric(newYPos))
            {
                int newyPos = Integer.valueOf(newYPos);
                if (validate.checkPositionXY(newyPos, size))
                {
                    yPos = newyPos;
                    System.out.println("The ships x position is: " + yPos);
                    yLoop = false;
                }
            }
            else 
            {
                System.out.println("Please enter a valid number");
            }
        }
        return yPos;
    }

    /**
     * Printing player battleship grid, 
     * showing where the players ships are on the grid
     * @param size Gets the size of grid
     */
    public void printBattleShipPlayer(int size)
    {
        String wave = "~ ";
        String o = "O ";
        String x = "X ";
        String d = "D ";
        for (int j = 0; j < size; j++)
        {
            for (int m= 0; m < size; m++)
            {
                if (playerShips.setShips(j, m))
                {
                    if (playerShips.checkIf1LifeLeft(j, m))
                    {
                        if (playerShips.checkIfShipDamaged(j, m))
                            System.out.print(d);                        
                        else
                            System.out.print(o);
                    }
                    else
                        System.out.print(x);
                }
                else
                    System.out.print(wave); 
            }
            System.out.println(" ");
        }
    }

    /**
     * Printing computers game grid
     * If it is true, then the ships will be shown, if not then they will be hidden. 
     * @param size Gets the size of grid
     * @param shipvisible is the visibility of ship on then the computer ship will be hidden
     */
    public void printBattleShipComp(int size, boolean shipvisible)
    {
        String waves = "~ ";
        String ship = "O ";
        String destroyedShip = "X ";
        String damaged = "D ";
        if (shipvisible)
        {
            for (int j = 0; j < size; j++)
            {
                for (int m= 0; m < size; m++)
                {
                    if (computerShips.setShips(j, m))
                    {
                        if (computerShips.checkIf1LifeLeft(j, m))
                        {
                            if (computerShips.checkIfShipDamaged(j, m))
                                System.out.print(damaged);                        
                            else
                                System.out.print(ship);
                        }
                        else
                            System.out.print(destroyedShip);
                    }
                    else
                        System.out.print(waves); 
                }
                System.out.println(" ");
            }
        }
        else 
        {
            for (int i = 0; i < size; i++)
            {
                for (int m= 0; m < size; m++)
                {
                    if (computerShips.setShips(i, m))
                    {
                        if (computerShips.checkIfShipDamaged(i, m))
                        {
                            if (computerShips.checkIf1LifeLeft(i, m))
                                System.out.print(damaged);
                            else
                                System.out.print(destroyedShip);
                        }
                        else
                            System.out.print(waves);
                    }
                    else 
                        System.out.print(waves);
                }
                System.out.println(" ");
            }
        }
    }

    /**
     * Create computer ships
     * randomly creates the computer ships and put them on the grid 
     * @param shipStrength the strength of the ship given
     * @param size Gets the size of grid
     * @param number the number of ships
     */
    public void createComputerShips(boolean hits, int size, int number)
    {
        CoordinateGenerator coordinates = new CoordinateGenerator();
        String shipName = "";
        int xPos = 0;
        int yPos = 0;
        int noOfHitsMade = 0;
        int noOfHitsNeeded = 1;
        int i = 0;
        while (i < number)
        {
            shipName = "Shipname" + (i+1);
            boolean computer = true;
            while (computer)
            {
                //xPos = coordinates.generateRandom(0, (size-1));
                //yPos = coordinates.generateRandom(0, (size-1));
                xPos = coordinates.randomNumberGenerator(0, (size-1));
                yPos = coordinates.randomNumberGenerator(0, (size-1));
                if (computerShips.checkPosition(xPos, yPos))
                {
                    computer = false;
                }
            }
            if (hits)
                noOfHitsNeeded = coordinates.randomNumberGenerator(1, 5);
            computerShips.addShipName(shipName, xPos, yPos, noOfHitsMade, noOfHitsNeeded);
            i++;
        }
    }

    /**
     * Creating players ship, adding them to a position of choice
     * while going through the validations
     * @param shipStrength the strength of the ship given
     * @param number the number of ships
     * @param size Gets the size of grid
     */
    public void createShip(boolean hits, int number, int size)
    {
        Input input = new Input();
        Validation validate = new Validation();
        String shipName = "";
        int xPos = 0;
        int yPos = 0;
        int noOfHitsMade = 0;
        int noOfHitsNeeded = 1;
        System.out.println("Loading player settings!");

        int i = 0;
        while (i < number)
        {
            System.out.println("Insert the names of your ship: " + (i+1));
            boolean looping = true;
            while (looping)
            {
                System.out.println("*******************************************************");
                System.out.println("Please enter details for Ship " + (i+1));
                System.out.println("Please enter name for Ship: " + (i+1));
                String name = input.userInput();
                shipName = name;
                if (validate.stringLengthWithinRange(shipName))
                {
                    System.out.println("Ship Name is, " + shipName);
                    looping = false;
                }
            }
            boolean xyLoop = true;
            while(xyLoop)
            {
                boolean xLoop = true;
                while (xLoop)
                {
                    System.out.println("Enter X coordinates for Ship");
                    String newXYPos = input.userInput();
                    if(validate.checkNumeric(newXYPos))
                    {                
                        int newyPos = Integer.valueOf(newXYPos);
                        if (validate.checkPositionXY(newyPos, size))
                        {
                            xPos = newyPos;
                            System.out.println("The ships x position is: " + xPos);
                            xLoop = false;
                        }
                    }
                    else 
                    {
                        System.out.println("Please enter a valid number");
                    }
                }
                boolean yLoop = true;
                while (yLoop)
                {
                    System.out.println("Enter Y coordinates for Ship");
                    String newXYPos = input.userInput();
                    if(validate.checkNumeric(newXYPos))
                    {
                        int newyPos = Integer.valueOf(newXYPos);
                        if (validate.checkPositionXY(newyPos, size))
                        {
                            yPos= newyPos;
                            System.out.println("The ships x position is: " + yPos);
                            yLoop = false;
                        }
                    }
                    else 
                    {
                        System.out.println("Please enter a valid number");
                    }
                }
                if (playerShips.checkPosition(xPos, yPos))
                {
                    xyLoop = false;
                }
            }

            CoordinateGenerator coordinates = new CoordinateGenerator();
            if (hits)
                noOfHitsNeeded = coordinates.randomNumberGenerator(1, 5);

            playerShips.addShipName(shipName, xPos, yPos, noOfHitsMade, noOfHitsNeeded);
            i++;
            System.out.print('\u000c');
        }
    }

    /**
     * prints the menu
     * Takes information through fileo class
     * @param size Gets the size of grid
     * @param shipNumber number of ships
     * @param visible if the computer ships are visible
     * @param hits if multiple hits is allowed on ship
     */
    public void showMenu(int size, int shipNumber, boolean hits, boolean visible)
    {
        System.out.print('\u000c');
        System.out.println("+*************************************************************************************+");
        System.out.println("|                                                                                     |");
        System.out.println("|                      Welcome to the BattleShip Game -- With a Twist                 |");
        System.out.println("|                                                                                     |");
        System.out.println("+*************************************************************************************+");
        System.out.println("The game will use the grid size defined in the game settings file.");
        System.out.println("Playing grid size set as: " + size);
        System.out.println("Maximum number of ships allowed as: " + shipNumber);
        System.out.println("Multiple hits allowed per ships set as : " + hits );
        if (visible)
            System.out.println("Computer Ships Visible : ON!");
        else 
            System.out.println("Computer Ships Visible : OFF!");
        System.out.println("Press enter to continue......");
    }
}