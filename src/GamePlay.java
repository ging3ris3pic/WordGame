import java.util.Scanner;
public class GamePlay {

    private static Person person;

    public static void main(String[]args){
        Scanner scnr = new Scanner(System.in);
        String fName = "";

        while(fName.isBlank()){
            System.out.print("Enter first name: ");
            fName = scnr.nextLine();
            if(fName.isBlank()){
                System.out.println("First name is not valid");
            }
        }

        System.out.print("Enter last name (Optional): ");
        String lName = scnr.nextLine();

        if(!lName.isBlank()){
            person = new Person(fName, lName);
        }else{
            person = new Person(fName);
        }
        System.out.println(person.getFirstName() + person.getLastName());
    }
}
