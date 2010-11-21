package src.fr.scrabble.modele.events;

import java.util.EventObject;


/**
 * @author alpha
 *
 */

@SuppressWarnings("serial")
public class NewGameEvent extends EventObject {
    
    
    public NewGameEvent(Object source) {
        super(source);
    }

}
