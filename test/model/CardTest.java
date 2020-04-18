/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.image.Image;
import static model.CardNumber.Ace;
import static model.CardNumber.Five;
import static model.CardNumber.King;
import static model.CardNumber.Nine;
import static model.CardSuit.Clubs;
import static model.CardSuit.Diamonds;
import static model.CardSuit.Hearts;
import static model.CardSuit.Spades;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chetan Kairon
 */
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCardSuit method, of class Card.
     */
    @Test
    public void validGetCardSuit() {
        Card card = new Card(CardNumber.Ace,CardSuit.Hearts);
        CardSuit instance = Hearts;
        CardSuit expResult = Hearts;
        CardSuit result = card.getCardSuit();
        assertEquals(expResult, result);
    }
    
 @Test
    public void badGetCardSuit() {
        Card card = new Card(CardNumber.Ace,CardSuit.Clubs);
        CardSuit instance = Hearts;
        CardSuit expResult = Clubs;
        CardSuit result = card.getCardSuit();
        assertEquals(expResult, result);
    }
    
     @Test
    public void boundaryGetCardSuit() {
        Card card = new Card(CardNumber.Ace,CardSuit.Spades);
        CardSuit instance = Spades;
        CardSuit expResult = Spades;
        CardSuit result = card.getCardSuit();
        assertEquals(expResult, result);
    }
  
    /**
     * Test of getValue method, of class Card.
     */
    
    @Test
    public void validGetValue() {
        Card card = new Card(Ace, Spades);
        int expResult = 1;
        int result = Card.getValue(card);
        assertEquals(expResult, result);
    }
        @Test
    public void BadGetValue() { 
        Card card = new Card(Ace, Spades);
        int expResult = 15;
        int result = Card.getValue(card);
        assertEquals(expResult, result);
       
    }
        @Test
    public void BoundaryGetValue() {
        Card card = new Card(King, Clubs);
        int expResult = 13;
        int result = Card.getValue(card);
        assertEquals(expResult, result);
       
        
    }
    
}
