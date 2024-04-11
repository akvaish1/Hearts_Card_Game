import java.util.*;

/**
 * The Deck class represents a deck of 52 playing cards.
 * @author Arjun Vaish
 */
public class Deck {
   
    /** Represents the ammount of Cards in a deck */
    public static final int CARDS_IN_DECK = 52;

    /** How many Cards in a certain suit are in the deck */
    public static final int CARDS_PER_SUIT = 13;
   
    /** Represents an array of Cards that is used to manage CARDS_IN_DECK*/
    private Card [] cards;

    /** Represents the index of the next card in the deck  */
    private int next;
    
    /**
     * This is the constructor of the Deck class
     * Initalizes the array to hold 52 card values
     * sets next to 0
     */
    public Deck() {
        this.cards = new Card[CARDS_IN_DECK];
        
        for (int i = 0; i < CARDS_PER_SUIT; i++) {
            cards[i] = new Card(Card.CLUBS,Card.LOWEST_VALUE + i);
        }

        for (int i = 0; i < CARDS_PER_SUIT; i++) {
            cards[CARDS_PER_SUIT + i] = new Card(Card.DIAMONDS, Card.LOWEST_VALUE + i);
        }

        for(int i = 0; i < CARDS_PER_SUIT; i++) {
            cards[CARDS_PER_SUIT * 2 + i] = new Card(Card.SPADES, Card.LOWEST_VALUE + i );
        }

        for(int i = 0; i < CARDS_PER_SUIT; i++) {
            cards[CARDS_PER_SUIT * 3 + i] = new Card(Card.HEARTS, Card.LOWEST_VALUE + i);
        }
        
        this.next = 0;

    }
    
    /**
     * Getter method which returns the value of next
     * @return next returns the value of next
     */
    public int getNext() {
        return this.next;
    }

    /**
     * Getter method which returns the instance field cards
     *  @return instance field cards
     */
    public Card[] getCards() {
        return this.cards;
    }

   
    /**
     * This method changes the order of the cards array randomly
     */
    public void shuffle() {
        
        Random rand = new Random();
        int n = 0;
        Card previous = new Card('c',2);
        for(int i = CARDS_IN_DECK - 1; i > 0; i-- ) {
            n = rand.nextInt(i);
            previous = this.cards[i];
            this.cards[i] = this.cards[n];
            this.cards[n] = previous;
            
        }
    }

    /**
     * This method resets the deck for a new hand to be played
     */
    public void initialize() {
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            this.cards[i].setPlayed(false);
        }
        this.next = 0;
    }

    /**
     * This method returns the next card in the deck
     * @return the next card in the deck
     * @throws IllegalStateException if next is already greater 
     * than or equal to ammount of cards in the deck
     */
    public Card nextCard() {
        
        if (this.next >= CARDS_IN_DECK) {
            throw new IllegalStateException("No more cards");
        }
        
        this.next++;

        return this.cards[this.next - 1];
      
    }
    
    /**
     * Returns wether the deck and another object are equal
     * @param o Object that we are seeing if it is equal to the deck
     * @return if object and deck are equal by having same value and suit and have next index
     */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck other = (Deck) o;
            for(int i = 0; i < CARDS_IN_DECK; i++) {
                if(this.cards[i].getValue() != other.cards[i].getValue() 
                    || this.cards[i].getSuit() != other.cards[i].getSuit() 
                    || this.next != other.next ) {
                    return false;
                } 
                
               
            }
            return true;

        } else {
            return false;
        }

    }
    
    /**
     * Returns string representation of the deck
     * @return String representation of the deck
     */
    public String toString() {
        String x = "";
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            x +=  "card " + i + ": " + this.cards[i].toString() + "\n";
        }
        return x;
    }
}



