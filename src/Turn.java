import java.util.Random;

public class Turn{
    private Money money = new Money();
    private Physical physical = new Physical();
    public  Phrase phrase = new Phrase();
    private String guess;
    private String winner;
    private String loser;
    //public GUI gui;

    public void takeTurn(Player player, Host host){//
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

    public void setGuess(String playerGuess){
        guess = playerGuess;
    }

    public void clearGuess(){
        guess = "";
    }

    public String getGuess(){
        return guess;
    }

    public void typeOfPrize(Player player , boolean guess){//determines what prize the player will win
        int currentMoney = player.getMoney();
        Random rand = new Random();//
        int prize = rand.nextInt(10);

        if ( prize > 1 ) {//updates player currency
            currentMoney += money.displayWinnings(player, guess);
            winner = money.getWinner();
            loser = money.getLoser();
            player.setMoney(currentMoney);
        } else {
            currentMoney += physical.displayWinnings(player, guess);
            winner = physical.getWinner();
            loser = physical.getLoser();
            player.setMoney(currentMoney);
        }
    }

    public String getWinner(){
        return winner;
    }

    public String getLoser(){
        return loser;
    }
}