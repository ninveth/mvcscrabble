package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



public class JeuPanel extends JPanel  {
    PlateauSwing plateau;
    
    public JeuPanel(PlateauSwing plateau){
        this.plateau = plateau;
        this.setBackground(Color.GREEN);       
        BorderLayout border = new BorderLayout();
        setLayout(border);
        
        RackPanel rack1 = new RackPanel (plateau);
        add (rack1, BorderLayout.NORTH);
        
        Grille grille = new Grille(plateau);
        add (grille, BorderLayout.CENTER);
    }

    
    

}