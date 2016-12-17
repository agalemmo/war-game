import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card
{
    public Card()
    {
        Card card;
    }

    public enum Suit
    {
        SPADES,
        CLUBS,
        DIAMONDS,
        HEARTS
    }

    public enum Value
    {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING;

        public int getValueAceLow()
        {
            return this.ordinal();
        }

        //places ace as a higher value than king
        public int getValueAceHigh()
        {
            if (this == ACE)
            {
                return 14;
            }

            else
            {
                return this.ordinal();
            }
        }
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    public boolean equalsLow(Card other)
    {
        if (this.getSuit() == other.getSuit())
        {
            if (this.getValue().getValueAceLow() == this.getValue().getValueAceLow())
            {
                return true;
            }

            else {return false;}
        }

        return false;
    }

    public boolean equalsHigh(Card other)
    {
        if (this.getSuit() == other.getSuit())
        {
            if (this.getValue().getValueAceHigh() == other.getValue().getValueAceHigh())
            {
                return true;
            }

            else { return false; }
        }

        return false;
    }

    //compares the values of the cards dealt between the players
    public int compareTo(Card other)
    {
        if (this.getValue().getValueAceHigh() == other.getValue().getValueAceHigh())
        {
            return 0;
        }

        else if (this.getValue().getValueAceHigh() > other.getValue().getValueAceHigh())
        {
            return 1;
        }

        else if (this.getValue().getValueAceHigh() < other.getValue().getValueAceHigh())
        {
            return -1;
        }

        return 5;
    }


    public Suit getSuit()
    {
        return this.suit;
    }

    public Value getValue()
    {
        return this.value;
    }

    public String toString()
    {
        return value + " OF " + suit;
    }
}
