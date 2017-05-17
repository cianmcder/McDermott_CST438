package com.csumb.cst438.a1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of Game class
 * @author david wisneski
 * @veraion 1.0
 */
public class GameTest {
    
    public GameTest() {
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
     * Test of getState method, of class Game.
     * at start of game, state should be 1.
     * a correct guess will not change the state
     * an incorrect guess will increase state by 1
     */
    @org.junit.Test
    public void testGetState() {
        System.out.println("getState");
        Game instance = new Game();
        int expResult = 1;
        String word = instance.getWord();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        int result = instance.getState();
        assertEquals(expResult, result);
        //Tests for a correct guess
        //Errors caused me to make a string ch and char c for the test
        String ch = word.substring(0, 1);
        char c = word.charAt(0);
        instance.playGame(c, true);
        result = instance.getState();
        if(word.contains(ch) == false)
            expResult += 1;
        assertEquals(expResult, result);
        //tests for incorrect guess
        char incorrect = ' ';
        String inc = " ";
        for(int i = 0; i < 26; i++)
        {
            if(word.contains(letters.substring(i, 1+1)) == false)
            {
                incorrect = letters.charAt(i);
                inc = letters.substring(i, i+1);
                break;
            }
        }
        instance.playGame(incorrect, false);
        result = instance.getState();
        if(word.contains(inc) == false)
            expResult += 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of getWord method, of class Game.
     */
    @org.junit.Test
    public void testGetWord() {
        System.out.println("getWord");
        Game instance = new Game();
        //Cannot find a way to test except running it twice and comparing
        String expResult = instance.getWord();
        String result = instance.getWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayWord method, of class Game.
     */
    @org.junit.Test
    public void testGetDisplayWord() {
        System.out.println("getDisplayWord");
        Game instance = new Game();
        String expResult = "";
        //Repeats "_ " for every character, then deletes the last " " outside the for-loop
        for(int i = 0; i < instance.getWord().length(); i++)
            expResult += "_ ";
        expResult = expResult.substring(0, expResult.length()-1);
        String result = instance.getDisplayWord();
        assertEquals(expResult, result);
        instance.playGame(instance.getWord().charAt(0), true);
        result = instance.getDisplayWord();
        //Changes expResult based on the first letter in the word
        char c = instance.getWord().charAt(0);
        expResult = expResult.substring(1, expResult.length());
        expResult = c + expResult;
        assertEquals(expResult, result);

    }

    /**
     * Test of startNewGame method, of class Game.
     */
    @org.junit.Test
    public void testStartNewGame() {
        System.out.println("startNewGame");
        Game instance = new Game();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        instance.startNewGame();
        int i = 0;
        String ch = "";
        char c = ' ';
        //Tests for two different letters that are not in the instance's word
        while(instance.getWord().contains(letters.substring(i,i+1)) == true && i < 26)
            i++;
        ch = letters.substring(i, i+1);
        c = letters.charAt(i);
        instance.playGame(c, true);
        while(instance.getWord().contains(ch) == true && i < 26)
            i++;
        instance.playGame(c, true);
        instance.startNewGame();
        int result = instance.getState();
        assertEquals(1,result);
 
    }

    /**
     * Test of playGame method, of class Game.
     *   correct guess should return 0 , or 1 when game is won
     *   incorrect guess should return 2, or 3 when game is lost
     */
    @org.junit.Test
    public void testPlayGame() {
        System.out.println("playGame");
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Game instance = new Game();
        int expResult = 0;
        String ch = "";
        char c = ' ';
        for(int i = 0; i < 26; i++)
        {
            ch = letters.substring(i, i+1);
            if(instance.getWord().contains(ch) == true)
            {
                c = letters.charAt(0);
                break;
            }
        }
        int result = instance.playGame(c, true);
        assertEquals(expResult, result);
        int i = 0;
        while(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(2, result);
        while(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(2, result);
        while(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(2, result);
        while(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(2, result);
        while(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(2, result);
        while(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(3, result);
 
        instance.startNewGame();
        //For-loop tests up until result will return a 0
        int corrects = 0;
        for(i = 0; i < 26; i++)
        {
            int stopper = instance.getWord().length() - 1;
            if(instance.getWord().contains(letters.substring(i, i+1)) == true && i < 26)
            {
                c = letters.charAt(i);
                result = instance.playGame(c, true);
                assertEquals(0,result);
                corrects++;
            }
            if(corrects == stopper)
                break;
        }
        //One last test for victory
        while(instance.getWord().contains(letters.substring(i, i+1)) == false && i < 26)
            i++;
        c = letters.charAt(i);
        result = instance.playGame(c, true);
        assertEquals(1, result);
    }
    
}
