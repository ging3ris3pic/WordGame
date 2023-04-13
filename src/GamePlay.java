import java.util.Scanner;
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

        System.out.print("Enter first name: ");
        String fName = scnr.nextLine();

        //Reads last name if entered
        System.out.print("Enter last name (Optional):");
        String lName = scnr.nextLine();

        //Creates an object depending on if the user enters a last name
        if (!lName.isBlank()) {
            player = new Player(fName, lName);
        } else {
            player = new Player(fName);
        }

        do{//outer loop controlling gameplay
            host.randomizeNum();//changes the numToGuess if takeTurn is true

            do {//continues to loop until turn.takeTurn is true
                turn.takeTurn(player, host);

            } while (false);
            System.out.println("Enter 1 to continue playing or 2 to quit");
            userIn = scnr.nextInt();
            turn.continuePlaying(userIn);
        }while(turn.continuePlaying(userIn) == true);

        scnr.close();
    }
}
