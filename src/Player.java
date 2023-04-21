public class Player extends Person {
    private int money;

    public Player(String fName){//creates a player object w/ firstname only
        super(fName);
        money = 1000;
    }

    public Player(String fName , String lName){//creates a player object w/ firstname and lastname
        super(fName , lName);
        money = 1000;
    }

    //public getter and setter for money
    public void setMoney(int newMoney){
        money = newMoney;
    }

    public int getMoney(){
        return this.money;
    }

    @Override
    public String toString(){//overridden string to print name and money
        return super.toString() + ": $" + money;
    }
}
