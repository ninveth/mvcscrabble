/**
 * 
 */
package src.fr.scrabble.vue.listener;

import java.awt.Event;
import java.util.EventListener;

import src.fr.scrabble.modele.events.EndGameEvent;

/**
 * @author marovelo
 *
 */
public interface EndGameListener extends EventListener{
    
    public void EndGame(EndGameEvent event);

}
