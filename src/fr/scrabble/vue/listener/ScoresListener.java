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
public interface ScoresListener extends EventListener {
    
    public void ScoreChanged(Event event);

}
