import java.util.Scanner;

public class Host extends Person{

    public Host(String fName){
        super(fName);
    }

    public void hostPhrase(){//creates a random num for the player to guess

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a phrase for players to guess.");
        String phrase = scnr.nextLine();
        Phrase.gamePhrase = phrase;

    }

}
