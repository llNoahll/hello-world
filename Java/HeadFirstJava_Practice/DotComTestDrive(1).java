// first step: set the game
// next: play the game, which means getting user's guess
// than check the guess, there are three possibilities: 1. miss(nothing), 2. hit(find a part of com, then remove the part), 3.kill(if all parts of a com are found, the com will be killed)
// check if the game is over(means all coms have been found)
package dotcomtestdrive;

import java.util.Scanner;
import java.util.ArrayList;


class DotCom
{
    private ArrayList<String> locationCells;       // Hold the location cells
    int numOfHits = 0;                             // Hold the number of hits
    int[] hitCells;
    String userGuess;

    // Takes an int array which has the three cell locations as ints(2, 3, 4, etc.)
    public void setLocationCells(ArrayList<String> locations) {
        locationCells = locations;
        // hitCells = new int[locations.length];
    }

    // Takes a String for the user's guess ("1", "3", etc.)
    // , check it and returns a result representing a "hit", "miss", or "kill"
    public String checkUserGuess(String userGuess)
    {
        String result = "miss";
        // Find out if the user guess is in the ArrayList
        // , if it's not, indexOf() will return -1.
        int index = locationCells.indexOf(userGuess);

        if(index >= 0)          // which means the index exits.
        {
            locationCells.remove(index);

            if(locationCells.isEmpty()) {
                result = "kill";
            } // end of if(locationCells.isEmpty())
            else {
                result = "hit";
            } // end of else
        } // end of if(index >= 0)


        return result;
    }
}

public class DotComTestDrive
{
    public static void main(String[] args)
    {
        // Test the SimoleDotCom
        DotCom dot = new DotCom();
        int randomNum = (int) (Math.random() * 5);
        ArrayList<String> locations = new ArrayList<String>();
        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum+1));
        locations.add(String.valueOf(randomNum+2));
        dot.setLocationCells(locations);

        boolean isAlive = true;
        int numOfGuess = 0;
        String result;
        String userGuess;
        Scanner input = new Scanner(System.in);

        do
        {
            System.out.println("Please input your guess:");
            userGuess = input.nextLine();
            numOfGuess++;

            result = dot.checkUserGuess(userGuess);
            System.out.println(result);

            if("kill" == result)
            {
                isAlive = false;
                System.out.printf(
                    "Game over! You have guessed %d times!\n"
                    , numOfGuess);
            } // end of if("kill" == result)
        } while(isAlive);
    }
}
