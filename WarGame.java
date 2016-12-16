import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WarGame
{
    //Stats instance variables
    private static int totalBattles;
    private static int avgBattles;
    private static int totalWars;
    private static int avgWars;
    private static int totalDoubleWars;
    private static int avgDoubleWars;
    private static int maxBattles;
    private static int minBattles;
    private static int maxWars;
    private static int minWars;
    private static int thisWar;
    private static int thisBattle;

    private static int count;
    private static boolean gameReset;

    private static Deck playDeck = new Deck();
    private static Deck playerDeck = new Deck();
    private static Deck compDeck = new Deck();

    public static void main(String args[])
    {
        playDeck.makeDeck();
        splitHand();

        totalBattles = 0;
        totalWars = 0;
        totalDoubleWars = 0;

        thisWar = 0;
        thisBattle = 0;

        count = 0;
	    
	try
	{
		PrintStream myconsole = new PrintStream(new File("stats.txt"));
		System.setOut(myconsole);
		myconsole.println(/* this is output onto the file */);
		myconsole.println(/* you can make more lines like this one too*/);
	}

	catch(FileNotFoundException fx)
	{
		System.out.println(fx);
	}	
       
        while(count < 1000)
        {
        	//gameReset = false; //need to move this down?

            //Cards are dealt
            while (playerDeck.getSize() > 0 || compDeck.getSize() > 0)
            {
                battle(playerDeck, compDeck);
                count++;
            }
        }
    }

    public static void splitHand()
    {
        for (int i = 0; i < playDeck.getSize(); i++)
        {
            if (i % 2 == 0)
            {
                playerDeck.addCard(playDeck.getCard(i));
            }

            else
            {
                compDeck.addCard(playDeck.getCard(i));
            }
        }
    }

    /**
     * just does the averages, can probably put into the main method at some point
     */
    public static void averages()
    {
        avgBattles = totalBattles / 1000;
        avgDoubleWars = totalDoubleWars / 1000;
        avgWars = totalWars / 1000;
    }

    public static void battle(Deck playerDeck, Deck compDeck)
    {
        if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 1)
        {
            playerDeck.addCardTo(playerDeck.getCard(0), playerDeck.getSize() - 1);
            playerDeck.removeCard(0);
            playerDeck.addCardTo(compDeck.getCard(0), playerDeck.getSize() - 1);
            compDeck.removeCard(0);
            totalBattles++;
            thisBattle++;
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == -1)
        {
            compDeck.addCardTo(compDeck.getCard(0), compDeck.getSize() - 1);
            compDeck.removeCard(0);
            compDeck.addCardTo(playerDeck.getCard(0), compDeck.getSize() - 1);
            playerDeck.removeCard(0);
            totalBattles++;
            thisBattle++;
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
        {
            war(playerDeck, compDeck);
        }
    }

    public static void war(Deck playerDeck, Deck compDeck)
    {
        if (playerDeck.getCard(1).compareTo(compDeck.getCard(1)) == -1)
        {
            compDeck.addCardTo(compDeck.getCard(0), compDeck.getSize() - 1);
            compDeck.addCardTo(compDeck.getCard(1), compDeck.getSize() - 1);
            compDeck.addCardTo(playerDeck.getCard(0), compDeck.getSize() - 1);
            compDeck.addCardTo(playerDeck.getCard(1), compDeck.getSize() - 1);
            compDeck.removeCard(0);
            compDeck.removeCard(1);
            playerDeck.removeCard(0);
            playerDeck.removeCard(1);
            totalWars++;
            thisWar++;
        }

        else if (playerDeck.getCard(1).compareTo(compDeck.getCard(1)) == 1)
        {
            playerDeck.addCardTo(playerDeck.getCard(0), playerDeck.getSize() - 1);
            playerDeck.addCardTo(playerDeck.getCard(1), playerDeck.getSize() - 1);
            playerDeck.addCardTo(compDeck.getCard(0), playerDeck.getSize() - 1);
            playerDeck.addCardTo(compDeck.getCard(1), playerDeck.getSize() - 1);
            compDeck.removeCard(0);
            compDeck.removeCard(1);
            playerDeck.removeCard(0);
            playerDeck.removeCard(1);
            totalWars++;
            thisWar++;
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
        {
            doubleWar(playerDeck, compDeck);
        }

        //checkStats(thisBattle, thisWar);
    }

    public static void doubleWar(Deck playerDeck, Deck compDeck)
    {
        if (playerDeck.getCard(1).compareTo(compDeck.getCard(1)) == -1)
        {
            compDeck.addCardTo(compDeck.getCard(0), compDeck.getSize() - 1);
            compDeck.addCardTo(compDeck.getCard(1), compDeck.getSize() - 1);
            compDeck.addCardTo(playerDeck.getCard(0), compDeck.getSize() - 1);
            compDeck.addCardTo(playerDeck.getCard(1), compDeck.getSize() - 1);
            compDeck.removeCard(0);
            compDeck.removeCard(1);
            playerDeck.removeCard(0);
            playerDeck.removeCard(1);
            totalDoubleWars++;
            thisWar++;
        }

        else if (playerDeck.getCard(1).compareTo(compDeck.getCard(1)) == 1)
        {
            playerDeck.addCardTo(playerDeck.getCard(0), playerDeck.getSize() - 1);
            playerDeck.addCardTo(playerDeck.getCard(1), playerDeck.getSize() - 1);
            playerDeck.addCardTo(compDeck.getCard(0), playerDeck.getSize() - 1);
            playerDeck.addCardTo(compDeck.getCard(1), playerDeck.getSize() - 1);
            compDeck.removeCard(0);
            compDeck.removeCard(1);
            playerDeck.removeCard(0);
            playerDeck.removeCard(1);
            totalDoubleWars++;
            thisWar++;
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
        {
            doubleWar(playerDeck, compDeck);
        }
    }

    /**
     * For 1000 games ...

     Average number of battles per game: 321.2

     Average number of wars per game: 24.3

     Average number of double wars per game: 0.5

     Max number of battles in a game: 1234

     Min number of battles in a game: 12

     Max number of wars in a game: 123

     Min number of wars in a game: 1
     */
    public static void printStats()
    {
        System.out.println("For 1000 games...");
        System.out.println("Average number of battles per game: " + avgBattles);
        System.out.println("Average number of wars per game: " + avgWars);
        System.out.println("Average number of double wars per game: " + avgDoubleWars);
        System.out.println("Max number of battles in a game: " + maxBattles);
        System.out.println("Min number of battles in a game: " + minBattles);
        System.out.println("Max number of wars in a game: " + maxWars);
        System.out.println("Min number of wars in a game: " + minWars);
    }

    public static void printHand()
    {
        for (int card = 0; card < hand.length; card++)
        {
            System.out.println(hand[card].toString());
        }
        System.out.println();
    }
}
