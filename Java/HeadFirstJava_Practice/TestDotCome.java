import java.util.Scanner;
import java.util.ArrayList;

class DotCom
{
    int numOfHits = 0;                           // Hold the number of hits
    int[] hitCells;
    private String dotComName;
    private ArrayList<String> locationCells;     // Hold the location cells

    public String getDotComName() {
        return dotComName;
    }
    public void setDotComName(String new_dotComName) {
        dotComName = new_dotComName;
    }

    // Takes an int array which has the three cell locations as ints(2, 3, 4, etc.)
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
    int numOfGuesses = 0;       // Store the number of users' guess.
    String guess;

    void setUpGame()
    {
        // Hold three dot.com
        DotCom dot1 = new DotCom();
        dot1.setDotComName("Go2.com");
        DotCom dot2 = new DotCom();
        dot2.setDotComName("Pets.com");
        DotCom dot3 = new DotCom();
        dot3.setDotComName("AskMe.com");

        dotComList.add(dot1);
        dotComList.add(dot2);
        dotComList.add(dot3);


        // Create location for each DotCom.
        for(int i=0; i<3; i++) {
            dotComList.get(i).setLocationCells(helper.createLocation());
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

        for(DotCom dot : dotComList) {
            cellIndex = dot.getLocationCells().indexOf(guess);

            if(cellIndex >= 0)          // which means the cellIndex exits.
            {
                dot.getLocationCells().remove(cellIndex);

                if(dot.getLocationCells().isEmpty()) {
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


        System.out.println(result);
        return result;
    } // close checkUserGuess
} // close DotComBust

class GameHelper
{
    // Make a location
    int decide = 0;         // Decide the shape of coms
    int randomNum = 0;
    char randomChar;
    String userGuess;
    ArrayList<String> location;

    Scanner input = new Scanner(System.in);


    public ArrayList<String> createLocation()
    {
        location = new ArrayList<String>();
        decide = (int) (Math.random() * 1);

        if(0 == decide)
        {
            randomChar = (char)(int)(Math.random() * 7 + 65);

            randomNum = (int) (Math.random() * 5);
            location.add(randomChar + String.valueOf(randomNum));
            location.add(randomChar + String.valueOf(randomNum+1));
            location.add(randomChar + String.valueOf(randomNum+2));
        } // end of if(0 == decide)
        else if(1 == decide)
        {
            randomChar = (char)(int)(Math.random() * 7 + 65);

            randomNum = (int) (Math.random() * 5);
            location.add(randomChar + String.valueOf(randomNum));
            location.add((randomChar+1) + String.valueOf(randomNum));
            location.add((randomChar+2) + String.valueOf(randomNum));
        } // end of else if(1 == decide)


        return location;
    } // close createLocation

    public String getUserGuess()
    {
        System.out.print("Enter a guess(The DotComs are between A0 to G6) ");
        userGuess = input.nextLine();

        return userGuess;
    } // close getUserGuess

} // close GameHelper


public class TestDotCome
{
    public static void main(String[] args)
    {
        DotComBust bustTest = new DotComBust();

        bustTest.setUpGame();
        // for(int i=0; i<3; i++)
        System.out.println(bustTest.dotComList.get(0).getDotComName());

    }
}
