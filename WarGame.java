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
}
