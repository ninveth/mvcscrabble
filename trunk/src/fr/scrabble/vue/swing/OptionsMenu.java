package src.fr.scrabble.vue.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import src.fr.scrabble.controler.Controler;
import src.fr.scrabble.modele.modele.Scrabble;

/**
 * 
 * @author marovelo Alpha
 *
 */

public class OptionsMenu extends JMenu implements ActionListener {
    
    
    private PlateauSwing p;
    private JMenuItem quit, newGame; 

    public OptionsMenu(PlateauSwing p) {

        super("Game");
        this.p = p;
        this.newGame = new JMenuItem("New game");
        this.newGame.addActionListener(this);
        this.add(this.newGame);

        this.addSeparator();

        this.quit = new JMenuItem("Quit");
        this.quit.addActionListener(this);
        this.add(this.quit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.quit)
            System.exit(0);
        if(e.getSource() == this.newGame){
            new PlateauSwing(new Controler(new Scrabble()));
            this.p.dispose();
        }
    

    }

}
