package src.fr.scrabble.modele.modele;

import java.util.Hashtable;



public class LanguageEn extends Language {
    
    
    /**
     * On ajoute au langage les lettres. les values de la hashtable sont les
     * lettres et les keys sont la valeur correspondant � la lettre
     */
    public LanguageEn() {
        this.dic.put(new Letter('A', 1), 9);
        this.dic.put(new Letter('B', 3), 2);
        this.dic.put(new Letter('C', 3), 2);
        this.dic.put(new Letter('D', 2), 4);
        this.dic.put(new Letter('E', 1), 12);
        this.dic.put(new Letter('F', 4), 2);
        this.dic.put(new Letter('G', 2), 3);
        this.dic.put(new Letter('H', 4), 2);
        this.dic.put(new Letter('I', 1), 9);
        this.dic.put(new Letter('J', 8), 1);
        this.dic.put(new Letter('K', 5), 1);
        this.dic.put(new Letter('L', 1), 4);
        this.dic.put(new Letter('M', 3), 2);
        this.dic.put(new Letter('N', 1), 6);
        this.dic.put(new Letter('O', 1), 8);
        this.dic.put(new Letter('P', 3), 2);
        this.dic.put(new Letter('Q', 10), 1);
        this.dic.put(new Letter('R', 1), 6);
        this.dic.put(new Letter('S', 1), 4);
        this.dic.put(new Letter('T', 1), 6);
        this.dic.put(new Letter('U', 1), 4);
        this.dic.put(new Letter('V', 4), 2);
        this.dic.put(new Letter('W', 4), 2);
        this.dic.put(new Letter('X', 8), 1);
        this.dic.put(new Letter('Y', 4), 2);
        this.dic.put(new Letter('Z', 10), 1);
        // this.dic.put(new Letter('$', 0), 2);
    }

    /**
     * 
     * @return la hashtable du langage
     */
    @Override
    public Hashtable<Letter, Integer> getDic() {
        return this.dic;
    }

    @Override
    public String toString() {
        String s = "<html> Distribution : <br /><br />";
        java.util.Iterator<Integer> itValue = dic.values().iterator();
        java.util.Iterator<Letter> itKey = dic.keySet().iterator();

        while (itValue.hasNext()) {
            Integer value = (Integer) itValue.next();
            Letter key = (Letter) itKey.next();
            if (value == 1)
                s += "  There is " + value +" "+ key + " in the bag.<br />";
            else
                s += "  There are " + value +" "+ key + " in the bag.<br />";
        }
        return s+"</html>";
    }

}
