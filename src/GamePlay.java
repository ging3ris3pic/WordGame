import java.util.Scanner;
public class GamePlay {

    private static Person person;

    //Main method
    public static void main(String[]args){
        //Initializes scanner
        Scanner scnr = new Scanner(System.in);
        Numbers randomNum = new Numbers();
        String fName = "";
        int guess;

        //Loop continues until first name is entered
        while(fName.isBlank()){
            //Reads the first name of the user
            System.out.print("Enter first name: ");
            fName = scnr.nextLine();
            //Check if first name is entered
            if(fName.isBlank()){
                System.out.println("First name is not valid");
            }
        }
        //Reads last name if entered
        System.out.print("Enter last name (Optional): ");
        String lName = scnr.nextLine();

        //Creates an object depending on if the user enters a last name
        if(!lName.isBlank()){
            person = new Person(fName, lName);
        }else{
            person = new Person(fName);
        }

        //Calls the method to generate a random number
        randomNum.generateNumber();

        //loop that continues repeating until a number between 1-100 is entered
        for(int i = 0; i<=10; i++) {
            //Loop runs until user guess matches randomNum
            do {
                System.out.print(person.getFirstName().toUpperCase() + " " + person.getLastName().toUpperCase()
                        + ", " + "please guess a number between 0-100: ");
                guess = scnr.nextInt();
                //Checks if number falls in parameters
                if (guess < 0 || guess > 100) {
                    System.out.println("Guessed number is outside of parameters.");
                    break;
                }
            } while (randomNum.compareNumber(guess) == false);
            if(guess == randomNum.getRandomNum()){
                break;
            }
        }
    }
}
