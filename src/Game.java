import java.util.ArrayList;

public class Game{
    private Host host;
    private ArrayList<Player> players;
    private Turn turn = new Turn();
    private Phrase phrase;
    private int count;

    public Game() {
        phrase = new Phrase();
        players = new ArrayList<Player>();
    }

    public void playerTurn(){
        if(!phrase.hasGuessedAll()){
            turn.takeTurn(players.get(count), host);
        }
        try{
            phrase.findLetters(turn.getGuess());
        } catch(MultipleLettersException e){
            throw new RuntimeException(e);
        }
        if(count >= players.size()-1){
            count = 0;
        }else{
            count++;
        }
    }

    public String getWinner(){
        return turn.getWinner();
    }

    public String getLoser(){
        return turn.getLoser();
    }

    public String addLog(){
        String resultLog = "";
        try {
            if(phrase.findLetters(turn.getGuess())){
                resultLog = getWinner();
            }else{
                resultLog = getLoser();
            }
        } catch (MultipleLettersException e) {

        }

        return resultLog;
    }

    public boolean guessedAll(){
        boolean hasGuessedAll = phrase.hasGuessedAll();
        return hasGuessedAll;
    }

    public void clearGuesses(){
        phrase.clearGuess();
    }

    public Host addHost(String hostName){
        host = new Host(hostName);
        return host;
    }

    public String setGuess(String playerGuess){
        turn.setGuess(playerGuess);
        return playerGuess;
    }

    public Host getHost() {
        return host;
    }

    public String getHostPhrase(){
        String playingPhrase = phrase.replaceLetters();
        return playingPhrase;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> addPlayer(String firstName, String lastName) {
        Player newPlayer = new Player(firstName, lastName);
        players.add(newPlayer);
        return players;
    }

    public ArrayList<Player> addPlayer(String firstName) {
        return addPlayer(firstName, "");
    }
}