package fr.scrabble.vue.listener;

import java.awt.Event;
import java.util.EventListener;


public interface BadWordListener extends EventListener {
	public void BadWordPosed(Event event);

}
