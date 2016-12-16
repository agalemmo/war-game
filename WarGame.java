import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WarGame
{
    private static Deck playDeck = new Deck();
    private static Deck playerDeck = new Deck();
    private static Deck compDeck = new Deck();

    public static void main(String args[])
    {
        playDeck.makeDeck();
        splitHand();

        for (int i = 0; i < 26; i++)
        {
            System.out.println("Round " + i + " of the game.");

            for (int c = 0; c < 1; c++)
            {
                for (int player = 0; player < hands.length; player++)
                {
                    hands[player][0] = playerDeck.dealCard();
                }
            }

            for (int player = 0; player < hands.length; player++)
            {
                System.out.println("Player: " + player);
                printHand(hands[player]);

                int player1 = hands[0][0].getValue();
                int player2 = hands[1][0].getValue();

                if (player1 > player2)
                {
                    System.out.println("Player One wins!");
                }
                else if (player2 > player1)
                {
                    System.out.println("Player Two wins!");
                }
                else
                {
                    System.out.println("The war is tied.");
                }
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

    public static void printHand()
    {
        for (int card = 0; card < hand.length; card++)
        {
            System.out.println(hand[card].toString());
        }
        System.out.println();
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
    /**
     * Takes a this value and then the comparative number, for the min/max variables, possibly unnecessary
     * @param other
     * @return -1 if other > this, 0 if other == this, 1 if this > other
     */
    public int compareTo(int other)
    {
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
