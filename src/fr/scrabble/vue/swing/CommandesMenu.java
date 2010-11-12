package src.fr.scrabble.vue.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class CommandesMenu extends JMenu implements ActionListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JMenuItem help, lookup, dist, scoring;
    private PlateauSwing plateau;
    
    public CommandesMenu(PlateauSwing plateau){
      //  move, skip, help, defn, tb, lookup, dist, scoring
    super("Commands");
    this.plateau=plateau;
    this.help = new JMenuItem("Help");
    this.help.addActionListener(this);
    this.add(this.help);

    this.addSeparator();
    
    this.lookup = new JMenuItem("Look up");
    this.lookup.addActionListener(this);
    this.add(this.lookup);
    
    this.dist = new JMenuItem("Distribution");
    this.dist.addActionListener(this);
    this.add(this.dist);
    
    this.scoring = new JMenuItem("Scoring");
    this.scoring.addActionListener(this);
    this.add(this.scoring);
    }

    public JMenuItem getHelp(){
        return this.help;
    }
    public JMenuItem getDist(){
        return this.dist;
    }
    public JMenuItem getScoring(){
        return this.scoring;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.help){
            this.help.setEnabled(false);
            new HelpFrame(this,this.plateau,true);
        }
        if(e.getSource()==this.lookup){
            new LookFrame(this.plateau,true);
        }
        if(e.getSource()==this.dist){
            this.dist.setEnabled(false);
            new DistFrame(this.plateau, "dist",this ,true);
        }
        if(e.getSource()== this.scoring){
            this.scoring.setEnabled(false);
            new DistFrame( this.plateau, "scoring",this,true);
        }
    }

}
