public class Host extends Person {

    public Host(String fName){
        super(fName);
    }

    public int randomizeNum(){//creates a random num for the player to guess
        Numbers randNum = new Numbers();
        randNum.generateNumber();
        return randNum.getRandomNum();
    }

}
