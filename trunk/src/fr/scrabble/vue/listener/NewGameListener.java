package src.fr.scrabble.vue.listener;

import java.util.EventListener;

import src.fr.scrabble.modele.events.NewGameEvent;



public interface NewGameListener extends EventListener {
    
    public void NouvellePartieChanged(NewGameEvent event);

}
