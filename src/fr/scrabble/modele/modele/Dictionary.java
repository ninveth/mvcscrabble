package src.fr.scrabble.modele.modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    
    
    ArrayList<String> dico;

    /**
     * Charge les mots d'un .txt dns dico
     * 
     * @param filename
     *            le path du .txt
     */
    public Dictionary(String filename) {

        Scanner sc;
        this.dico = new ArrayList<String>();
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNext())
                this.dico.add(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * @param word
     *            Le mot � tester
     * @return TRUE si word est dans le dictionnaire
     */
    public boolean contains(String word) {

        return this.dico.contains(word);

    }

    /**
     * 
     * @return Le nombre de mots du dictionnaire
     */
    public int size() {

        return this.dico.size();

    }

    /**
     * 
     * @return Le dictionnaire
     */
    public ArrayList<String> getDico() {
        return this.dico;
    }
    
//    public static void main(String[] args){
//        Dictionary dic = new Dictionary("anglais.txt");
//        boolean check = dic.contains("as");
//        System.out.println(check);
//    }


}
