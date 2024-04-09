
/**
 * This class represents a single playing card used in the Hearts Game.
 * @author Arjun Vaish
 */
public class Card implements Comparable<Card> {

    public static final char CLUBS = 'c';
    public static final char DIAMONDS = 'd';
    public static final char HEARTS = 'h';
    public static final char SPADES = 's';
    public static final int LOWEST_VALUE = 2;
    public static final char HIGHEST_VALUE = 14;
    public static final int QUEEN_VALUE = 12;

    /**
     * This method is used for sorting cards.
     * It orders the cards by suit (Clubs, Diamonds, Spades, Hearts) and then by
     * value within the suit
     * @param other The Card object to which this Card is being compared.
     * @return  negative value if this Card should be before the other Card,
     *          positive value if this Card should be after the other Card,
     *          0 if this Card has the same suit and value as the other Card.
     */
    public int compareTo(Card other) {
        if (getSuit() == other.getSuit()) {
            if (getValue() < other.getValue()) {
                return -1;
            } else if (getValue() > other.getValue()) {
                return 1;
            }
            else {
                return 0;
            }
        } 
        else {
            switch(getSuit()) {
                case HEARTS:
                    return 1;
                case SPADES:
                    if (other.getSuit() == HEARTS) {
                        return -1;
                    } 
                    else {
                        return 1;
                    }
                case DIAMONDS:
                    if (other.getSuit() == HEARTS || other.getSuit() == SPADES) {
                        return -1;
                    } 
                    else {
                        return 1;
                    }
                //CLUBS
                default:
                    return -1;
            }
        }
    }

   


}
