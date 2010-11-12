package src.fr.scrabble.vue.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class HelpFrame extends JDialog implements ActionListener {

    private JLabel help;
    private JButton ok;
    private CommandesMenu menu;
    
    @SuppressWarnings("static-access")
    public HelpFrame(CommandesMenu menu,JFrame f,boolean modal){
        super(f,modal);
        
        this.menu=menu;
        BorderLayout bord = new BorderLayout(0, 0);
        this.setLayout(bord);
        
        this.setTitle("Help");
        this.setSize(370, 450);
        this.setLocationRelativeTo(null);
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        JPanel pan1 = new JPanel();
        this.help = new JLabel("<html>-   syntax: [action] <type> <row> <column> <word> <br />"
                + "-   action: move, skip, help, defn, tb, lookup, dist, scoring, quit <br />"
                + "-   skip = skip turn <br />" + "-   help = show this help screen <br />"
                + "-   defn = show list of available definitions <br />"
                + "-   tb = toggle boardmap <br />"
                + "-   lookup = lookup word in dictionary <br />"
                + "-   dist = show letter frequency distribution <br />"
                + "-   scoring = show letter scoring scheme <br />"
                + "-   exchange= exchange tiles and sacrifice turn <br />"
                + "-   example: exchange abc <br /><br /><br />" + "-   boardmap scheme :<br />"
                + "---->   1 double letter<br />" + "---->   2 double word<br />" + "---->    3 triple letter<br />"
                + "---->   4 triple word<br /><br />" + "-  type = r or c (row or col)<br /><br /><br />"
                + "</html>");
        this.help.setPreferredSize(new Dimension(340, 400));
        pan1.add(this.help);
        add(pan1, bord.CENTER);
        
        JPanel pan = new JPanel();
        this.ok = new JButton("Ok");
        this.ok.addActionListener(this);
        this.ok.setPreferredSize(new Dimension(100, 25));
        pan.add(this.ok);
        
        add(pan, bord.SOUTH);
        
        this.setVisible(true);
        this.setMinimumSize(new Dimension(200,200));
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.menu.getHelp().setEnabled(true);
        this.dispose();
    }

}
