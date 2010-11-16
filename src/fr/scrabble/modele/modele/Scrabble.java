package src.fr.scrabble.modele.modele;



public class Scrabble extends AbstractModel {
    
    public static boolean tg, turn = true;
    private Player playerOne, playerTwo;
    private Board board;
    private int endGameCount = 0;
    private Rack rack, rack1;
    private Dictionary dico;
    private LanguageEn lang;
    private Bag bag;

    public Scrabble() {

    }

    @Override
    public Letter[][] getBoardState() {

        return board.getBoard();
    }

    @Override
    public Player getCurrentPlayer() {
        if (playerOne.getTurn())
            return playerOne;
        return playerTwo;
    }

    @Override
    public Rack getRack() {
        if (playerOne.getTurn())
            return rack;

        return rack1;
    }

    @Override
    public String getScoringScheme() {
        Letter[] tmp = new Letter[1];
        Letter[] letters = lang.getDic().keySet().toArray(tmp);
        String s = "<html>Scoring Scheme : <br /><br />";
        for (int i = 0; i < letters.length; i++)
            s += "  " + letters[i].toString(true) + "<br />";
        s += "</html>";
        return s;
    }

    @Override
    public boolean lookup(String word) {
        return dico.contains(word);
    }

    @Override
    public void newGame(String p1name, String p2name)  {

        dico = new Dictionary("anglais.txt");
        lang = new LanguageEn();
        bag = new Bag(lang);

        rack = new Rack();
        rack.fillrack(bag);
        rack1 = new Rack();
        rack1.fillrack(bag);

        if (p1name.equals(""))
            p1name = "Player 1";
        if (p2name.equals(""))
            p2name = "Player 2";

        playerOne = new Player(p1name, 0, rack);
        playerTwo = new Player(p2name, 0, rack1);
        playerOne.setTurn(true);

        board = new Board();

        fireNouvellePartie();

    }

    @Override
    public void skip() {
        playerOne.setTurn(!playerOne.getTurn());
        playerTwo.setTurn(!playerTwo.getTurn());
        firePlayerChanged();

        if (endGameCount >= 5) {
            fireEndGameEvent();
        }
    }

    @Override
    public void addWord(Word word) {
        int i = 0;
        if (board.getWords().isEmpty()) {
            word.setX(7);
            word.setY(7);
            i = 1;
        }

        Player tmp = this.getCurrentPlayer();
        int score;
        rack = tmp.getRack();

        score = tmp.getScore();

        if (board.addWord(word, this.getRack(), bag, dico)) {

            tmp.setScore(word.addPoints(score, i));
            this.skip();
            fireScoresChanged();
            fireBoardChanged();

        } else {

            fireBadWord();
        }

    }

    @Override
    public Player getPlayer(int i) {
        if (i == 1)
            return playerOne;
        return playerTwo;
    }

    @Override
    public String getDist() {
        return lang.toString();
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public int getEndGameCount() {
        return endGameCount;
    }

    @Override
    public void setEndGameCount() {
        endGameCount++;
    }


}
