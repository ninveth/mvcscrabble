package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



import src.fr.scrabble.modele.events.BadWordEvent;
import src.fr.scrabble.vue.listener.BadWordListener;

@SuppressWarnings("serial")
public class AjoutMot extends JFrame implements ActionListener,BadWordListener {
    
    
    
    private JTextField mot;
    private JButton submit, abort;
    private JRadioButton br1, br2;
    private int x, y;
    private char direction;
    private String word;
    private PlateauSwing plateau;

    public AjoutMot(int x, int y, PlateauSwing plateau) {

        this.x = x;
        this.y = y;
        this.plateau = plateau;

        this.plateau.getControler().getModel().addBadWordListener(this);

        this.setTitle("Add word");
        this.setSize(200, 150);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.mot = new JTextField();

        this.add(this.mot, BorderLayout.CENTER);

        ButtonGroup bg = new ButtonGroup();
        this.br1 = new JRadioButton("Rows");
        this.br2 = new JRadioButton("Columns");

        bg.add(this.br1);
        bg.add(this.br2);

        JPanel p = new JPanel();
        p.add(this.br1);
        p.add(this.br2);

        this.add(p, BorderLayout.NORTH);

        JPanel pan = new JPanel();
        submit = new JButton("Submit");
        submit.addActionListener(this);
        pan.add(submit);
        abort = new JButton("Abort");
        abort.addActionListener(this);
        pan.add(abort);
        this.add(pan, BorderLayout.SOUTH);

        plateau.setEnabled(false);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (this.br1.isSelected())
                this.direction = 'r';
            else
                this.direction = 'c';
            this.word = this.mot.getText();
            try {
                plateau.getControler()
                        .poserMot(word, this.x, this.y, direction);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "An Error occured during the operation.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            plateau.setEnabled(true);
            this.dispose();
        } else if (e.getSource() == abort) {
            plateau.setEnabled(true);
            this.dispose();
        }

    }

    @Override
    public void BadWordPosed(BadWordEvent event) {
        JOptionPane.showMessageDialog(this, "You can't put this word here.",
                "You failed", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();
    }

}
