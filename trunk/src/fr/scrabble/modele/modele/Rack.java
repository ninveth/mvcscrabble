package src.fr.scrabble.modele.modele;

import java.util.ArrayList;
import java.util.List;



public class Rack {
    
    
    private static final int NB_LETTERS_MAX = 7;
    private List<Letter> letters = new ArrayList<Letter>();
 

    public Rack() {

    }

    public Rack(List<Letter> letters) {
        this.letters = letters;
    }

    /**
     * remplit les emplacements vides du rack jusqu'� ce qu'il soit plein et ce
     * sans depasser sa taille
     * 
     * @param bag
     *            un sac de lettres
     * @throws Exception 
     */
    public void fillrack(Bag bag)  {

        while (this.letters.size() < NB_LETTERS_MAX) {

            this.letters.add(bag.pickRandomLetter());
        }
    }

    /**
     * 
     * @return TRUE si le rack est vide sinon FALSE
     */
    public boolean isEmpty() {

        return this.letters.isEmpty();
    }

    /**
     * 
     * @param l
     *            la lettre dont on veut savoir si elle est contenue dans le
     *            rack
     * @return TRUE si l y est, FALSE sinon
     */
    public boolean contains(Letter l) {

        return this.letters.contains(l);
    }

    /**
     * Supprime l du rack et la remplace par une lettre aleatoire
     * 
     * @param l
     *            la lettre a enlever
     * @param bag
     *            le sac d'ou on prend la lettre aleatoire
     * @throws Exception 
     * 
     */
    public void removeLetter(Letter l, Bag bag)  {
        this.letters.remove(l);
        this.fillrack(bag);

    }

    /**
     * Affiche le rack
     */
    @Override
    public String toString() {
        String s = this.letters.get(0).toString();
        for (int i = 1; i < 7; i++) {
            s = s + "    " + this.letters.get(i).toString();
        }
      
        return s + "\n";
    }

    // à finir
    public boolean endGame() {
            return true;
     }

}
