package src.fr.scrabble.modele.events;

import java.util.EventObject;

/**
 * @author marovelo 
 *
 */


@SuppressWarnings("serial")
public class ScoresChangedEvent extends EventObject {
    
    public ScoresChangedEvent(Object source) {
        super(source);
   
    }

}
