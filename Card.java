/**
 * Created by agale_000 on 12/7/2016.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card
{
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

    public Suit suit;
    public Value value;

    public Card(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit()
    {
        return this.suit;
    }

    public Value getValue()
    {
        return this.value;
    }
}
