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
public interface PlayerListener extends EventListener {
    public void PlayerChanged(Event event);

}
