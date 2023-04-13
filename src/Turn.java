import java.util.Scanner;
import static java.text.MessageFormat.format;

public class Turn {
    private int winAmount = 0;
    private int loseAmount = 0;
    private boolean result;
    private int userIn = 1;

    //public getters and setters for the players money
    public int getWinAmount(){
        return winAmount;
    }

    public void setWinAmount(int winAmount) {
        this.winAmount = winAmount;
    }

    public int getLoseAmount(){
        return loseAmount;
    }

    public void setLoseAmount(int loseAmount) {
        this.loseAmount = loseAmount;
    }

    public boolean continuePlaying(int userIn){//method to determine if the player wants to continue
        if(userIn == 1){
           return true;
        }
        return false;
    }

    public boolean takeTurn(Player player, Host host) {//method to play the game
        var num = new Numbers();
        Scanner scnr = new Scanner(System.in);
        int money = player.getMoney();
        int guess;
        int numToGuess = num.getRandomNum();
        boolean result;

            do {//loop to prompt player for their guess
                System.out.println(format("{0}says, {1}, please guess a number between 0-100.",
                        host, player.getFullName()));
                guess = scnr.nextInt();

                if (guess == numToGuess) {//adds win amt to player currency
                    money += winAmount;
                    player.setMoney(money);
                    System.out.println("Congratulations, you guessed the number!");
                    result = true;

                } else{//subtracts lose amt from player currency
                    money -= loseAmount;
                    player.setMoney(money);
                    System.out.print("You guessed too ");
                    result = false;

                    if (guess > numToGuess) {//determines if guess was high or low
                        System.out.println("high");
                    } else {
                        System.out.println("low");
                    }
                }
                System.out.println(player);//prints player name and money

            } while (!num.compareNumber(guess));
        return result;
    }
}
