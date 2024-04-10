import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO: Add documentation to pass checkstyle

/**
 * Tests Card class
 * 
 * @author Jessica Young Schmidt
 * @author
 */
public class CardTest {

    /** three of clubs */
    private Card c3;
      

    /**
     * Sets up field for testing
     */
    @BeforeEach
    public void setUp() {
        c3 = new Card('c', 3);       
    }

    /**
     * Test invalid constructor parameters
     */
    @Test
    public void testInvalidConstructorParameters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Card('a', 33),
                "invalid suit");
        assertEquals("Invalid suit", exception.getMessage(), "invalid suit - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Card('c', 1),
                "invalid value (1)");
        assertEquals("Invalid value", exception.getMessage(),
                "invalid value (1) - exception message");

        // NOTE: You are not required to add additional invalid parameter test. However,
        // you may add tests if you would like. Not all paths through your Card
        // constructors will be tested by the given tests above.
    }
    
  

    /**
     * Test getSuit for three of clubs
     */
    @Test
    public void testGetSuitA() {
        assertEquals('c', c3.getSuit(), "Test getSuit for three of clubs");
    }

    @Test
    public void testGetSuitB() {
        // TODO: Write another test of getSuit
        // 1. Create a new Card (not a club)
        // 2. Write an assertEquals test for getSuit for created card
        fail("No test added");        
    }

    /**
     * Test getValue for three of clubs
     */
    @Test
    public void testGetValueA() {
        assertEquals(3, c3.getValue(), "Test getValue for three of clubs");
    }

    @Test
    public void testGetValueB() {
        // TODO: Write another test of getValue
        // 1. Create a new Card (not a 3)
        // 2. Write an assertEquals test for getValue for created card
        fail("No test added");
    }

    /**
     * Test hasBeenPlayed
     */
    @Test
    public void testHasBeenPlayed() {
        assertFalse(c3.hasBeenPlayed(), "Test hasBeenPlayed for three of clubs before played");
        c3.setPlayed(true);
        assertTrue(c3.hasBeenPlayed(), "Test hasBeenPlayed for three of clubs after played");
    }
    

    @Test
    public void testSetPlayed() {
        // TODO: Write test for setPlayed method using c3
        // 1. call setPlayed(true)
        // 2. assertTrue for hasBeenPlayed
        // 3. call setPlayed(false)
        // 4. assertFalse for hadBeenPlayed
        fail("No test added");        
    }
       

    /**
     * Test isHeart for three of clubs
     */
    @Test
    public void testIsHeartA() {
        assertFalse(c3.isHeart(), "Test isHeart for three of clubs");
    }

    @Test
    public void testIsHeartB() {
        // TODO: Write test for isHeart that will return true (create a new Card that is a heart)
        fail("No test added");
    }

    /**
     * Test toString for three of clubs
     */
    @Test
    public void testToStringA() {
        assertEquals("c3", c3.toString(), "Test toString for three of clubs");
    }

    @Test
    public void testToStringB() {
        // TODO: Write another test for toString
        // 1. Create a new Card (not a 3 of clubs)
        // 2. Write an assertEquals test for toString for created card
        fail("No test added");        
        
    }

    /**
     * Test equals for three of clubs
     */
    @Test
    public void testEqualsA() {
        assertTrue(c3.equals(c3), "Test equals for three of clubs");
    }

    @Test
    public void testEqualsB() {
        // TODO: Write test for equals that would return false - cards with different
        // suits
        fail("No test added");        
    }

    @Test
    public void testEqualsC() {
        // TODO: Write test for equals that would return false - cards with same suit
        // but different values
        fail("No test added");        
    }

    @Test
    public void testEqualsD() {
        // TODO: Write test for equals that would return false - cards with same suit
        // and same value but different hasBeenPlayed
        fail("No test added");        
    }

    /**
     * Test compareTo for three of clubs and three of spades
     */
    @Test
    public void testCompareToA() {
        Card s3 = new Card('s', 3);
        assertTrue(c3.compareTo(s3) < 0, "Test compareTo for three of clubs and three of spades");
    }

    @Test
    public void testCompareToB() {
        Card c2 = new Card('c', 2);
        assertTrue(c3.compareTo(c2) > 0,"Test compareTo for three of clubs and two of clubs");
    }

    @Test
    public void testCompareToC() {
        Card h2 = new Card('h', 2);
        assertTrue(h2.compareTo(c3) > 0, "Test compareTo for two of hearts and three of clubs");
    }

    @Test
    public void testCompareToD() {
        Card c4 = new Card('c', 4);
        assertTrue(c3.compareTo(c4) < 0, "Test compareTo for three of clubs and four of clubs");
    }

    @Test
    public void testCompareToE() {
        Card c3Two = new Card('c', 3);
        assertEquals(0, c3.compareTo(c3Two), 
                     "Test compareTo for three of clubs and three of clubs");
    }

    /**
     * Test isQueenOfSpades for three of clubs
     */
    @Test
    public void testIsQueenOfSpadesA() {
        assertFalse(c3.isQueenOfSpades(), "Test isQueenOfSpades for three of clubs");
    }

    @Test
    public void testIsQueenOfSpadesB() {
        // TODO: Write test for isQueenOfSpades that would return true
        fail("No test added");        
    }

    @Test
    public void testIsQueenOfSpadesC() {
        // TODO: Write test for isQueenOfSpades that would return false with card that is a spade
        fail("No test added");        
    }

    /**
     * Test isHigherThan for four of clubs and three of clubs
     */
    @Test
    public void testIsHigherA() {
        Card c4 = new Card('c', 4);
        assertTrue(c4.isHigherThan(c3), "Test isHigherThan for four of clubs and three of clubs");
        fail("No test added");        
    }

    @Test
    public void testIsHigherB() {
        // TODO: Write test for isHigherThan that returns false with different suits
        fail("No test added");        
    }

    @Test
    public void testIsHigherC() {
        // TODO: Write test for isHigherThan that returns false with same suit
        fail("No test added");        
    }

    /**
     * Tests values for public constants
     */
    @Test
    public void testClassConstants() {
        assertEquals('c', Card.CLUBS, "Test CLUBS constant");
        assertEquals('d', Card.DIAMONDS, "Test DIAMONDS constant");
        assertEquals('s', Card.SPADES, "Test SPADES constant");
        assertEquals('h', Card.HEARTS, "Test HEARTS constant");
        assertEquals(2, Card.LOWEST_VALUE, "Test LOWEST_VALUE constant");
        assertEquals(14, Card.HIGHEST_VALUE, "Test HIGHEST_VALUE constant");
        assertEquals(12, Card.QUEEN_VALUE, "Test QUEEN_VALUE constant");
    }

}