import javax.swing.*;
import java.util.Random;

public class Physical implements Award {
    private String[] physicalPrize = new String[]{"TV", "Camera", "Car", "Gold bar", "Chicken Statue"};
    private String winner;
    private String loser;
    public Physical() {
    }

    public int displayWinnings(Player player, Boolean guess) {
        int prize;
        if (guess) {
            prize = this.getRandomPrize();
            winner = player.getFullName() + " that is correct"
                    + " you win a " + this.physicalPrize[prize] + ". You currently have $" + player.getMoney();
            return 0;
        } else {
            prize = this.getRandomPrize();
            loser = player.getFullName() + " that is incorrect"
                    + " you could have won a " + this.physicalPrize[prize] + ". You currently have $" + player.getMoney();
            return 0;
        }
    }

    public int getRandomPrize() {
        Random rand = new Random();
        return rand.nextInt(this.physicalPrize.length);
    }

    public String getWinner(){
        return winner;
    }

    public String getLoser(){
        return loser;
    }
}