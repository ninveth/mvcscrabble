/**
 * 
 */
package src.fr.scrabble.modele.modele;





/**
 * @author marovelo
 *
 */
public class Board {
    
    private Letter[][] board = new Letter[15][15];  
    Letter un = Letter.LETTRE_DOUBLE;
    Letter deux = Letter.MOT_DOUBLE;
    Letter trois = Letter.LETTRE_TRIPLE;
    Letter quatre = Letter.MOT_TRIPLE;
    Letter esp = Letter.ESPACE;
    Letter debut = Letter.DEBUT;
    Letter joker = Letter.JOKER;

    /**
     * On construit la board en affectant les caracteres speciaux un deux etc..
     * en fonctions des cases sp�ciales
     */
    public Board() {
        this.board[0][0] = this.quatre;
        this.board[7][0] = this.quatre;
        this.board[14][0] = this.quatre;
        this.board[0][7] = this.quatre;
        this.board[14][7] = this.quatre;
        this.board[0][14] = this.quatre;
        this.board[7][14] = this.quatre;
        this.board[14][14] = this.quatre;

        this.board[1][5] = this.trois;
        this.board[1][9] = this.trois;
        this.board[5][1] = this.trois;
        this.board[5][5] = this.trois;
        this.board[5][9] = this.trois;
        this.board[5][13] = this.trois;
        this.board[9][1] = this.trois;
        this.board[9][5] = this.trois;
        this.board[9][9] = this.trois;
        this.board[9][13] = this.trois;
        this.board[13][5] = this.trois;
        this.board[13][9] = this.trois;

        this.board[1][1] = this.deux;
        this.board[2][2] = this.deux;
        this.board[3][3] = this.deux;
        this.board[4][4] = this.deux;
        this.board[7][7] = this.debut;
        this.board[10][10] = this.deux;
        this.board[11][11] = this.deux;
        this.board[12][12] = this.deux;
        this.board[13][13] = this.deux;
        this.board[1][13] = this.deux;
        this.board[2][12] = this.deux;
        this.board[3][11] = this.deux;
        this.board[4][10] = this.deux;
        this.board[10][4] = this.deux;
        this.board[11][3] = this.deux;
        this.board[12][2] = this.deux;
        this.board[13][1] = this.deux;

        this.board[0][3] = this.un;
        this.board[0][11] = this.un;
        this.board[2][6] = this.un;
        this.board[2][8] = this.un;
        this.board[3][0] = this.un;
        this.board[3][7] = this.un;
        this.board[3][14] = this.un;
        this.board[6][2] = this.un;
        this.board[6][6] = this.un;
        this.board[6][8] = this.un;
        this.board[6][12] = this.un;
        this.board[7][3] = this.un;
        this.board[7][11] = this.un;
        this.board[8][2] = this.un;
        this.board[8][6] = this.un;
        this.board[8][8] = this.un;
        this.board[8][12] = this.un;
        this.board[11][0] = this.un;
        this.board[11][7] = this.un;
        this.board[11][14] = this.un;
        this.board[12][6] = this.un;
        this.board[12][8] = this.un;
        this.board[14][3] = this.un;
        this.board[14][11] = this.un;

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (this.board[i][j] == null)
                    this.board[i][j] = this.esp;
            }
        }

    }
    
    public Letter[][] getBoard() {
        return this.board;
    }

    

}
