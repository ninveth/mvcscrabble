package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class DistFrame extends JDialog implements ActionListener {
    
    
    private JLabel dist;
    private JButton ok;
    @SuppressWarnings("unused")
    private PlateauSwing plateau;
    private String action;
    private CommandesMenu menu;

    @SuppressWarnings("static-access")
    public DistFrame(PlateauSwing plateau, String action, CommandesMenu menu,boolean model) {
        
        super(plateau,model);

        this.plateau = plateau;
        this.action = action;
        this.menu = menu;

        BorderLayout bord = new BorderLayout(0, 0);
        this.setLayout(bord);

        this.setSize(200, 520);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if (action.equals("dist")) {
            dist = new JLabel(plateau.getControler().getModel().getDist());
            this.setTitle("Distribution");
        } else if (action.equals("scoring")) {
            dist = new JLabel(plateau.getControler().getModel()
                    .getScoringScheme());
            this.setTitle("Scoring");
        }
        
        dist.setPreferredSize(new Dimension(180, 450));
        JPanel pan1 = new JPanel();
        pan1.add(dist);
        add(pan1, bord.CENTER);

        ok = new JButton("Ok");
        ok.addActionListener(this);
        ok.setPreferredSize(new Dimension(100, 25));
        JPanel pan = new JPanel();
        pan.add(ok);

        add(pan, bord.SOUTH);

        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (action.equals("dist")) {
            menu.getDist().setEnabled(true);
        } else if (action.equals("scoring")) {
            menu.getScoring().setEnabled(true);
        }
        this.dispose();
    }

}
