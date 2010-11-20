package src.fr.scrabble.modele.events;

import java.util.EventObject;

@SuppressWarnings("serial")
public class EndGameEvent extends EventObject {
    
    
    public EndGameEvent(Object source) {
        super(source);
    }

}
