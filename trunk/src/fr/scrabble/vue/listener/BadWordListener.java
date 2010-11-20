package src.fr.scrabble.vue.listener;

import java.util.EventListener;

import src.fr.scrabble.modele.events.BadWordEvent;


public interface BadWordListener extends EventListener {
	public void BadWordPosed(BadWordEvent event);

}
