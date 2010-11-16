/**
 * 
 */
package src.fr.scrabble.modele.modele;

import javax.swing.event.EventListenerList;

import src.fr.scrabble.modele.events.BadWordEvent;
import src.fr.scrabble.modele.events.BoardChangedEvent;
import src.fr.scrabble.modele.events.EndGameEvent;
import src.fr.scrabble.modele.events.NewGameEvent;
import src.fr.scrabble.modele.events.PlayerChangedEvent;
import src.fr.scrabble.modele.events.ScoresChangedEvent;
import src.fr.scrabble.vue.listener.BadWordListener;
import src.fr.scrabble.vue.listener.BoardListener;
import src.fr.scrabble.vue.listener.EndGameListener;
import src.fr.scrabble.vue.listener.NewGameListener;
import src.fr.scrabble.vue.listener.PlayerListener;
import src.fr.scrabble.vue.listener.ScoresListener;




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
    
    public void addBoardListener(BoardListener listener) {
        this.listeners.add(BoardListener.class, listener);
    }

    public void removeBoardListener(BoardListener listener) {
        this.listeners.remove(BoardListener.class, listener);
    }

    public void fireBoardChanged() {
        BoardListener[] listenerList = this.listeners
                .getListeners(BoardListener.class);
        for (BoardListener listener : listenerList) {
            listener.BoardChanged(new BoardChangedEvent(this, getBoardState()));
        }
    }

    public void addPlayerListener(PlayerListener listener) {
        this.listeners.add(PlayerListener.class, listener);
    }

    public void removePlayerListener(PlayerListener listener) {
        this.listeners.remove(PlayerListener.class, listener);
    }

    public void firePlayerChanged() {
        PlayerListener[] listenerList = this.listeners
                .getListeners(PlayerListener.class);
        for (PlayerListener listener : listenerList) {
            listener.PlayerChanged(new PlayerChangedEvent(this,
                    getCurrentPlayer()));
        }
    }

    public void addScoresListener(ScoresListener listener) {
        this.listeners.add(ScoresListener.class, listener);
    }

    public void removeScoresListener(ScoresListener listener) {
        this.listeners.remove(ScoresListener.class, listener);
    }

    public void fireScoresChanged() {
        ScoresListener[] listenerList = this.listeners
                .getListeners(ScoresListener.class);
        for (ScoresListener listener : listenerList) {
            listener.ScoreChanged(new ScoresChangedEvent(this));
        }
    }

    public void addNouvellePartieListener(NewGameListener listener) {
        this.listeners.add(NewGameListener.class, listener);
    }

    public void removeNouvellePartieListener(NewGameListener listener) {
        this.listeners.remove(NewGameListener.class, listener);
    }

    public void fireNouvellePartie() {
        NewGameListener[] listenerList = this.listeners
                .getListeners(NewGameListener.class);
        for (NewGameListener listener : listenerList) {
            listener.NouvellePartieChanged(new NewGameEvent(this));
        }
    }
    
    public void addBadWordListener(BadWordListener listener) {
        this.listeners.add(BadWordListener.class, listener);
    }

    public void removeBadWordListener(BadWordListener listener) {
        this.listeners.remove(BadWordListener.class, listener);
    }

    public void fireBadWord() {
        BadWordListener[] listenerList = this.listeners
                .getListeners(BadWordListener.class);
        for (BadWordListener listener : listenerList) {
            listener.BadWordPosed(new BadWordEvent(this));
        }
    }
    public void addEndGameListener(EndGameListener listener) {
        this.listeners.add(EndGameListener.class, listener);
    }

    public void removeEndGameListener(EndGameListener listener) {
        this.listeners.remove(EndGameListener.class, listener);
    }

    public void fireEndGameEvent() {
        EndGameListener[] listenerList = this.listeners
                .getListeners(EndGameListener.class);
        for (EndGameListener listener : listenerList) {
            listener.EndGame(new EndGameEvent(this));
        }
    }


}
