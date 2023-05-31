import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI{
    private Game game;
    DefaultListModel listModel = new DefaultListModel();
    JList log = new JList(listModel);
    JScrollPane logPane = new JScrollPane();
    JFrame frame = new JFrame("Word game");
    JPanel nPanel = new JPanel();
    JPanel logPanel = new JPanel();
    JPanel currentPlayers = new JPanel();
    JPanel currentPlayingPhrase = new JPanel();
    JPanel currentHost = new JPanel();
    JMenuItem newPlayer = new JMenuItem("Add player");
    JMenuItem newHost = new JMenuItem("Add host");
    JMenuItem aboutLayout = new JMenuItem("Layout");
    JButton startTurnButton = new JButton("Start turn");
    JCheckBox saveLog = new JCheckBox("Save logs");
    JMenuBar mainMenu = new JMenuBar();
    JMenu gameMenu = new JMenu("Game");
    JMenu aboutMenu = new JMenu("About");
    JLabel player = new JLabel();
    JLabel host = new JLabel();
    JLabel playingPhrase = new JLabel();
    final int WIDTH = 500;
    final int HEIGHT = 300;
    private int count = 3;

    public GUI(){
        game = new Game();
        frameSettings();
        addPanels();
        logPaneSettings();
        mainMenuSettings();
        aboutMenuSettings();
        gameMenuSettings();
        saveLogSettings();
        startTurnButtonSettings();
        addPlayer();
        addHost();
        startTurn();
        about();
        frame.revalidate();
    }

    public void addPanels(){
        frame.add(nPanel, BorderLayout.NORTH);
        logPanel.setPreferredSize(new Dimension(400,100));
        frame.add(logPanel,BorderLayout.SOUTH);
        logPanel.add(logPane);
        log.setLayoutOrientation(JList.VERTICAL);
        frame.add(currentPlayers,BorderLayout.EAST);
        frame.add(currentHost,BorderLayout.WEST);
        frame.add(currentPlayingPhrase,BorderLayout.CENTER);
    }

    public void logPaneSettings(){
        logPane.setViewportView(log);
        logPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        logPane.setPreferredSize(new Dimension(450,75));
    }

    public void saveLogSettings(){
        saveLog.setToolTipText("When selected, chat logs are saved");
        logPanel.add(saveLog);
    }

    public void mainMenuSettings(){
        frame.setJMenuBar(mainMenu);
    }

    public void aboutMenuSettings(){
        aboutMenu.setMnemonic('A');
        aboutMenu.add(aboutLayout);
        mainMenu.add(aboutMenu);
    }

    public void gameMenuSettings(){
        gameMenu.setMnemonic('G');
        gameMenu.add(newPlayer);
        gameMenu.add(newHost);
        mainMenu.add(gameMenu);
    }

    public void startTurnButtonSettings(){
        startTurnButton.setSize(100, 25);
        startTurnButton.setVisible(true);
        startTurnButton.setEnabled(true);
        startTurnButton.setBackground(Color.gray);
        nPanel.add(startTurnButton);
    }

    public void frameSettings(){
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    public void about(){
        aboutLayout.addActionListener(e ->{
            String reason = "The layout style that I went with is the BorderLayout. The reason I chose this "
                    + "layout is due to the ease of use, and ability to choose what side I want my components.";
            JOptionPane.showMessageDialog(null, reason);
        });
    }

    public void addLog(){
        ArrayList<String> results = new ArrayList<>();
        results.add(game.addLog());
        if(saveLog.isSelected()){
            for(int i = 0; i < results.size(); i++){
                results.set(i, game.addLog());
                listModel.addElement(results.get(i));
            }
        }else{
            listModel.add(0,game.addLog());
        }
        log.setVisible(true);
        logPanel.add(logPane);
    }

    public void updateLog(){
        addLog();
        logPanel.add(logPane);
    }

    public void startTurn(){
        startTurnButton.addActionListener(e -> {
            if(! game.guessedAll()){
                String guess = JOptionPane.showInputDialog("Please enter a letter to guess");
                game.setGuess(guess);

                if(!saveLog.isSelected() && !listModel.isEmpty()){
                    listModel.removeAllElements();
                }
            }else {
                playAgain();
                return;
            }
            game.playerTurn();
            updatePlayerList();
            updatePlayingPhrase();
            updateLog();
            frame.revalidate();
        });
    }

    public void playAgain(){
        int continueGame;
        if(game.guessedAll()){
            continueGame = JOptionPane.showConfirmDialog(null, "Would you like to play again?" +
                    JOptionPane.YES_NO_OPTION);
            listModel.removeAllElements();

            if(continueGame == 0){
                game.clearGuesses();
                promptHostPhrase();
            }
            else{
                JOptionPane.showMessageDialog(null, "Thank you for playing!");
            }
            frame.revalidate();
        }
    }

    public void promptHostPhrase(){
        String hostPhrase = JOptionPane.showInputDialog("Please enter a phrase");
        Phrase.gamePhrase = hostPhrase;
        updatePlayingPhrase();
    }

    public void addPlayer(){
        newPlayer.addActionListener(e -> {
            String pFirstName = JOptionPane.showInputDialog("Please enter your first name");
            String pLastName = JOptionPane.showInputDialog("Pleas enter your last name");
            String[] firstNames = pFirstName.split(" ", count);
            String [] lastNames = pLastName.split(" ", count);
            String firstName = firstNames[0];
            String lastName = lastNames[0];
            game.addPlayer(firstName, lastName);
            updatePlayerList();
            frame.revalidate();
        });
    }

    public void updatePlayerList(){
        ArrayList<Player> players = game.getPlayers();
        player.setText("Current players: " + players);
        currentPlayers.add(player);
    }

    public void addHost(){
        newHost.addActionListener(e -> {
            String hostName = JOptionPane.showInputDialog("Please enter host name");
            game.addHost(hostName);
            promptHostPhrase();
            updateHost();
            frame.revalidate();
        });
    }

    public void updateHost(){
        Host newHost = game.getHost();
        host.setText("Current host: " + newHost);
        currentHost.add(host);
    }

    public void updatePlayingPhrase(){
        playingPhrase.setText("Phrase to guess: " + game.getHostPhrase());
        currentPlayingPhrase.add(playingPhrase);
        frame.revalidate();
    }
}