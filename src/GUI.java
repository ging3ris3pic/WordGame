import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI implements ActionListener{
    JFrame frame = new JFrame();
    JButton newPlayer = new JButton("Add player");
    JButton newHost = new JButton("Add host and playing phrase");
    JButton startTurn = new JButton("Start turn");
    JLabel player = new JLabel();
    JLabel host = new JLabel();
    JLabel playingPhrase = new JLabel("Current playing Phrase");
    ArrayList<Player> players = new ArrayList<>();
    final int WIDTH = 300;
    final int HEIGHT = 120;
    private int numOfPlayers;
    String result;
    Player name;

    public GUI(){
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(newPlayer);

    }

    public void updatePlayerList(){
        //Player[] players = new Player[numOfPlayers];
        int i = 0;
        //JLabel player = new JLabel(Arrays.toString(players));
        frame.add(player);
    }

    public void updateHost(){
        Host host = new Host("");
    }

    public int setNumOfPlayers(){
        int count = 0;
        numOfPlayers = count;
        return numOfPlayers;
    }

    public void addPlayer(){
        newPlayer.setSize(100,50);
        newPlayer.setVisible(true);
        newPlayer.addActionListener(this);
        frame.add(newPlayer);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        JLabel question = new JLabel("What is your name");
        frame.add(question);
        JTextField answer = new JTextField();
        frame.add(answer);
        players.add(name);

    }

    public void updateGUI(){
        addPlayer();
        updatePlayerList();
        updateHost();
    }
}

