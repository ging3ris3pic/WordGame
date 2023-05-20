import javax.swing.*;

public class Money implements Award{
    private int winAmount = 500;
    private int loseAmount = 200;
    private String winner;
    private String loser;

    public int displayWinnings(Player player, Boolean guess){//method to return money as a prize
        int lostMoney = player.getMoney() - loseAmount;
        int wonMoney = player.getMoney() + winAmount;

        if(guess){
            winner = player.getFullName() + " that is correct! "
                    + "You win S" + winAmount + ". You now have $" + wonMoney;
            return winAmount;
        }
        loser = player.getFullName() + " that is incorrect. "
                + "You lose $" + loseAmount + ". you currently have $" + lostMoney;
        return - loseAmount;
    }

    public String getWinner(){
        return winner;
    }

    public String getLoser(){
        return loser;
    }
}