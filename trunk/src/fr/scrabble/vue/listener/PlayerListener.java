/**
 * 
 */
package src.fr.scrabble.vue.listener;

import java.awt.Event;
import java.util.EventListener;

import src.fr.scrabble.modele.events.PlayerChangedEvent;

/**
 * @author marovelo
 *
 */
public interface PlayerListener extends EventListener {
    public void PlayerChanged(PlayerChangedEvent event);

}
