package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Dijgo
 *
 */

public class EndFrame extends JFrame implements ActionListener{
    
    private JLabel mess;
    private JButton ok, no;
    private PlateauSwing plateau;

    @SuppressWarnings("static-access")
    public EndFrame(PlateauSwing plateau) {

        this.plateau = plateau;

        this.setTitle("End of the game");
        BorderLayout bord = new BorderLayout(0, 0);
        this.setLayout(bord);

        this.setSize(250, 180);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel pannini = new JPanel();
        mess = new JLabel(
                "<html> Bag is empty and the both players have skipped their turn.<br />Do you want to finish the game?</html>");
        mess.setPreferredSize(new Dimension(200, 100));
        pannini.add(mess);
        add(pannini);

        ok = new JButton("Yes");
        ok.addActionListener(this);
        ok.setPreferredSize(new Dimension(100, 25));

        no = new JButton("No");
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

        plateau.setEnabled(false);
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == no) {
            plateau.setEnabled(true);
            this.dispose();           
        } else if (e.getSource() == ok) {
            new GameOverFrame(plateau);
            plateau.dispose();
            this.dispose();
        }
    }

}
