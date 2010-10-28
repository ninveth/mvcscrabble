/**
 * 
 */
package src.fr.scrabble.modele.modele;

/**
 * @author marovelo
 *
 */
public class Word {
    
    private int x, y;
    private char direction;
    private String word;
    
    
    /**
     * Cree un objet de type Word
     * 
     * @param word
     *            c'est la chaine de caract�res du mot
     * @param x
     *            c'est l'abscisse de la premi�re lettre du mot
     * @param y
     *            c'est l'ordonn�e de la premi�re lettre du mot
     * @param direction
     *            r ou c, row ou col pour savoir si le mot est dispos�
     *            horizontalement(r) ou verticalement(c)
     */
    public Word(String word, int x, int y, char direction) {
        this.word = word;
        this.x = x;
        this.y = y;
        this.direction = direction;

    }

    /**
     * 
     * @return l'abscisse de la premiere lettre du mot
     */
    public int getX() {
        return this.x;
    }

    /**
     * 
     * @return l'ordonn�e de la premiere lettre du mot
     */
    public int getY() {
        return this.y;
    }

    /**
     * 
     * @return la directoin du mot
     */
    public char getDirection() {
        return this.direction;
    }

    /**
     * 
     * @return le mot
     */
    public String getWord() {
        return this.word;
    }

    /**
     * la methode d'ajout des points
     * 
     * @param score
     * @return
     */
    public int addPoints(int sc, int debut) {
        
        return 0;
       
    }

    public void setX(int i) {
        this.x = i;

    }

    public void setY(int i) {
        this.y = i;

    }

    @Override
    public String toString() {
        return "Word : " + this.word + "\nx = " + this.x + "\ny = " + this.y
                + "\ndirection : " + this.direction;
    }

}
