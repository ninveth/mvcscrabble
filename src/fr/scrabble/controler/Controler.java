package src.fr.scrabble.controler;

import src.fr.scrabble.modele.modele.AbstractModel;
import src.fr.scrabble.modele.modele.Word;



public class Controler implements ControlerInterface {
    
 private AbstractModel model; 
    
    public Controler(AbstractModel model){
        this.model = model;
    }

    @Override
    public AbstractModel getModel() {
        return this.model;
    }

    @Override
    public boolean lookup(String mot) {
         return this.model.lookup(mot);
        
    }

    @Override
    public void newGame(String p1name, String p2name) {
     this.model.newGame(p1name,p2name);
        
    }

    @Override
    public void poserMot(String word, int i, int j, char direction) {
       
            Word newWord = new Word(word, i, j, direction);
            this.model.addWord(newWord);
        
    }
    public void skip(){
        this.model.skip();
    }

    @Override
    public void setEndGameCount() {
        this.model.setEndGameCount();
        
    }

}
