import javax.swing.*;

public class Money implements Award{
    private int winAmount = 500;
    private int loseAmount = 200;

    public int displayWinnings(Player player, Boolean guess){//method to return money as a prize
        int lostMoney = player.getMoney() - loseAmount;
        int wonMoney = player.getMoney() + winAmount;
        if(guess){
            JOptionPane.showMessageDialog(null, player.getFullName() + " that is correct! "
                    + "You win S" + winAmount + ". You now have $" + wonMoney);
            return winAmount;
        }
        JOptionPane.showMessageDialog(null, player.getFullName() + " that is incorrect. "
                + "You lose $" + loseAmount + ". you currently have $" + lostMoney);
        return - loseAmount;
    }
}
