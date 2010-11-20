/**
 * 
 */
package src.fr.scrabble.vue.listener;

import java.awt.Event;
import java.util.EventListener;

import src.fr.scrabble.modele.events.ScoresChangedEvent;

/**
 * @author marovelo
 *
 */
public interface ScoresListener extends EventListener {
    
    public void ScoreChanged(ScoresChangedEvent event);

}
