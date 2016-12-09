import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by agale_000 on 12/8/2016.
 */
public class Deck extends Card
{
    public static List<Card> makeDeck()
    {
        List<Card> cards = new ArrayList<>();

        for (Card.Suit s : Card.Suit.values())
        {
            for (Card.Value v : Card.Value.values())
            {
                cards.add(new Card(s, v));
            }
        }

        return cards;
    }

    public static List<Card> shuffle(List<Card> deck)
    {
        Card temp;
        Random generator = new Random();
        int rand;

        //generator.nextInt(deck.size())

        for (int i = deck.size(); i > 0; i--)
        {
            temp = deck.get(i);
            rand = generator.nextInt(deck.size());
            deck.remove(i);
            deck.add(rand, temp);
            temp = null;
            System.out.println(deck);
        }

        return deck;
    }
}
