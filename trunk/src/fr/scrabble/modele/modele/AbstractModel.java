/**
 * 
 */
package src.fr.scrabble.modele.modele;

import javax.swing.event.EventListenerList;



/**
 * @author marovelo hammady Ibrahima Djigo
 *
 */
public abstract class AbstractModel {
    
    private EventListenerList listeners = new EventListenerList();
    public abstract Letter[][] getBoardState();
    public abstract Player getCurrentPlayer();
    public abstract String getScoringScheme();
    public abstract String getDist();
    public abstract void newGame(String p1name, String p2name);
    public abstract void skip();
    public abstract boolean lookup(String mot);
    public abstract Rack getRack();
    public abstract Bag getBag();
    public abstract void addWord(Word word);
    public abstract Player getPlayer(int i);
    public abstract int getEndGameCount();
    public abstract void setEndGameCount();

}
