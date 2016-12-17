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
        HEARTS;
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

    private  Suit suit;
    private  Value value;

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

            else { return false; }
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

    /**
     * Takes a this value and then the comparative number, for the min/max variables, possibly unnecessary
     * @param other
     * @return -1 if other > this, 0 if other == this, 1 if this > other
     */
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
