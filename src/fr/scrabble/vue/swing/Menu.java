package src.fr.scrabble.vue.swing;

import javax.swing.JMenuBar;

/**
 * 
 * @author Dijgo
 *
 */
public class Menu extends JMenuBar {
    
    PlateauSwing p;
    public Menu(PlateauSwing p) {

        this.p=p;
        
        OptionsMenu menuO = new OptionsMenu(p);
        this.add(menuO);
        
        CommandesMenu menuC = new CommandesMenu(p);
        this.add(menuC);
      

    }

}
