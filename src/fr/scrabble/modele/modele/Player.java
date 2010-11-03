package src.fr.scrabble.modele.modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  Ibrahima 
 *
 */

public class Player {
    
    
    private String name;
    private int score;
    private Rack rack;
    private boolean turn = false;

    /**
     * Cette classe represente le joueur
     * 
     * @param name
     *            avec son nom
     * @param score
     *            son score
     * @param rack
     *            et son banc de lettres
     */
    public Player(String name, int score, Rack rack) {
        this.name = name;
        this.score = score;
        this.rack = rack;

    }

    /**
     * 
     * @return le nom
     */
    public String getName() {
        return this.name;
    }

    /**
     * Lit le nom du joueur sur l'entr�e standard et l'affecte au joueur, si
     * aucun nom lut alors on garde Player [number] comme nom.
     * 
     * @param number
     *            le numero du joueur
     */
    public void setName(String number) {
        System.out.println("Player " + number + " name?");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e) {

            e.printStackTrace();
        }
        if (!line.isEmpty())
            this.name = line;
    }

    /**
     * 
     * @return le score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * change le score
     * 
     * @param score
     *            le nouveau score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 
     * @return le rack
     */
    public Rack getRack() {
        return this.rack;
    }

    /**
     * change le rack
     * 
     * @param score
     *            le nouveau rack
     */
    public void setRack(Rack rack) {
        this.rack = rack;
    }

    /**
     * change le tour
     * 
     * @param score
     *            le nouveau tour
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     * 
     * @return TRUE si c'est au joueur de jouer, FALSE sinon
     */
    public Boolean getTurn() {
        return this.turn;
    }

}
