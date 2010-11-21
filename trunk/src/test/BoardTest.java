package src.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import src.fr.scrabble.modele.modele.Bag;
import src.fr.scrabble.modele.modele.Board;
import src.fr.scrabble.modele.modele.Dictionary;
import src.fr.scrabble.modele.modele.LanguageEn;
import src.fr.scrabble.modele.modele.Letter;
import src.fr.scrabble.modele.modele.Rack;
import src.fr.scrabble.modele.modele.Word;

/**
 * 
 * @author Dijgo
 *
 */

public class BoardTest   {
    
    
    private Rack rack;
    private Bag bag;
    private Word word0, word1, word2, word3, word4, word5;
    Board board = new Board();
    Dictionary dico = new Dictionary("anglais.txt");

    @Before
    public void setUp() throws Exception {

        LanguageEn lang = new LanguageEn();
        this.bag = new Bag(lang);

        List<Letter> letters = new ArrayList<Letter>();

        letters.add(new Letter('T', 1));
        letters.add(new Letter('E', 1));
        letters.add(new Letter('S', 1));
        letters.add(new Letter('T', 1));
        letters.add(new Letter('A', 1));
        letters.add(new Letter('B', 1));
        letters.add(new Letter('C', 1));

        this.rack = new Rack(letters);

        this.word0 = new Word("test", 1, 2, 'r');
        this.word1 = new Word("test", 2, 2, 'c');

        this.word2 = new Word("false", 1, 2, 'r');
        this.word3 = new Word("false", 1, 2, 'c');

        this.word4 = new Word("test", 16, 2, 'r');
        this.word5 = new Word("test", 1, 15, 'r');

    }

    // Ces tests sont cens� etre valides
    @Test
    public void testAddWord() {

        Assert.assertTrue(this.board.addWord(this.word0, this.rack, this.bag,this.dico));
    }

    @Test
    public void testAddWord1() {
        Assert.assertTrue(this.board.addWord(this.word1, this.rack, this.bag,this.dico));

    }

    // tests regressifs
    @Test
    public void testAddWord2() {
        // lettres invalides
        Assert.assertFalse(this.board.addWord(this.word2, this.rack, this.bag,this.dico));
    }

    @Test
    public void testAddWord3() {
        // lettres invalides
        Assert.assertFalse(this.board.addWord(this.word3, this.rack, this.bag,this.dico));
    }

    @Test
    public void testAddWord4() {
        // placement invalide
        Assert.assertFalse(this.board.addWord(this.word4, this.rack, this.bag,this.dico));
    }

    @Test
    public void testAddWord5() {
        // placement invalide
        Assert.assertFalse(this.board.addWord(this.word5, this.rack, this.bag,this.dico));
    }


   

}
