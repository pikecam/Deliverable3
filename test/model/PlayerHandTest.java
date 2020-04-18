/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author work
 */
public class PlayerHandTest {
    
    public PlayerHandTest() {
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
     * Test of isBetLocked method, of class PlayerHand.
     */
    @Test
    public void ValidBetLocked() {
        PlayerHand instance = new PlayerHand();
        boolean expResult = true;
        boolean result = instance.isBetLocked();
        assertEquals(expResult, result);
    }
    
    @Test
    public void BadBetLocked() {
        PlayerHand instance = new PlayerHand();
        boolean expResult = false;
        boolean result = instance.isBetLocked();
        assertEquals(expResult, result);
    }

    @Test
    public void boundaryBetLocked() {
        PlayerHand instance = new PlayerHand();
        boolean expResult = true;
        boolean result = instance.isBetLocked();
        assertEquals(expResult, result);
    }


 

    /**
     * Test of getChipsTotal method, of class PlayerHand.
     */
    
    @Test
    public void ValidGetChipsTotal() {
        PlayerHand instance = new PlayerHand();
        int expResult = 100;
        int result = instance.getChipsTotal();
        assertEquals(expResult, result);
      
    }

 
    @Test
    public void badGetChipsTotal() {
        PlayerHand instance = new PlayerHand();
        int expResult = -10;
        int result = instance.getChipsTotal();
        assertEquals(expResult, result);
      
    }
@Test
    public void boundaryGetChipsTotal() {
        PlayerHand instance = new PlayerHand();
        int expResult = 10000;
        int result = instance.getChipsTotal();
        assertEquals(expResult, result);
      
    }

    
}
