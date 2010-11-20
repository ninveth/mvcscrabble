package src.fr.scrabble.modele.events;

import java.util.EventObject;

import src.fr.scrabble.modele.modele.Letter;



public class BoardChangedEvent extends EventObject {


    private Letter[][] boardState;

    public BoardChangedEvent(Object source, Letter[][] boardState) {
        super(source);
        this.boardState = boardState;
    }

    public Letter[][] getBoardState() {
        return this.boardState;
    }

}
