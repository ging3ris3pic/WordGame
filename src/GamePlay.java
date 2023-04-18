import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class GamePlay {

    //Main method
    public static void main(String[]args) {
        //Initializes scanner
        Scanner scnr = new Scanner(System.in);
        Host host = new Host("Jim");
        Player player;
        Turn turn = new Turn();
        turn.setWinAmount(400);
        turn.setLoseAmount(300);
        int userIn = 1;
        int i;

       Player[] currentPlayers = new Player[3];
        for(i = 0; i < currentPlayers.length; i++) {
            System.out.print("Enter first name: ");
            String fName = scnr.nextLine();

            //Reads last name if entered
            System.out.print("Enter last name (Optional):");
            String lName = scnr.nextLine();

            //Creates an object depending on if the user enters a last name
            if (!lName.isBlank()) {
                currentPlayers[i] = new Player(fName, lName);
            } else {
                currentPlayers[i] = new Player(fName);
            }
        }

        //System.out.println(currentPlayers[0]);
        //System.out.println(currentPlayers[1]);
        //System.out.println(currentPlayers[2]);


        do{//outer loop controlling gameplay
            host.randomizeNum();//changes the numToGuess if takeTurn is true
            do {//continues to loop until turn.takeTurn is true
                for(i = 0; i < currentPlayers.length; i++) {
                    turn.takeTurn(currentPlayers[i], host);
                }
            } while (false);
            System.out.println("Enter 1 to continue playing or 2 to quit");
            userIn = scnr.nextInt();
            turn.continuePlaying(userIn);
        }while(turn.continuePlaying(userIn) == true);

        scnr.close();
    }
}
