import java.util.*;

/**
 * The Player class represents a single player in a game of Hearts. 
 * @author Arjun Vaish
 */
public class Player {
 
    /** An integer value to represent the number of cards a player holds at a time */
    public static final int CARDS_IN_HAND = 13;

    /** String variable that holds the players name */
    private String name;

    /** An integer variable that holds the player’s overall score */
    private int overallPoints;

    /** an integer variable that holds the player’s points for the current hand */
    private int handPoints;

    /** an array of Card objects that makes up the player’s hand */
    private Card [] hand;

    /** an integer variable that knows the position within the array of 
      Card objects in which the next card dealt to the player should be placed */
    private int next;

    /**
     * Sets values to the fields of the class
     * @param name the Name of the player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Card [CARDS_IN_HAND];
        this.overallPoints = 0;
        this.handPoints = 0;
        this.next = 0;
    }

    /**
     * Returns the name of the player
     * @return name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method adds a new card that has been
     *  dealt to the player from the deck and places it in the player’s “hand”.
     * @param card the card that is being dealt to the player
     * @throws IllegalStateException if next is greater than CARDS_IN_HAND
     * 
     */
    public void addCard(Card card) {
       
        if(this.next >= CARDS_IN_HAND) {
            throw new IllegalStateException("Full Hand");
        }
        
        hand[next] = card;
        
        if(this.next == CARDS_IN_HAND) {
            Arrays.sort(hand);
        }
        next++;
        
        
    }

    /**
     *  getter method for the instance 
     * field that knows the current number of points the player has obtained in the current hand.
     * @return handPoints instance field
     */
    public int getHandPoints() {
        return this.handPoints;
    }

    /**
     *  getter method for the instance 
     * field that knows the current number of points the player has obtained overall.
     * @return overallPoints instance field
     */
    public int getOverallPoints() {
        return this.overallPoints;
    }

    /**
     * updates the current number of points a player has obtained in the current hand
     * @param points the number of points ot be added to handpoints and overall points
     */
    public void addToHandPoints(int points) {
        this.handPoints += points;
        this.overallPoints += points;
    }

    /**
    * Returns the card from the player’s hand at the index specified by the parameter.
    * 
    * @param index the index of the card in the hand array that we want to be returned
    * @return the card at the specified index
    * @throws IllegalArgumentException if the index is not in the valid range
    */
    public Card getCard(int index) {
        
        if(index < 0 || index > CARDS_IN_HAND ) {
            throw new IllegalArgumentException("Invalid index");
        }

        return this.hand[index];

    }

    /**
    * This method determines if the cards that have not been played yet in the player’s hand.
    * 
    * @param suit the suit of the card we want to see if it is in the deck
    * @return boolean that states true if suit is in the hand or false otherwise
    * @throws IllegalStateException if 'next' is less than 'Cards_IN_HAND'
    */
    public boolean hasActiveCardOfSuit(char suit) {
        
        if(next < CARDS_IN_HAND) {
            throw new IllegalStateException("Hand not full");
        }
        
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            if (hand[i].getSuit() == suit && hand[i].hasBeenPlayed() == false) {
                return true;
            } 
        }
        return false;
    }

    /**
     * Returns true of false wether remaing unplayed cards in the dech are all hearts
     * @return true or false wether remaining unplayed cards in deck are hearts
     * @throws IllegalStateException if 'next' is less than 'Cards_IN_HAND'
     */
    public boolean onlyHasHearts() {
       
        if(next < CARDS_IN_HAND) {
            throw new IllegalStateException("Hand not full");
        }
       
       
       
        for(int i = 0; i < CARDS_IN_HAND; i++) {
            if (hand[i].hasBeenPlayed() == false) {
                if (hand[i].getSuit() != Card.HEARTS) {
                    return false;
                }
            }
        }
        return true;
    }

   
    /**
     * Returns a String array of the Cards in the hand
     * @return a String array of the Cards in the hand
     * @throws IllegalStateException if 'next' is less than 'Cards_IN_HAND'
     */
    public String [] getCardNames() {
       
        if(next < CARDS_IN_HAND) {
            throw new IllegalStateException("Hand not full");
        }
        
        String [] arr = new String[CARDS_IN_HAND];
        for(int i = 0; i < CARDS_IN_HAND; i++) {
            arr[i] = this.hand[i].toString();
        }

        return arr;
    }

    /**
     * To string method that gives a String representation 
     * of how many points the player has for that round
     * @return the ammount of points a player has for a round.
     */
    public String toString() {
        return this.name + ": " + this.handPoints;
    }
    
    /**
     * This method simulates returning a player’s cards back to the deck. 
     * 
     */
    public void dumpCards(){
        this.next = 0;

        for(int i = 0; i < CARDS_IN_HAND; i++) {
            this.hand[i] = null;
        }
    }

    /**
     * This method sets hand points to 0 which gets the game ready for the next round
     */
    public void resetHandPoints() {
        this.handPoints = 0;
    }

      /**
     * This method determines the card that a computer player will play in the
     * current round (trick). This method assumes the hand has been sorted and
     * is in order by suits - clubs, diamond, spades, hearts - and the values of
     * the cards in each suit are ordered from lowest to highest value.
     * @param startingCard the card that started the round
     * @param isFirstRound whether or not this is the first round of a hand
     * @param heartsStarted whether or not hearts are in play at this point in the hand
     * @return the card that will be played
     * @throws IllegalStateException if there is no unplayed card in hand
     */
    public Card getMove(Card startingCard, boolean isFirstRound, boolean heartsStarted) {
        
        //If this is the first round (trick) and the computer player has the 2 of Clubs, 
        //they must play it. If the player has the 2 of Clubs, it should be the first 
        //card in their (sorted) hand
        if (isFirstRound && startingCard == null && 
            hand[0].getSuit() == Card.CLUBS && hand[0].getValue() == 2) {
            hand[0].setPlayed(true);
            return hand[0];
        } 
        
        //If an initial card was played, the computer player must follow suit
        //and will play the lowest card in that suit
        if (startingCard != null) {
            char currentSuit = startingCard.getSuit(); 
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (!hand[i].hasBeenPlayed() && hand[i].getSuit() == currentSuit) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
        }

        //If no card with a matching suit was found and it's not the first round(trick)
        //the computer player will play the Queen of Spades if they have it and it
        //hasn't been played yet
        //If not, they will play their highest valued Heart, if they have one and it
        //hasn't been played yet
        if (startingCard != null && !isFirstRound) {
            //Look for the Queen of Spades
            for (int i = 0; i < CARDS_IN_HAND; i++) {
                if (hand[i].getSuit() == Card.SPADES && hand[i].getValue() == Card.QUEEN_VALUE &&
                    !hand[i].hasBeenPlayed()) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
            for (int i = CARDS_IN_HAND - 1; i >= 0; i--) {
                if (hand[i].getSuit() == Card.HEARTS && !hand[i].hasBeenPlayed()) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
            }
        }

        //If no card has been found yet, the first card that hasn't been played
        //in the sorted hand will be played
        for (int i = 0; i < hand.length; i++) {
            if (!hand[i].hasBeenPlayed()) {
                
                //A club or diamond is always valid
                if (hand[i].getSuit() == Card.CLUBS ||
                    hand[i].getSuit() == Card.DIAMONDS) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }
                
                //All spades other than the queen are valid
                //The queen of spades can be played if it's not the
                //first round(trick)
                if (hand[i].getSuit() == Card.SPADES) {
                    if (hand[i].getValue() != Card.QUEEN_VALUE) {
                        hand[i].setPlayed(true);
                        return hand[i];
                    }
                    else if (!isFirstRound) {
                        hand[i].setPlayed(true);
                        return hand[i];
                    }
                }
                
                //A heart is valid if it's not the first round 
                //and either hearts have been played previously or
                //the player only has hearts. NOTE: This case would 
                //occur when the player is playing the initial card
                //in the trick
                if (hand[i].getSuit() == Card.HEARTS && !isFirstRound && 
                    (heartsStarted || onlyHasHearts())) {
                    hand[i].setPlayed(true);
                    return hand[i];
                }    
            }
        }
        //No card found so far - this could happen in the unlikely situation
        //that the player's hand contained only hearts or
        //the Queen of spades with the rest of the cards being hearts
        //Return the first unplayed card        
        for (int i = 0; i < hand.length; i++) {
            if (!hand[i].hasBeenPlayed()) {
                hand[i].setPlayed(true);
                return hand[i];
            }
        }
        //No unplayed card in hand
        throw new IllegalStateException("No unplayed card in hand");

    }



}
