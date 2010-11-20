package src.fr.scrabble.controler;

import src.fr.scrabble.modele.modele.AbstractModel;

public interface ControlerInterface {
    
    public AbstractModel getModel();

    public void newGame(String p1name, String p2name);
    
    public void poserMot(String word, int i, int j, char direction);
          
    public boolean lookup(String mot);
    
    public void skip();
    
    public void setEndGameCount();
	
}
