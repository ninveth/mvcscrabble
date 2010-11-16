package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.fr.scrabble.controler.Controler;
import src.fr.scrabble.modele.modele.Scrabble;



public class GameOverFrame extends JFrame implements ActionListener {
    
    
    private JLabel mess;
    private JButton ok, no;
    private PlateauSwing plateau;

    @SuppressWarnings("static-access")
    public GameOverFrame(PlateauSwing plateau) {

        this.plateau = plateau;

        this.setTitle("End of the game");
        BorderLayout bord = new BorderLayout(0, 0);
        this.setLayout(bord);

        this.setSize(250, 180);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel pannini = new JPanel();
        
        if(plateau.getControler().getModel().getPlayer(1).getScore()<=plateau.getControler().getModel().getPlayer(2).getScore())
        mess = new JLabel("                 "+plateau.getControler().getModel().getPlayer(1).getName()+" wins!");
        else
        mess = new JLabel("                 "+plateau.getControler().getModel().getPlayer(2).getName()+" wins!");
        
        mess.setPreferredSize(new Dimension(200, 100));
        pannini.add(mess);
        add(pannini);

        ok = new JButton("New Game");
        ok.addActionListener(this);
        ok.setPreferredSize(new Dimension(100, 25));

        no = new JButton("Quit");
        no.addActionListener(this);
        no.setPreferredSize(new Dimension(100, 25));

        JPanel pan = new JPanel();
        JPanel ok1 = new JPanel();
        JPanel no1 = new JPanel();

        ok1.add(ok);
        no1.add(no);
        pan.add(ok1);
        pan.add(no1);

        add(pan, bord.SOUTH);

        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
        new PlateauSwing(new Controler(new Scrabble()));
        this.plateau.dispose();
        this.dispose();
        }else{
            System.exit(0);
        }
        
    }


}
