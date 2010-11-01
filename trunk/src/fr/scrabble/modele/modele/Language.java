/**
 * 
 */
package src.fr.scrabble.modele.modele;

import java.util.Hashtable;



/**
 * @author marovelo
 *
 */
public class Language {
    
    Hashtable<Letter, Integer> dic = new Hashtable<Letter, Integer>();

    public Language() {

    }

    public Hashtable<Letter, Integer> getDic() {
        return this.dic;
    }
    public String toString(){
        return "";
    }

}
