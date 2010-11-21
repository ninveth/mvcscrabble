package src.test;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.fr.scrabble.modele.modele.Word;




/**
 * 
 * @author Dijgo
 *
 */
public class WordTest {
    
    private static Word w1;

    @Before
    public static void setUp() throws Exception {
        w1 = new Word("test", 1, 2, 'r');
    }

    @Test
    public void testGetX() {
        Assert.assertEquals(1, w1.getX());
    }

    @Test
    public void testGetY() {
        Assert.assertEquals(2, w1.getY());
    }

    @Test
    public void testGetDirection() {
        Assert.assertEquals('r', w1.getDirection());
    }

    @Test
    public void testGetWord() {
        Assert.assertEquals("test", w1.getWord());
    }

    @Test
    public void testAddPoints() {
        fail("Not yet implemented");
    }


}
