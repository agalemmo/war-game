import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

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

    private static ArrayList<Card> burnt = new ArrayList<>();

    private static Deck playDeck = new Deck();
    private static Deck playerDeck = new Deck();
    private static Deck compDeck = new Deck();

    public static void main(String args[])
    {
        //Variables being tracked for the stats.txt
        totalBattles = 0;
        totalWars = 0;
        totalDoubleWars = 0;

        thisWar = 0;
        thisBattle = 0;

        maxBattles = 0;
        minBattles = 100;
        maxWars = 0;
        minWars = 100;

        count = 0;

        while(count <= 1000)
        {
            //Cards are dealt
            playDeck.makeDeck();
            playDeck.shuffle();
            splitHand();

            while(playerDeck.getSize() > 0 && compDeck.getSize() > 0)
            {
                battle(playerDeck, compDeck);
                if (thisBattle > 1500)
                {
                    break;
                }
            }
            compareStats(thisWar, thisBattle);
            playerDeck.wipe();
            compDeck.wipe();

            thisWar = 0;
            thisBattle = 0;
            count++;
        }

        averages();
        printStats();
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

    //simulates a battle taking place
    public static void battle(Deck playerDeck, Deck compDeck)
    {
        if (playerDeck.getSize() == 0 || compDeck.getSize() == 0)
        {
            return;
        }
        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 1)
        {
            totalBattles++;
            thisBattle++;

            burnt.add(compDeck.getCard(0));
            compDeck.removeCard(0);
            burnt.add(playerDeck.getCard(0));
            playerDeck.removeCard(0);
            while (burnt.size() > 0)
            {
                if (playerDeck.getSize() == 0)
                {
                    playerDeck.addCard(burnt.get(0));
                }
                else
                {
                    playerDeck.addCardTo(burnt.get(0), (playerDeck.getSize() - 1));
                }

                burnt.remove(0);
            }
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == -1)
        {
            totalBattles++;
            thisBattle++;

            burnt.add(compDeck.getCard(0));
            compDeck.removeCard(0);
            burnt.add(playerDeck.getCard(0));
            playerDeck.removeCard(0);
            while (burnt.size() > 0)
            {
                if (compDeck.getSize() == 0)
                {
                    compDeck.addCard(burnt.get(0));
                }
                else
                {
                    compDeck.addCardTo(burnt.get(0), (compDeck.getSize() - 1));
                }

                burnt.remove(0);
            }
        }

        else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
        {
            totalWars++;
            thisWar++;
            if (playerDeck.getSize() == 1)
            {
                burnt.add(compDeck.getCard(0));
                war(playerDeck, compDeck);
            }

            else if (compDeck.getSize() == 1)
            {
                burnt.add(playerDeck.getCard(0));
                war(playerDeck, compDeck);
            }

            if (playerDeck.getSize() == 0 || compDeck.getSize() == 0)
            {
                return;
            }

            burnt.add(playerDeck.getCard(0));
            burnt.add(compDeck.getCard(0));
            playerDeck.removeCard(0);
            compDeck.removeCard(0);
            war(playerDeck, compDeck);
        }
    }
    //in the event of a war
    public static void war(Deck playerDeck, Deck compDeck)
    {
        if (playerDeck.getSize() > 3 && compDeck.getSize() > 3)
        {
            for (int i = 2; i >= 0; i--)
            {
                burnt.add(playerDeck.getCard(i));
                burnt.add(compDeck.getCard(i));
                playerDeck.removeCard(i);
                compDeck.removeCard(i);
            }

            if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == -1)
            {
                battle(playerDeck, compDeck);
            }

            else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 1)
            {
                battle(playerDeck, compDeck);
            }

            else if (playerDeck.getCard(0).compareTo(compDeck.getCard(0)) == 0)
            {
                totalDoubleWars++;
                battle(playerDeck, compDeck);
            }
        }
        else
        {
            if (playerDeck.getSize() > 3)
            {
                for (int i = 2; i >= 0; i--)
                {
                    burnt.add(playerDeck.getCard(i));
                    playerDeck.removeCard(i);
                }

                if (compDeck.getSize() == 3 || compDeck.getSize() == 2)
                {
                    for (int i = 0; i < compDeck.getSize() - 1; i++)
                    {
                        burnt.add(compDeck.getCard(i));
                        compDeck.removeCard(i);
                    }
                }

                totalDoubleWars++;
                battle(playerDeck, compDeck);
            }

            else if (playerDeck.getSize() == 3 || playerDeck.getSize() == 2)
            {
                for (int i = 0; i < playerDeck.getSize() - 1; i++)
                {
                    burnt.add(playerDeck.getCard(i));
                    playerDeck.removeCard(i);
                }
                for (int i = 2; i >= 0; i--)
                {
                    burnt.add(compDeck.getCard(i));
                    compDeck.removeCard(i);
                }

                totalDoubleWars++;
                battle(playerDeck, compDeck);
            }

            else if (playerDeck.getSize() == 1)
            {
                for (int i = 2; i >= 0; i--)
                {
                    burnt.add(compDeck.getCard(i));
                    compDeck.removeCard(i);
                }

                totalDoubleWars++;
                battle(playerDeck, compDeck);
            }
            else if (playerDeck.getSize() == 0 || compDeck.getSize() == 0)
            {
                return;
            }
        }
    }
    
    //compares statistics from war method to instance variables
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

    //notifies user that stats have been printed to a seperate file, prints them to stats.txt
    public static void printStats()
    {
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
