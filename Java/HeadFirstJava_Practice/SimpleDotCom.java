// first step: set the game
// next: play the game, which means getting user's guess
// than check the guess, there are three possibilities: 1. miss(nothing), 2. hit(find a part of com, then remove the part), 3.kill(if all parts of a com are found, the com will be killed)
// check if the game is over(means all coms have been found)


package simpledotcomtest;
import java.util.Scanner;


class SimpleDotCom
{
    int[] locationCells;       // Hold the location cells
    int numOfHits = 0;         // Hold the number of hits
    int[] hitCells;
    String userGuess;

    // Takes an int array which has the three cell locations as ints(2, 3, 4, etc.)
    public void setLocationCells(int[] locations)
    {
        locationCells = locations;
        hitCells = new int[locations.length];
    }

    // Takes a String for the user's guess ("1", "3", etc.), check it and returns a result representing a "hit", "miss", or "kill"
    public String checkUserGuess(String userGuess)
    {
        String result = "miss";
        int guess = Integer.parseInt(userGuess);
        // Check if the guess has been guessed right before.
        for(int cell : hitCells) {
            if(guess == cell) {
                result = "hit";
                break;
            } // end of if(guess == cell)
        } // end of for(int cell : hitCells)

        if(result == "miss")
        {
            for(int cell : locationCells) {
                if(guess == cell)
                {
                    result = "hit";
                    hitCells[numOfHits] = cell;
                    numOfHits++;
                    break;
                } // end of if(guess == cell)
            } // end of for(int cell : locationCells)

            if(numOfHits == locationCells.length) {
                result = "kill";
            } // end of if(numOfHits == locationCells.length)
        } // end of if(result == "miss")

        return result;
    }
}

public class SimpleDotCom
{
    public static void main(String[] args)
    {
        // Test the SimoleSimpleDotCom
        SimpleDotCom dot = new SimpleDotCom();
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};
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
                System.out.printf("Game over! You have guessed %d times!\n"
                                  , numOfGuess);
            } // end of if("kill" == result)
        } while(isAlive);
    }
}
