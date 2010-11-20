package src.fr.scrabble.modele.events;

import java.util.EventObject;

import src.fr.scrabble.modele.modele.Player;



@SuppressWarnings("serial")
public class PlayerChangedEvent extends EventObject {


    Player currentPlayer;

    public PlayerChangedEvent(Object source, Player currentPlayer) {
        super(source);
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

}
