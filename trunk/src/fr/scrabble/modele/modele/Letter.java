/**
 * 
 */
package src.fr.scrabble.modele.modele;





/**
 * @author Alpha 
 *
 */
public class Letter {
    
    
    private int value;
    private char letter;
    public final static Letter LETTRE_DOUBLE = new Letter('1', 0);
    public final static Letter MOT_DOUBLE = new Letter('2', 0);
    public final static Letter DEBUT = new Letter('*', 0);
    public final static Letter LETTRE_TRIPLE = new Letter('3', 0);
    public final static Letter MOT_TRIPLE = new Letter('4', 0);
    public final static Letter ESPACE = new Letter('-', 0);
    public final static Letter JOKER = new Letter('$', 0);

    /**
     * 
     * @param letter
     *            le caractere qui est la lettre
     * @param value
     *            le nombre de points que vaut cette lettre
     */
    public Letter(char letter, int value) {
        this.value = value;
        this.letter = letter;

    }

    /**
     * 
     * @return la valeur de la lettre
     */
    public int getValue() {
        return this.value;
    }

    @Override
    /**
     * redefinition de la methode equals
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Letter other = (Letter) obj;
        if (this.letter != other.letter)
            return false;
        if (this.value != other.value)
            return false;
        return true;
    }

    /**
     * 
     * @return le caractere de la lettre
     */
    public char getLetter() {
        return this.letter;
    }

    /**
     * Affiche la lettre et sa valeur
     */
    public String toString(boolean score) {
        if (score)
            return "Value of " + String.valueOf(this.letter) + " is "
                    + String.valueOf(this.value) + " point(s).";
        return String.valueOf(this.letter);
    }

    /**
     * Affiche la lettre
     */
    @Override
    public String toString() {
        return String.valueOf(this.letter);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setValue(int i) {
       this.value=i;
        
    }
}
