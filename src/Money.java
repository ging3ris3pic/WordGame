public class Money implements Award {
    private int winAmount = 500;
    private int loseAmount = 200;

    public int displayWinnings(Player player, Boolean guess){//method to return money as a prize
        if(guess){
            System.out.println(player.getFullName() + ", that is correct! You win $" + winAmount);
            return winAmount;
        }else{
           System.out.println(player.getFullName() + ", sorry, that is incorrect! You lost $" + loseAmount);
           return -loseAmount;
        }
    }
}
