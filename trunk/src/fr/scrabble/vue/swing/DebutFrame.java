package src.fr.scrabble.vue.swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author marovelo
 *
 */

public class DebutFrame extends JFrame implements ActionListener{
    
    private JTextField play1, play2;
    private JLabel name1, name2;
    private PlateauSwing plateau;

    JButton but3;

    public DebutFrame(PlateauSwing plateau) {

        this.plateau=plateau;
        this.setTitle("New Game");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        GridLayout grid = new GridLayout(5, 1);
        this.setLayout(grid);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.name1 = new JLabel("  Player 1's name :");
        this.add(this.name1);
        this.play1 = new JTextField();
        this.add(this.play1);

        this.name2 = new JLabel("  Player 2's name :");
        this.add(this.name2);
        this.play2 = new JTextField();
        this.add(this.play2);

        JPanel pan = new JPanel();
        this.but3 = new JButton ("OK");
        this.but3.addActionListener(this);
        this.but3.setPreferredSize(new Dimension(100, 25));
        pan.add(this.but3);
        this.add(pan);

        plateau.setEnabled(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(200,200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == but3 ){
            plateau.getControler().newGame(this.play1.getText(),this.play2.getText());
            plateau.build();
            plateau.setEnabled(true);
            this.dispose();
        }

    }

}
