import javax.swing.*;
import java.util.Random;

public class Physical implements Award {
    private String[] physicalPrize = new String[]{"TV", "Camera", "Car", "Gold bar", "Chicken Statue"};

    public Physical() {
    }

    public int displayWinnings(Player player, Boolean guess) {
        int prize;
        if (guess) {
            prize = this.getRandomPrize();
            JOptionPane.showMessageDialog(null, player.getFullName() + " that is correct"
                    + " you win a " + this.physicalPrize[prize] + ". You currently have $" + player.getMoney());
            return 0;
        } else {
            prize = this.getRandomPrize();
            JOptionPane.showMessageDialog(null, player.getFullName() + " that is incorrect"
                    + " you could have won a " + this.physicalPrize[prize] + ". You currently have $" + player.getMoney());
            return 0;
        }
    }

    public int getRandomPrize() {
        Random rand = new Random();
        return rand.nextInt(this.physicalPrize.length);
    }
}


