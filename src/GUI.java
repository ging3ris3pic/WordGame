import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI{
    private Game game;
    JFrame frame = new JFrame("Word game");
    JButton newPlayerButton = new JButton("Add player");
    JButton newHostButton = new JButton("Add host");
    JButton startTurnButton = new JButton("Start turn");
    JLabel player = new JLabel();
    JLabel host = new JLabel();
    JLabel playingPhrase = new JLabel();
    final int WIDTH = 500;
    final int HEIGHT = 300;
    private int count = 3;

    public GUI(){
        game = new Game();
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(newPlayerButton);
        frame.add(newHostButton);
        frame.add(startTurnButton);
        newPlayerButton.setSize(100,25);
        newPlayerButton.setVisible(true);
        newPlayerButton.setEnabled(true);
        newHostButton.setSize(100,25);
        newHostButton.setVisible(true);
        newHostButton.setEnabled(true);
        startTurnButton.setSize(100, 25);
        startTurnButton.setVisible(true);
        startTurnButton.setEnabled(true);
        addPlayer();
        addHost();
        startTurn();
    }

    public void startTurn(){
        startTurnButton.addActionListener(e -> {
            if(! game.guessedAll()){
                String guess = JOptionPane.showInputDialog("Please enter a letter to guess");
                game.setGuess(guess);
            }else {
                playAgain();
                return;
            }
            game.playerTurn();
            updatePlayerList();
            updatePlayingPhrase();
        });
    }

    public void playAgain(){
        int continueGame;
        if(game.guessedAll()){
            continueGame = JOptionPane.showConfirmDialog(null, "Would you like to play again?" +
                    JOptionPane.YES_NO_OPTION);
            if(continueGame == 0){
                game.clearGuesses();
                promptHostPhrase();
            }
            else{
                JOptionPane.showMessageDialog(null, "Thank you for playing!");
            }
        }
    }

    public void promptHostPhrase(){
        String hostPhrase = JOptionPane.showInputDialog("Please enter a phrase");
        Phrase.gamePhrase = hostPhrase;
        updatePlayingPhrase();
    }

    public void addPlayer(){
        newPlayerButton.addActionListener(e -> {
            String pFirstName = JOptionPane.showInputDialog("Please enter your first name");
            String pLastName = JOptionPane.showInputDialog("Pleas enter your last name");
            String[] firstNames = pFirstName.split(" ", count);
            String [] lastNames = pLastName.split(" ", count);
            String firstName = firstNames[0];
            String lastName = lastNames[0];
            game.addPlayer(firstName, lastName);
            updatePlayerList();
        });
    }

    public void updatePlayerList(){
        ArrayList<Player> players = game.getPlayers();
        player.setText("Current players: " + players);
        frame.add(player);
    }

    public void addHost(){
        newHostButton.addActionListener(e -> {
            String hostName = JOptionPane.showInputDialog("Please enter host name");
            game.addHost(hostName);
            promptHostPhrase();
            updateHost();
        });
    }

    public void updateHost(){
        Host newHost = game.getHost();
        host.setText("Current host: " + newHost);
        frame.add(host);
    }

    public void updatePlayingPhrase(){
        playingPhrase.setText("Phrase to guess: " + game.getHostPhrase());
        frame.add(playingPhrase);
    }
}
