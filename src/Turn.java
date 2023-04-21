import java.util.Random;
import java.util.Scanner;
import static java.text.MessageFormat.format;

public class Turn {
    private boolean result;
    private int userIn = 1;
    private Money money = new Money();
    private Physical physical = new Physical();

    public boolean continuePlaying(int userIn){//method to determine if the player wants to continue
        return userIn == 1;
    }

    public boolean takeTurn(Player player, Host host) {//method to play the game
        var num = new Numbers();
        Scanner scnr = new Scanner(System.in);
        int currentMoney = player.getMoney();
        int guess;
        int numToGuess = num.getRandomNum();
        System.out.println(numToGuess);
        boolean result;

        System.out.println(format("{0}says, {1}, please guess a number between 0-100.",
                host, player.getFullName()));
        guess = scnr.nextInt();

        if (guess == numToGuess) {//adds win amt to player currency
            System.out.println("Congratulations, you guessed the number!");
            result = true;
        } else{//subtracts lose amt from player currency
            System.out.print("You guessed too ");
            result = false;

            if (guess > numToGuess) {//determines if guess was high or low
                System.out.println("high");
            } else {
                System.out.println("low");
            }
        }

        Random rand = new Random();
        int typeOfPrize = rand.nextInt(10);//random number used for the type of prize

        if(typeOfPrize > 3){//determines if the player wins a physical or cash prize
            currentMoney += money.displayWinnings(player,result);
        }else{
            currentMoney += physical.displayWinnings(player,result);
        }

        player.setMoney(currentMoney);
        System.out.println(player);//prints player name and money

        return result;
    }
}
