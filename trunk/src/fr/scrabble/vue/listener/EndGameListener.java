/**
 * 
 */
package src.fr.scrabble.vue.listener;

import java.awt.Event;
import java.util.EventListener;

/**
 * @author marovelo
 *
 */
public interface EndGameListener extends EventListener{
    
    public void EndGame(Event event);

}
