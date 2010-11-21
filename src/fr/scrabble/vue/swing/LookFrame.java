package src.fr.scrabble.vue.swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * 
 * @author marovelo  Cherif
 *
 */

public class LookFrame extends JDialog implements ActionListener{
    
    
    private JTextField type;
    private JLabel word;
    private PlateauSwing plateau;

    public LookFrame(PlateauSwing plateau,boolean model) {
        
        super(plateau,model);
        this.plateau=plateau;
        this.setTitle("Look up");
        
        this.setSize(180, 150);
        this.setLocationRelativeTo(null);
        GridLayout grid = new GridLayout(2, 1);
        this.setLayout(grid);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.word = new JLabel("          Please type a word");
        this.add(this.word);
        
        JPanel pan = new JPanel(new GridLayout(2, 1));
        
        this.type = new JTextField();
        pan.add(this.type);
   
        JPanel pan1 = new JPanel();
        JButton but = new JButton ("Look up!");
        but.setPreferredSize(new Dimension(100, 23));
        but.addActionListener(this);
       
        plateau.setEnabled(false);
        
        pan1.add(but);
        pan.add(pan1);
        this.add(pan);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (this.plateau.getControler().lookup(this.type.getText()))
           JOptionPane
           .showMessageDialog(this, "The word is in the dictionnary!","Success",JOptionPane.INFORMATION_MESSAGE);
       else
           JOptionPane
           .showMessageDialog(this, "The word is not in the dictionnary.","Fail", JOptionPane.ERROR_MESSAGE);
       this.plateau.setEnabled(true);
       this.dispose();
        
    }

}
