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
        instance.playGame(word.charAt(0));
        result = instance.getState();
        if(word.contains(word.charAt(0)) == false)
            expResult += 1;
        assertEquals(expResult, result);
        //tests for incorrect guess
        char incorrect = ' ';
        for(int i = 0; i < 26; i++)
        {
            if(word.contains(letters.charAt(i)) == false)
            {
                incorrect = letters.charAt(i);
                break;
            }
        }
        instance.playGame(incorrect);
        result = instance.getState();
        if(word.contains(incorrect) == false)
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
        instance.playGame(getWord().charAt(0));
        result = instance.getDisplayWord();
        //Changes expResult based on the first letter in the word
        char c = getWord.charAt(0);
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
        //Tests for two different letters that are not in the instance's word
        while(instance.getWord().contains(letters[i]) == true && i < 26)
            i++;
        instance.playGame(letters[i]);
        while(instance.getWord().contains(letters[i]) == true && i < 26)
            i++;
        instance.playGame(letters[i]);
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
        char guess = ' ';
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Game instance = new Game();
        int expResult = 0;
        for(int i = 0; i < 26; i++)
        {
            if(instance.getWord().contains(letters[i]) == true)
            {
                guess = letters[i];
                break;
            }
        }
        int result = instance.playGame(guess);
        assertEquals(expResult, result);
        int i = 0;
        while(letters.contains(instance.getWord(charAt(i))) == true && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(2, result);
        while(letters.contains(instance.getWord(charAt(i))) == true && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(2, result);
        while(letters.contains(instance.getWord(charAt(i))) == true && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(2, result);
        while(letters.contains(instance.getWord(charAt(i))) == true && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(2, result);
        while(letters.contains(instance.getWord(charAt(i))) == true && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(2, result);
        while(letters.contains(instance.getWord(charAt(i))) == true && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(3, result);
 
        instance.startNewGame();
        //For-loop tests up until result will return a 0
        int corrects = 0;
        for(i = 0; i < 26; i++)
        {
            int stopper = instance.getWord().length() - 1;
            if(instance.getWord().contains(letters[i]) == true && i < 26)
            {
                result = instance.playGame(letters[i]);
                assertEquals(0,result);
                corrects++;
            }
            if(corrects == stopper)
                break;
        }
        //One last test for victory
        while(instance.getWord().contains(letters[i]) == false && i < 26)
            i++;
        result = instance.playGame(letters[i]);
        assertEquals(1, result);
    }
    
}
