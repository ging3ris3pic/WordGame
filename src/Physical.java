import java.util.Random;

public class Physical implements Award{
    private String[] physicalPrize = { "TV", "Camera", "Car", "Gold bar", "Chicken Statue" };

    @Override
    public int displayWinnings(Player player, Boolean guess){//method to return a physical prize
        if(guess){
            int prize = getRandomPrize();
            System.out.println(player.getFullName() + ", that is correct, you won a " + physicalPrize[prize]);
            return 0;
        } else {
            int prize = getRandomPrize();
            System.out.println(player.getFullName() + ", that is correct. You could have won a "
                    + physicalPrize[prize]);
            return 0;
        }
    }

    public int getRandomPrize(){//method to call one of the random physical prizes
        Random rand = new Random();
        return rand.nextInt(physicalPrize.length);
    }
}

