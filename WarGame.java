import java.io.FileNotFoundException;
import java.io.File;
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

    //private static char[][] display = new char[100][10];

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

        maxBattles = 0;
        minBattles = 0;
        maxWars = 0;
        minWars = 0;

        count = 0;

        while(count < 1000)
        {
        	//gameReset = false; //need to move this down?

            //Cards are dealt
            while (playerDeck.getSize() > 0 || compDeck.getSize() > 0)
            {
                battle(playerDeck, compDeck);
                count++;
                compareStats(thisWar, thisBattle);
            }

            averages();
            printStats();
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
            totalWars++;
            thisWar++;
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
            totalBattles++;
            thisBattle++;
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
            totalBattles++;
            thisBattle++;
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
        {
            doubleWar(playerDeck, compDeck);
            totalWars++;
            thisWar++;
        }
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
            totalBattles++;
            thisBattle++;
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
            totalBattles++;
            thisBattle++;
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
        {
            doubleWar(playerDeck, compDeck);
            totalDoubleWars++;
            thisWar++;
        }
    }

    public static void compareStats(int thisWar, int thisBattle)
    {
        if (thisWar > maxWars)
        {
            maxWars = thisWar;
        }

        else if (thisWar < minWars)
        {
            minWars = thisWar;
        }

        else if (thisBattle > maxBattles)
        {
            maxBattles = thisBattle;
        }

        else if (thisBattle < minBattles)
        {
            minBattles = thisBattle;
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

        System.out.println("Statistics printed to stats.txt.");
        try
        {
            PrintStream myconsole = new PrintStream(new File("stats.txt"));
            System.setOut(myconsole);
            myconsole.println("For 1000 games...");
            myconsole.println("Average number of battles per game: " + avgBattles);
            myconsole.println("Average number of wars per game: " + avgWars);
            myconsole.println("Average number of double wars per game: " + avgDoubleWars);
            myconsole.println("Maximum number of battles in a game: " + maxBattles);
            myconsole.println("Minimum number of battles in a game: " + minBattles);
            myconsole.println("Maximum number of wars in a game: " + maxWars);
            myconsole.println("Minimum number of wars in a game: " + minWars);
        }

        catch(FileNotFoundException fx)
        {
            System.out.println(fx);
        }
    }
}
