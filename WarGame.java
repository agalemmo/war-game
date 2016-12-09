import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class WarGame
{
	public static void main(String args[])
	{
		Card[][] hands = new Card[2][1];
		Deck playerDeck = new Deck();

		for (int i = 0; i < 26; i++)
		{
			System.out.println("\nRound " + i + " of the game.");

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

	public static void printHand(Card[] hand)
	{
		for (int card = 0; card < hand.length; card++)
		{
			System.out.println(hand[card].toString());
		}
		System.out.println();
	}
}
