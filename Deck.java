import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck extends Card
{
    private List<Card> deck;

    public Deck()
    {
        deck = new ArrayList<>();
    }


    /**
     * Creates a new deck
     * @return
     */
    public  List<Card> makeDeck()
    {
        deck = new ArrayList<>();

        for (Card.Suit s : Card.Suit.values())
        {
            for (Card.Value v : Card.Value.values())
            {
                deck.add(new Card(s, v));
            }
        }

        return deck;
    }

    public List<Card> shuffle()
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

    /**
     * Returns the size of the deck
     * @return
     */
    public int getSize()
    {
        return deck.size();
    }

    public Card getCard(int i)
    {
        return deck.get(i);
    }

    public void addCard(Card c)
    {
        deck.add(c);
    }
}
