public class Person {
    private String firstName;
    private String lastName;

    //overloading constructor that accepts 1 string input
    public Person(String fName){
        firstName = fName;
        lastName = "";
    }

    //overloading constructor that accepts 2 string inputs
    public Person(String fName, String lName){
        firstName = fName;
        lastName = lName;
    }

    //public getter for the first name
    public String getFirstName(){
        return firstName;
    }

    //public getter for the last name
    public String getLastName(){
        return lastName;
    }

    //public setter for the first name
    public void setFirstName(String fName){
        firstName = fName;
    }

    //public setter for the last name
    public void setLastName(String lName){
        lastName = lName;
    }
}
