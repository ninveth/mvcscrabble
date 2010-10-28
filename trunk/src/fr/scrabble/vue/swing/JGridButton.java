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
    
    @SuppressWarnings("unused")
    private String str;
    @SuppressWarnings("unused")
    private int x,y;
    
    public JGridButton(String s, int x ,int y){
        
        super(s);
        this.x=x;
        this.y=y;
        
        this.str=s;
     
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }

}
