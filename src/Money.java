public class Money implements Award{

    public int displayWinnings(Player player, Boolean guess){//method to return money as a prize
        if(guess){
            int winAmount = 500;
            System.out.println(player.getFullName() + ", that is correct! You win $" + winAmount);
            return winAmount;
        }
        int loseAmount = 200;
        System.out.println(player.getFullName() + ", sorry, that is incorrect! You lost $" + loseAmount);
        return - loseAmount;
    }
}
