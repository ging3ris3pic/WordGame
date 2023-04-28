import java.util.Scanner;
interface Award{
    int displayWinnings(Player player, Boolean guess);

}

public class GamePlay{

    //Main method
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        Host host = new Host("Jim");
        Turn turn = new Turn();
        int userIn;

        Player[] currentPlayers = new Player[3];//array created to store player objects

        for(int i = 0; i < currentPlayers.length; i++){//prompts 3 players names to store in the array
            System.out.print("Enter first name: ");
            String fName = scnr.nextLine();
            System.out.print("Enter last name (Optional):");
            String lName = scnr.nextLine();

            if(! lName.isBlank()){//stores the player object in array
                currentPlayers[i] = new Player(fName, lName);
            } else {
                currentPlayers[i] = new Player(fName);
            }
        }

        boolean continuePlaying;

        do {//calls host obj to enter a phrase and clear guesses if the player continues
            host.hostPhrase();
            turn.phrase.clearGuess();
            while (!turn.phrase.hasGuessedAll()) {//loops until all letters are guessed
                for(Player currentPlayer : currentPlayers){
                    turn.takeTurn(currentPlayer, host);
                    if(turn.phrase.hasGuessedAll()){//breaks out of the loop if all letters are guessed
                        System.out.println("Congrats, you solved the puzzle!");
                        break;
                    }
                }
            }

            System.out.println("Enter 1 to continue playing or 2 to quit");
            userIn = scnr.nextInt();
            continuePlaying = turn.continuePlaying(userIn);

        } while (continuePlaying);
        scnr.close();
    }
}

