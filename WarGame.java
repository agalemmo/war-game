import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class WarGame
{
	private static Deck playDeck = new Deck();
	private static Deck playerDeck = new Deck();
	private static Deck compDeck = new Deck();

	public static void main(String args[])
	{
		//stats
		playDeck.makeDeck();
        splitHand();

		int battles = 0; //number of battles
		int wars = 0; //number of wars
		int doubleWars = 0; //number of double wars
		int count = 0; // number of battles
		Boolean gameReset = false; //restarts the game within the while loop

		while(count < 1000)
		{
			count ++;
			gameReset = false; //need to move this down?

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
						battles = battles + 1;
					}
					else if (player2 > player1)
					{
						System.out.println("Player Two wins!");
						battles = battles + 1;
					}
					else
					{
						System.out.println("The game is tied!  A war will decide the victor!");
						wars = wars + 1;

						while(gameReset == false)
						{
							// While loop for in the event of a War
						}
					}
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

    public static void averages()
    {
        avgBattles = battles / 1000;
        avgDoubleWars = doubleWars / 1000;
        avgWars = wars / 1000;
    }

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

	public static void printHand()
	{
		for (int card = 0; card < hand.length; card++)
		{
			System.out.println(hand[card].toString());
		}
		System.out.println();
	}
}
