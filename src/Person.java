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

    //public getters and setters for a person's name
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String fName){
        firstName = fName;
    }

    public void setLastName(String lName){
        lastName = lName;
    }

    public String getFullName(){//returns a persons full name
        if(lastName.isBlank()){
            return firstName;
        }
        return firstName + " " + lastName;
    }

    public String toString(){//
        return firstName + " " + lastName;
    }
}


