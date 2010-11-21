package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author marovelo
 *
 */

public class InfosPanel extends JPanel implements ActionListener{
    
    
    PlateauSwing plateau;
    public InfosPanel(PlateauSwing plateau){
       
        this.plateau = plateau;
        this.setPreferredSize(new Dimension(200, 600));

        setLayout(new BorderLayout());

      
        ScorePanel score = new ScorePanel(plateau);
        add (score, BorderLayout.CENTER);
        
        
        JPanel test3 = new JPanel ();
                  
        JButton but3 = new JButton ("Quit");
        but3.addActionListener(this);
        but3.setPreferredSize(new Dimension(150, 30));
        test3.add (but3);   
        
        add (test3, BorderLayout.SOUTH);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
        
    }

}
