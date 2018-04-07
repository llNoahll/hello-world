// first step: set the game
// next: play the game, which means getting user's guess
// than check the guess, there are three possibilities:
// 1. miss(nothing);
// 2. hit(find a part of com, then remove the part);
// 3. kill(if all parts of a com are found, the com will be killed).
// check if the game is over(means all coms have been found)
package pers.noah.headfirstjava.dotcomtestdrive;

import java.util.Scanner;
import java.util.ArrayList;


class DotCom
{
    int numOfHits = 0;                         // Hold the number of hits
    int[] hitCells;
    private String dotComName;
    private ArrayList<String> locationCells;   // Hold the location cells

    public String getDotComName() {
        return dotComName;
    }
    public void setDotComName(String new_dotComName) {
        dotComName = new_dotComName;
    }

    // Takes an int array which has the three cell locations
    public void setLocationCells(ArrayList<String> locations)
    {
        locationCells = locations;
        // hitCells = new int[locations.length];
    }
    public ArrayList getLocationCells() {
        return locationCells;
    }

} // close class

class DotComBust                // Does all the game stuff
{
    // Variable Declarations
    GameHelper helper = new GameHelper(); // Help the game do its work
    ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    String guess;

    public void setUpGame()
    {
        // Hold three dot.com
        DotCom dot_1 = new DotCom();
        dot_1.setDotComName("Go2.com");
        DotCom dot_2 = new DotCom();
        dot_2.setDotComName("Pets.com");
        DotCom dot_3 = new DotCom();
        dot_3.setDotComName("AskMe.com");

        dotComList.add(dot_1);
        dotComList.add(dot_2);
        dotComList.add(dot_3);


        // Create location for each DotCom.
        for(int i=0; i<3; i++) {
            dotComList.get(i).setLocationCells(helper.placeDotCom());
        } // end of for(int i=0; i<3; i++)
    } // close setUpGame()


    public String getGuess()
    {
        guess = helper.getUserGuess();
        return guess;
    } // close getGuess


    public String checkUserGuess(String guess)
    {
        String result = "miss";
        // Find out if the user guess is in the ArrayList
        // , if it's not, indexOf() will return -1.
        int cellIndex = 0;

        System.out.printf("This is what you input: *%s*\n", guess);
        // Show The Answer
        if("show".equals(guess))
        {
            int length = 0;

            System.out.println("Input the rest DotComs:");
            for(DotCom dot : dotComList)
            {
                length = dot.getLocationCells().size();
                for(int i=0; i<length; i++) {
                    System.out.printf("%s ", dot.getLocationCells().get(i));
                }
                System.out.printf("\n");
            } // end of for(DotCom dot : dotComList)
        } // end of if("show".equals(guess))

        for(DotCom dot : dotComList)
        {
            cellIndex = dot.getLocationCells().indexOf(guess);

            // which means the cellIndex exits.
            if(cellIndex >= 0)
            {
                dot.getLocationCells().remove(cellIndex);

                if(dot.getLocationCells().isEmpty())
                {
                    result = "kill";
                    System.out.printf(
                        "Ouch! You sunk %s"
                        , dot.getDotComName());
                    dotComList.remove(dot);
                } // end of if(dot.getLocationCells().isEmpty())
                else {
                    result = "hit";
                } // end of else

                break;
            } // end of if(cellIndex >= 0)
        } // end of for(DotCom dot : dotComList)

        if(dotComList.isEmpty()) {
            result = "over";
        } // end of if(dotComList.isEmpty())


        return result;
    } // close checkUserGuess

    public void startPlaying()
    {
        boolean isAlive = true;
        int numOfGuesses = 0;
        String result;

        do
        {
            guess = getGuess();
            numOfGuesses++;

            result = checkUserGuess(guess);
            System.out.printf("%s\n\n", result);

            if("over".equals(result))
            {
                isAlive = false;
                System.out.printf(
                    "Game over! You have guessed %d times!\n"
                    , numOfGuesses);
            } // end of if("over".equals(result))
        } while(isAlive);

    } // close startPlaying
} // close DotComBust

class GameHelper
{
    // Make a location
    int decide = 0;         // Decide the shape of coms
    int gridLength = 7;
    int dotComLength = 3;
    int randomNum = 0;
    char randomChar;
    String userGuess;
    ArrayList<String> location;

    Scanner input = new Scanner(System.in);


    public ArrayList<String> placeDotCom()
    {
        location = new ArrayList<String>();
        decide = (int) (Math.random() * 2);

        if(0 == decide)         // Coms shape are horizonta
        {
            randomChar = (char)(int)(Math.random() * gridLength + 65);

            randomNum = (int) (Math.random() * (gridLength - dotComLength + 1));
            location.add(randomChar + String.valueOf(randomNum));
            location.add(randomChar + String.valueOf(randomNum+1));
            location.add(randomChar + String.valueOf(randomNum+2));
        } // end of if(0 == decide)
        else if(1 == decide)    // Coms shape are vertical
        {
            randomNum = (int) (Math.random() * gridLength);

            randomChar = (char)(int)(Math.random() * (gridLength - dotComLength + 1) + 65);
            location.add(randomChar + String.valueOf(randomNum));
            location.add((char)(randomChar+1) + String.valueOf(randomNum));
            location.add((char)(randomChar+2) + String.valueOf(randomNum));
        } // end of else if(1 == decide)


        return location;
    } // close placeDotCom

    public String getUserGuess()
    {
        System.out.print("Enter a guess(The DotComs are between A0 to G6) ");
        userGuess = input.nextLine();

        return userGuess;
    } // close getUserGuess

} // close GameHelper


public class DotComTestDrive
{

    public static void main(String[] args)
    {
        DotComBust bust = new DotComBust();
        bust.setUpGame();
        bust.startPlaying();
    } // close main method
} // close class
