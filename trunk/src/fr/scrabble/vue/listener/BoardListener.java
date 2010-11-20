/**
 * 
 */
package src.fr.scrabble.vue.listener;

import java.awt.Event;
import java.util.EventListener;

import src.fr.scrabble.modele.events.BoardChangedEvent;

/**
 * @author marovelo
 *
 */
public interface BoardListener extends EventListener{
    
    public void BoardChanged(BoardChangedEvent event);

}
