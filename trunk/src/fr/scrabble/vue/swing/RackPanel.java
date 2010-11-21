package src.fr.scrabble.vue.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import src.fr.scrabble.modele.events.PlayerChangedEvent;
import src.fr.scrabble.modele.modele.Rack;
import src.fr.scrabble.vue.listener.PlayerListener;


/**
 * 
 * @author Dijgo
 *
 */

public class RackPanel extends JPanel implements PlayerListener{
    
    private Rack rack;
    private JButton rackButton;
    private PlateauSwing plateau;

    public RackPanel(PlateauSwing plateau) {

        this.plateau = plateau;
        plateau.getControler().getModel().addPlayerListener(this);

    }

    public void repaint() {
        if (this.plateau != null) {
            this.removeAll();
            rack = plateau.getControler().getModel().getCurrentPlayer().getRack();
            
            rackButton = new JButton(rack.toString());
            rackButton.setBackground(Color.LIGHT_GRAY);
            rackButton.setPreferredSize(new Dimension(200, 30));
            this.add(rackButton);
        }
    }

    @Override
    public void PlayerChanged(PlayerChangedEvent event) {
        repaint();
        validate();
    }

}
