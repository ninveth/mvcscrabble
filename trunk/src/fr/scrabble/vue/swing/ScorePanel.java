package src.fr.scrabble.vue.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;




import src.fr.scrabble.modele.events.PlayerChangedEvent;
import src.fr.scrabble.modele.events.ScoresChangedEvent;
import src.fr.scrabble.vue.listener.PlayerListener;
import src.fr.scrabble.vue.listener.ScoresListener;


/**
 * 
 * @author Cherif Alpha
 *
 */

public class ScorePanel extends JPanel implements ScoresListener,PlayerListener,ActionListener{


    private PlateauSwing plateau;
    private JTextArea but1, but2;
    private JButton skipBut;
    @SuppressWarnings("unused")
    private int endGameCount;

    public ScorePanel(PlateauSwing plateau) {

        this.plateau = plateau;
        plateau.getControler().getModel().addScoresListener(this);
        plateau.getControler().getModel().addPlayerListener(this);

        GridLayout grid = new GridLayout(6, 1);
        setLayout(grid);

        JPanel test1 = new JPanel();
        but1 = new JTextArea("                                            \n   "
                + plateau.getControler().getModel().getPlayer(1).getName()
                + " : \n    score : "
                + plateau.getControler().getModel().getPlayer(1).getScore()
                + " \n");
        but1.setBackground(Color.GREEN);
        but1.setBorder(javax.swing.BorderFactory
                .createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        but1.setEditable(false);

        test1.add(but1);
        test1.setBackground(Color.DARK_GRAY);
        add(test1);

        JPanel test2 = new JPanel();
        but2 = new JTextArea("                                            \n   "
                + plateau.getControler().getModel().getPlayer(2).getName()
                + " : \n    score : "
                + plateau.getControler().getModel().getPlayer(2).getScore()
                + " \n");
        but2.setBackground(Color.LIGHT_GRAY);
        but2.setBorder(javax.swing.BorderFactory
                .createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        but2.setEditable(false);

        test2.add(but2);
        test2.setBackground(Color.DARK_GRAY);
        add(test2);

        JPanel turn = new JPanel();

        skipBut = new JButton("skip turn");
        skipBut.setPreferredSize(new Dimension(150, 30));
        skipBut.addActionListener(this);

        turn.add(skipBut);
        add(turn);

    }

    @Override
    public void ScoreChanged(ScoresChangedEvent event) {
        but1.setText("                                            \n"
                + plateau.getControler().getModel().getPlayer(1).getName()
                + " : \n score : "
                + plateau.getControler().getModel().getPlayer(1).getScore()
                + " \n");
        but2.setText("                                            \n"
                + plateau.getControler().getModel().getPlayer(2).getName()
                + " : \n score : "
                + plateau.getControler().getModel().getPlayer(2).getScore()
                + " \n");
        this.validate();

    }

    @Override
    public void PlayerChanged(PlayerChangedEvent event) {
        if (plateau.getControler().getModel().getPlayer(1).getName().equals(
                plateau.getControler().getModel().getCurrentPlayer().getName())) {
            but1.setBackground(Color.GREEN);
            but2.setBackground(Color.LIGHT_GRAY);
        }else{
            but2.setBackground(Color.GREEN);
            but1.setBackground(Color.LIGHT_GRAY);
        }


        this.validate();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == skipBut) {
            plateau.getControler().skip();
            //if(plateau.getControler().getModel().getBag().isEmpty()){
            plateau.getControler().setEndGameCount();
            //}
        }

    }

    

}
