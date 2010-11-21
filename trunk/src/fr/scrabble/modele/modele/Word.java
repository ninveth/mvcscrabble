/**
 * 
 */
package src.fr.scrabble.modele.modele;

import java.util.Hashtable;



/**
 * @author marovelo cherif amadou alpha
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
        int score = sc;
        Board board = new Board();
        Letter[][] marks = board.getBoard();

        char charWord[] = this.word.toCharArray();
        Language lang = new LanguageEn();
        Hashtable<Letter, Integer> dic = lang.getDic();

        Letter[] tmp = new Letter[1];
        Letter letters[] = dic.keySet().toArray(tmp);

        double doubleW = debut;
        double tripleW = 0;

        for (int i = 0; i < charWord.length; i++) {
            if (Character.isLowerCase(charWord[i]))
                charWord[i] = Character.toUpperCase(charWord[i]);
            for (int j = 0; j < letters.length; j++) {

                if (letters[j].getLetter() == charWord[i]) {

                    if (this.direction == 'r') {
                        if (marks[this.x][this.y + i] == Letter.LETTRE_DOUBLE) {
                            score += 2 * letters[j].getValue();
                            marks[this.x][this.y + i] = Letter.ESPACE;
                        } else if (marks[this.x][this.y + i] == Letter.LETTRE_TRIPLE) {
                            score += 3 * letters[j].getValue();
                            marks[this.x][this.y + i] = Letter.ESPACE;
                        } else if (marks[this.x][this.y + i] == Letter.MOT_DOUBLE) {
                            doubleW++;
                            score += letters[j].getValue();
                            marks[this.x][this.y + i] = Letter.ESPACE;
                        } else if (marks[this.x][this.y + i] == Letter.MOT_TRIPLE) {
                            score += letters[j].getValue();
                            marks[this.x][this.y + i] = Letter.ESPACE;
                            tripleW++;
                        } else
                            score += letters[j].getValue();
                    } else if (this.direction == 'c') {
                        if (marks[this.x + i][this.y] == Letter.LETTRE_DOUBLE) {
                            score += 2 * letters[j].getValue();
                            marks[this.x + i][this.y] = Letter.ESPACE;
                        } else if (marks[this.x + i][this.y] == Letter.LETTRE_TRIPLE) {
                            score += 3 * letters[j].getValue();
                            marks[this.x + i][this.y] = Letter.ESPACE;
                        } else if (marks[this.x + i][this.y] == Letter.MOT_DOUBLE) {
                            doubleW++;
                            score += letters[j].getValue();
                            marks[this.x + i][this.y] = Letter.ESPACE;
                        } else if (marks[this.x + i][this.y] == Letter.MOT_TRIPLE) {
                            score += letters[j].getValue();
                            marks[this.x + i][this.y] = Letter.ESPACE;
                            tripleW++;
                        } else
                            score += letters[j].getValue();
                    }
                }
            }

        }

        return (int) (score * Math.pow(2.0, doubleW) * Math.pow(3.0, tripleW));
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
