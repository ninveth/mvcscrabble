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
public interface BoardListener extends EventListener{
    
    public void BoardChanged(Event event);

}
