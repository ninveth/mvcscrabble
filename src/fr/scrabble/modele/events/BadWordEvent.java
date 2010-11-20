package src.fr.scrabble.modele.events;

import java.util.EventObject;

@SuppressWarnings("serial")
public class BadWordEvent extends EventObject {
    
    public BadWordEvent(Object source) {
        super(source);
    }

}
