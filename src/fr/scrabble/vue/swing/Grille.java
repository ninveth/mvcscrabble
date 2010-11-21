package src.fr.scrabble.vue.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;





import src.fr.scrabble.modele.events.BoardChangedEvent;
import src.fr.scrabble.modele.modele.Board;
import src.fr.scrabble.modele.modele.Letter;
import src.fr.scrabble.vue.listener.BoardListener;

/**
 * 
 * @author marovelo
 *
 */

@SuppressWarnings("serial")
public class Grille extends JPanel implements BoardListener{


    private PlateauSwing plateau;
    JGridButton cases[][];
    public final static Color TRIPLE_WORD= Color.RED;
    public final static Color TRIPLE_LETTER= Color.BLUE;
    public final static Color DOUBLE_WORD= Color.PINK;
    public final static Color DOUBLE_LETTER= Color.CYAN;

    public Grille(PlateauSwing plateau) {

        plateau.getControler().getModel().addBoardListener(this);
        this.plateau = plateau;
        setLayout(new GridLayout(15, 15, 0, 0));

        cases = new JGridButton[15][15];
        Board board = new Board();
        Letter[][] cases1 = board.getBoard();     
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                cases[i][j] = new JGridButton(cases1[i][j].toString(), i, j,plateau);
                cases[i][j].setOpaque(true);
                cases[i][j]
                         .setBorder(javax.swing.BorderFactory
                                 .createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

                this.add(cases[i][j]);
            }
        }

        cases[0][0].setBackground(TRIPLE_WORD);
        cases[7][0].setBackground(TRIPLE_WORD);
        cases[14][0].setBackground(TRIPLE_WORD);
        cases[0][7].setBackground(TRIPLE_WORD);
        cases[14][7].setBackground(TRIPLE_WORD);
        cases[0][14].setBackground(TRIPLE_WORD);
        cases[7][14].setBackground(TRIPLE_WORD);
        cases[14][14].setBackground(TRIPLE_WORD);

        cases[1][5].setBackground(TRIPLE_LETTER);
        cases[1][9].setBackground(TRIPLE_LETTER);
        cases[5][1].setBackground(TRIPLE_LETTER);
        cases[5][5].setBackground(TRIPLE_LETTER);
        cases[5][9].setBackground(TRIPLE_LETTER);
        cases[5][13].setBackground(TRIPLE_LETTER);
        cases[9][1].setBackground(TRIPLE_LETTER);
        cases[9][5].setBackground(TRIPLE_LETTER);
        cases[9][9].setBackground(TRIPLE_LETTER);
        cases[9][13].setBackground(TRIPLE_LETTER);
        cases[13][5].setBackground(TRIPLE_LETTER);
        cases[13][9].setBackground(TRIPLE_LETTER);

        cases[1][1].setBackground(DOUBLE_WORD);
        cases[2][2].setBackground(DOUBLE_WORD);
        cases[3][3].setBackground(DOUBLE_WORD);
        cases[4][4].setBackground(DOUBLE_WORD);
        cases[7][7].setBackground(DOUBLE_WORD);
        cases[10][10].setBackground(DOUBLE_WORD);
        cases[11][11].setBackground(DOUBLE_WORD);
        cases[12][12].setBackground(DOUBLE_WORD);
        cases[13][13].setBackground(DOUBLE_WORD);
        cases[1][13].setBackground(DOUBLE_WORD);
        cases[2][12].setBackground(DOUBLE_WORD);
        cases[3][11].setBackground(DOUBLE_WORD);
        cases[4][10].setBackground(DOUBLE_WORD);
        cases[10][4].setBackground(DOUBLE_WORD);
        cases[11][3].setBackground(DOUBLE_WORD);
        cases[12][2].setBackground(DOUBLE_WORD);
        cases[13][1].setBackground(DOUBLE_WORD);

        cases[0][3].setBackground(DOUBLE_LETTER);
        cases[0][11].setBackground(DOUBLE_LETTER);
        cases[2][6].setBackground(DOUBLE_LETTER);
        cases[2][8].setBackground(DOUBLE_LETTER);
        cases[3][0].setBackground(DOUBLE_LETTER);
        cases[3][7].setBackground(DOUBLE_LETTER);
        cases[3][14].setBackground(DOUBLE_LETTER);
        cases[6][2].setBackground(DOUBLE_LETTER);
        cases[6][6].setBackground(DOUBLE_LETTER);
        cases[6][8].setBackground(DOUBLE_LETTER);
        cases[6][12].setBackground(DOUBLE_LETTER);
        cases[7][3].setBackground(DOUBLE_LETTER);
        cases[7][11].setBackground(DOUBLE_LETTER);
        cases[8][2].setBackground(DOUBLE_LETTER);
        cases[8][6].setBackground(DOUBLE_LETTER);
        cases[8][8].setBackground(DOUBLE_LETTER);
        cases[8][12].setBackground(DOUBLE_LETTER);
        cases[11][0].setBackground(DOUBLE_LETTER);
        cases[11][7].setBackground(DOUBLE_LETTER);
        cases[11][14].setBackground(DOUBLE_LETTER);
        cases[12][6].setBackground(DOUBLE_LETTER);
        cases[12][8].setBackground(DOUBLE_LETTER);
        cases[14][3].setBackground(DOUBLE_LETTER);
        cases[14][11].setBackground(DOUBLE_LETTER);

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (cases[i][j].getText().equals("-")) {
                    cases[i][j].setBackground(Color.green);
                    cases[i][j]
                             .setBorder(javax.swing.BorderFactory
                                     .createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

                }
            }
        }

    }

    public void repaint() {
        if (this.plateau != null) {
            Letter[][] letters = plateau.getControler().getModel()
            .getBoardState();
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    cases[i][j].setText(letters[i][j].toString());
                    if (!cases[i][j].getText().equals("-")
                            && !cases[i][j].getText().equals("1")
                            && !cases[i][j].getText().equals("2")
                            && !cases[i][j].getText().equals("3")
                            && !cases[i][j].getText().equals("4")
                            && !cases[i][j].getText().equals("*")) {
                        cases[i][j].setBackground(Color.yellow);
                        cases[i][j]
                                 .setBorder(javax.swing.BorderFactory
                                         .createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                    }

                }
            }
        }
    }

    @Override
    public void BoardChanged(BoardChangedEvent event) {
        this.repaint();
        this.validate();

    }

}
