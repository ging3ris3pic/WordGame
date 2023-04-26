import java.util.Scanner;

public class Phrase {
    static String gamePhrase;
    private String playingPhrase;

    public void setPhrase(Host host){
        String phrase = host.hostPhrase();
        playingPhrase = phrase;
    }

    public String getPhrase(){

        return playingPhrase;
    }
}
