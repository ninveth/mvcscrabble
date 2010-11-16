/**
 * 
 */
package src.fr.scrabble.modele.modele;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import src.fr.scrabble.modele.exceptions.BagIsEmptyException;



/**
 * @author marovelo
 *
 */
public class Bag {
    
    private static Random rand = new Random();

    private List<Letter> letters;

    public Bag(Language lang) {
        Hashtable<Letter, Integer> lettersDistribution = lang.getDic();
        this.letters = new ArrayList<Letter>();

        Enumeration<Letter> enu = lettersDistribution.keys();
        while (enu.hasMoreElements()) {
            Letter l = enu.nextElement();
            for (int i = 0; i < lettersDistribution.get(l).intValue(); i++)
                this.letters.add(l);
        }

    }

    /**
     * Pioche une lettre dans le sac
     * 
     * @return la lettre piochée
     * @throws Exception 
     */
    public Letter pickRandomLetter()  {
        if (this.isEmpty())
            throw new BagIsEmptyException();
        return this.letters.remove(Bag.rand.nextInt(this.letters.size()));
    }

    /**
     * 
     * @return TRUE si le sac est vide
     */
    public boolean isEmpty() {
        return this.letters.size() == 0;
    }

    /**
     * 
     * @return le nombre de lettres dans le sac
     */
    public int getSize() {
        return this.letters.size();
    }

    @Override
    /**
     * Affiche le contenu du sac
     */
    public String toString() {
        String s = "";
        Iterator<Letter> it = this.letters.iterator();
        while (it.hasNext()) {
            Letter l = it.next();
            s += l + "\n";
        }
        return s;
    }


}
