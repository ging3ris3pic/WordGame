import java.util.Random;
public class Numbers {
    private static int randomNum;

//Generates a random number between 0-100
    public int generateNumber(){
        Random rand = new Random();
        randomNum = rand.nextInt(100);
        return randomNum;
    }

    //public setter
    public void setRandomNum(){
        int random = randomNum;
    }

    //public getter
    public int getRandomNum(){
        return randomNum;
    }

//compares the user's guess to the random number generated
    public boolean compareNumber(int guess){
        if(guess == randomNum){
            return true;
        }else{
            return false;
        }
    }
}
