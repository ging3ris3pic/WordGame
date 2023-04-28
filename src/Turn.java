import java.util.Random;
import java.util.Scanner;

import static java.text.MessageFormat.format;

public class Turn{
    private Money money = new Money();
    private Physical physical = new Physical();
    public Phrase phrase = new Phrase();

    public boolean continuePlaying(int userIn){//method to determine if the player wants to continue
        return userIn == 1;
    }

    public void takeTurn(Player player, Host host){//
        Scanner scnr = new Scanner(System.in);
        String guess;

        hostPrompt(player, host);
        guess = scnr.next();
        boolean digit = phrase.digitFound(guess);

        try{//try {} catch block returns err if guess isnt a letter or is more than 1 letter
            phrase.findLetters(guess);
            if(phrase.findLetters(guess) && !digit){
                typeOfPrize(player, phrase.findLetters(guess));
            } else if(! phrase.findLetters(guess) && !digit){
                typeOfPrize(player, phrase.findLetters(guess));
            }else{
                System.err.println("Please enter a valid letter.");
            }

        } catch(MultipleLettersException e){
            System.err.println(e.getMessage());
        }

        System.out.println(player);//prints player name and bank
    }

    public void hostPrompt(Player player, Host host){//prints phrase and prompts player for guess
        System.out.println("The phase to guess is: " + phrase.replaceLetters());
        System.out.println(format("{0}says, {1}, please guess a letter in the phrase",
                host, player.getFullName()));
    }

    public void typeOfPrize(Player player , boolean guess){//determines what prize the player will win
        int currentMoney = player.getMoney();
        Random rand = new Random();//
        int prize = rand.nextInt(10);

        if ( prize > 1 ) {//updates player currency
            currentMoney += money.displayWinnings(player, guess);
            player.setMoney(currentMoney);
        } else {
            currentMoney += physical.displayWinnings(player, guess);
            player.setMoney(currentMoney);
        }
    }
}
