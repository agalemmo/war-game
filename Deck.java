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
     * @return returns deck
     */
    public List<Card> makeDeck()
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

        for (int i = deck.size() - 1; i > 0; i--)
        {
            temp = deck.get(i);
            rand = generator.nextInt(deck.size());
            deck.remove(i);
            deck.add(rand, temp);
            temp = null;
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

    public void addCardTo(Card c, int i)
    {
        deck.add(i, c);
    }

    public void removeCard(int i)
    {
        deck.remove(i);
    }

    /**
     * compare sizes of decks
     * @param other
     * @return if this > other = 1, other > this = -1, other == this = 0
     */
    public int compareTo(Deck other)
    {
        if (this.getSize() > other.getSize())
        {
            return 1;
        }

        else if (this.getSize() < other.getSize())
        {
            return -1;
        }

        else
        {
            return 0;
        }
    }

    public void wipe()
    {
        if (this.getSize() > 0)
        {
            for (int i = this.getSize() - 1; i >= 0; i--)
            {
                this.removeCard(i);
            }
        }
    }
}
