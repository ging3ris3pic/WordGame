import java.util.Scanner;
interface Award{
    abstract int displayWinnings(Player player, Boolean guess);

}
public class GamePlay {

    //Main method
    public static void main(String[]args) {
        //Initializes scanner
        Scanner scnr = new Scanner(System.in);
        Host host = new Host("Jim");
        Player player;
        Turn turn = new Turn();
        int userIn = 1;

       Player[] currentPlayers = new Player[3];

        for(int i = 0; i < currentPlayers.length; i++) {//prompts 3 players names to store in the array
            System.out.print("Enter first name: ");
            String fName = scnr.nextLine();
            System.out.print("Enter last name (Optional):");
            String lName = scnr.nextLine();

            //Creates an object depending on if the user enters a last name
            if (!lName.isBlank()) {
                currentPlayers[i] = new Player(fName, lName);
            } else {
                currentPlayers[i] = new Player(fName);
            }
        }

        boolean continuePlaying = true;

        do{//outer loop controlling gameplay
            host.randomizeNum();//changes the numToGuess if takeTurn is true
            boolean result = false;
            while (!result) {
                for(int i = 0; i < currentPlayers.length; i++) {
                    result = turn.takeTurn(currentPlayers[i], host);
                    if(result){
                        break;
                    }
                }
           }

            System.out.println("Enter 1 to continue playing or 2 to quit");
            userIn = scnr.nextInt();
            continuePlaying = turn.continuePlaying(userIn);

        }while(continuePlaying);
        scnr.close();
    }
}
