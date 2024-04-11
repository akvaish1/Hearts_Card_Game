
/**
 * This class represents a single playing card used in the Hearts Game.
 * @author Arjun Vaish
 */
public class Card implements Comparable<Card> {
    
    /** Char value that represents Clubs */
    public static final char CLUBS = 'c';
   
    /** Char value that represents Diamonds */
    public static final char DIAMONDS = 'd';
   
    /** Char value that represents Hearts */
    public static final char HEARTS = 'h';
    
    /** Char value that represents Spades */
    public static final char SPADES = 's';
    
    /** Lowest numeric value for a card */
    public static final int LOWEST_VALUE = 2;
    
    /** Highest numeric value for a card */
    public static final char HIGHEST_VALUE = 14;
    
    /** Numeric value for a  Queen */
    public static final int QUEEN_VALUE = 12;
    
    /** Char that represents the suit shown on the card */
    private char suit;

    /** An integer that represnets the value shown on the card */
    private int value;

    /** A boolean that shows wether a card has been played */
    private boolean hasBeenPlayed;

    /** 
    * The constructor of the class. It accepts a suit and a value to assign to the instance fields.
    * @param suit character that represents the suit shown on the card
    * @param value int that represents the numeric value of the card
    * @throws IllegalArgumentException if suit value is invalid
    * @throws IllegalArgumentException if value is not in valid range
    */
    public Card(char suit, int value) {
        if (suit != CLUBS && suit != DIAMONDS && suit != HEARTS && suit != SPADES) {
            throw new IllegalArgumentException("Invalid suit");
        }

        if (value > HIGHEST_VALUE || value < LOWEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.suit = suit;
        this.value = value;
        this.hasBeenPlayed = false;
    }
    
    /**  
     * returns the value of the suit
     * @return the suit of the card
    */
    public char getSuit() {
        return this.suit;
    }
    
    /**
     * returns the integer value of the card
     * @return the integer value of the card
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * returns a boolean of wether the card has been played
     * @return a boolen of wether card has been played
     */
    public boolean hasBeenPlayed() {
        return this.hasBeenPlayed;
    }
    
    /**
     * sets the boolean true or false value wether the card has been played
     * @param played a boolean value on wether the card has been played
     */
    public void setPlayed(boolean played){
        this.hasBeenPlayed = played;
    }
    
    /**
     *  This method returns true if the card is of the suit “Hearts”. 
     * Otherwise, the method returns false
     * @return true if the suit of the card is Hearts and false if it is not
     */
    public boolean isHeart() {
        if (this.suit == 'h') {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method returns true if the card is a queen of spades and false otherwise
     * @return true if the suit of the card is queen and the value is 12 otherwise return false
     */
    public boolean isQueenOfSpades() {
        if (this.suit == 's' && this.value == QUEEN_VALUE){
            return true;
        }

        else {
            return false;
        }
    }

   
    /**
     * This method returns true if the value of the card is more than the value of another card
     * @param Other another object of class Card
     * @return true if the value of the orignal Card is more than the value of the other Card
     */
    public boolean isHigherThan(Card Other) {
        if (this.suit == Other.suit || this.value > Other.suit) {
            return true;
          
        } else {
            return false;
        }
    }

     /**
      * This method returns wether the cards are equal to each other
      * if they have same suit and same card value and if it has already been played.
      * @param o card object it is comparing to
      * @return true if cards are equal
      * 
      */
    public boolean equals(Object o) {
        if(o instanceof Card) {
            Card card = (Card) o;
            if (this.suit == card.suit && this.value == 
                 card.value && this.hasBeenPlayed == card.hasBeenPlayed) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * returns a string representation of the card
     * @return string representation of the card
     */
    public String toString() {
        return "" + this.suit + this.value;
    }

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
