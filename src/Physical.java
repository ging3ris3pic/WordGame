import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Physical implements Award {
    private String[] physicalPrize = new String[]{"TV", "Camera", "Car", "Gold bar", "Chicken Statue"};
    private String winner;
    private String loser;
    public Physical() {
    }

    public int displayWinnings(Player player, Boolean guess) {
        int prize;
        ImageIcon img;

        if (guess) {
            prize = this.getRandomPrize();
            winner = player.getFullName() + " that is correct"
                    + " you win a " + this.physicalPrize[prize] + ". You currently have $" + player.getMoney();

            switch (prize) {
                case 0 -> {
                    try {
                        URL url = new URL("https://cdn.pixabay.com/photo/2012/04/13/15/03/monitor-32743_1280.png");
                        img = new ImageIcon(url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (img != null) {
                        JOptionPane.showMessageDialog(null, "Heres what youve won",
                                "Item won", JOptionPane.INFORMATION_MESSAGE, (Icon) img);
                    }
                }
                case 1 -> {
                    try {
                        URL url = new URL("https://cdn.pixabay.com/photo/2012/04/13/17/00/camera-32871_1280.png");
                        img = new ImageIcon(url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (img != null) {
                        JOptionPane.showMessageDialog(null, "Heres what youve won",
                                "Item won", JOptionPane.INFORMATION_MESSAGE, (Icon) img);
                    }
                }
                case 2 -> {
                    try {
                        URL url = new URL("https://cdn.pixabay.com/photo/2017/03/20/04/57/truck-2158284_1280.png");
                        img = new ImageIcon(url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (img != null) {
                        JOptionPane.showMessageDialog(null, "Heres what youve won",
                                "Item won", JOptionPane.INFORMATION_MESSAGE, (Icon) img);
                    }
                }
                case 3 -> {
                    try {
                        URL url = new URL("https://cdn.pixabay.com/photo/2013/07/12/12/55/gold-bar-146539_1280.png");
                        img = new ImageIcon(url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (img != null) {
                        JOptionPane.showMessageDialog(null, "Heres what youve won",
                                "Item won", JOptionPane.INFORMATION_MESSAGE, (Icon) img);
                    }
                }
                case 4 -> {
                    try {
                        URL url = new URL("https://cdn.pixabay.com/photo/2014/11/01/18/15/decorative-items-512654_1280.jpg");
                        img = new ImageIcon(url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if (img != null) {
                        JOptionPane.showMessageDialog(null, "Heres what youve won",
                                "Item won", JOptionPane.INFORMATION_MESSAGE, (Icon) img);
                    }
                }
            }
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