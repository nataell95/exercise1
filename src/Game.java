public class Game {
    String currentPlayer;
    String computerPlayer;

    public void startGame() {

    }
    
    public void initializeGame() {
        
    }

    public void switchPlayers() {

    }

    public void getDefaultBoats() {
        
    }
    

    public static void main(String[] args) throws Exception {
        ComputerPlayer computer = new ComputerPlayer(false);
        HumanPlayer human = new HumanPlayer(true);
        human.showgrid();
          
    }

}
