package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import src.fr.scrabble.controler.ControlerInterface;
import src.fr.scrabble.modele.events.EndGameEvent;
import src.fr.scrabble.vue.listener.EndGameListener;


/**
 * 
 * @author marovelo Alpha Cherif Dijgo
 *
 */


@SuppressWarnings("serial")
public class PlateauSwing extends JFrame implements PlateauSiwgInterface, EndGameListener{
    
    private ControlerInterface controler;

    public PlateauSwing(ControlerInterface controler) {
        
        this.controler = controler;
        this.getControler().getModel().addEndGameListener(this);
        this.setTitle("Scrabble");  
        this.setSize(800, 660);      
        this.setLocationRelativeTo(null);   
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.setVisible(true);
        this.setMinimumSize(new Dimension(600,550));
        
        new DebutFrame(this);

    }
    
    @SuppressWarnings("static-access")
    public void build(){
    
        BorderLayout bord = new BorderLayout(0, 0);
        this.setLayout(bord);
        
       
   
        Container content = this.getContentPane();
            
        JeuPanel pan = new JeuPanel(this);
       
     
        content.add(pan, bord.CENTER);
          
        InfosPanel infos = new InfosPanel(this);
        content.add(infos, bord.EAST);
    
        Menu bar = new Menu(this);
      
        this.setJMenuBar(bar);
        this.validate();
        
    }
    @Override
    public ControlerInterface getControler() {
        return this.controler;
    }

    @Override
    public void EndGame(EndGameEvent event) {
       new EndFrame(this);
       
        
    }

   
   

}
