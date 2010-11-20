/**
 * 
 */
package src.main;

import src.fr.scrabble.controler.Controler;
import src.fr.scrabble.modele.modele.Scrabble;
import src.fr.scrabble.vue.swing.PlateauSwing;

/**
 * @author marovelo
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new PlateauSwing(new Controler(new Scrabble()));

    }

}
