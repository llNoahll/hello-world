package game.guess;

import java.util.Scanner;


class Player
{
    int number = 0;
    public void guess()
    {
        number = (int) (Math.random() * 10);
        System.out.printf("My guess number are %d\n", number);
    }
}

class GameGuess          // Game needs players, and then start the Game.
{
    // GameGuess has three instances variable for three objects
    Player player1;
    Player player2;
    Player player3;

    public void startGame()
    {
        player1 = new Player();
        player2 = new Player();
        player3 = new Player();

        // players' answers
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        // the truth of the answers
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10);
        System.out.printf("The targetNumber of the game is %d\n\n", targetNumber);

        while(true)             // Geme start
        {
            // players start to guess the number
            player1.guess();
            player2.guess();
            player3.guess();

            guessp1 = player1.number;
            guessp2 = player2.number;
            guessp3 = player3.number;


            if(targetNumber == guessp1) {
                p1isRight = true;
            }
            if(targetNumber == guessp2) {
                p2isRight = true;
            }
            if(targetNumber == guessp3) {
                p3isRight = true;
            }

            if(p1isRight || p2isRight || p3isRight) // someone guesses the targetNumber
            {
                System.out.println("\nThe Player1's answer is " + p1isRight);
                System.out.println("The Player2's answer is " + p2isRight);
                System.out.println("The Player3's answer is " + p3isRight);
                System.out.println("\nGame Over!");

                break;
            }
            else {
                System.out.println("Oh, nobody has the right answer! Try again!\n");
            }
        }
    }
}


public class GameLauncher
{
    public static void main(String[] args)
    {
        GameGuess gameGuess = new GameGuess();
        gameGuess.startGame();
    }
}
