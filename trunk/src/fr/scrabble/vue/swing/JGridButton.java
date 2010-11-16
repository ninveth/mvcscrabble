/**
 * 
 */
package src.fr.scrabble.vue.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;



/**
 * @author marovelo
 *
 */
@SuppressWarnings("serial")
public class JGridButton extends JButton implements ActionListener{
    
    private String str;
    private int x,y;
    private PlateauSwing plateau;
    
    public JGridButton(String s,int x,int y, PlateauSwing plateau){
        
        super(s);
        this.plateau = plateau;
        this.x=x;
        this.y=y;
        
        this.str=s;
     
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AjoutMot(this.x,this.y,plateau);
       
        
    }
}
