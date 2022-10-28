import java.util.*;
public class Game {
    Random r = new Random();
    String[] playersNames = { "Computer", "Human" };
    String currentPlayer;
    String computerPlayer;
    ComputerPlayer computer;
    HumanPlayer human;
    boolean shotSucceded;
    
    private void initializeGame() {
        this.currentPlayer = playersNames[r.nextInt(2)];
        this.computer = new ComputerPlayer();
        this.human = new HumanPlayer();
    }

    private void changeCurrentPlayer()
    {
        if (this.currentPlayer.equals(playersNames[0])) {
            this.currentPlayer = playersNames[1];
        } else {
            this.currentPlayer = playersNames[0];
        }
        System.out.println("it is the turn of " + this.currentPlayer);
    }

    private void showGrids() {
        this.computer.showgrid();
        this.human.showgrid();
    }

    private void playRound() {
        for (int i = 0; i <= 1; ++i) {
            shotSucceded = false;
            if (this.currentPlayer.equals("Human")) {
                while (shotSucceded == false) {
                    shotSucceded = this.computer.getShotAtPosition(this.human.shootAtCoord());
                }
                if (this.computer.hasLost() == true) {
                    gameOver();
                }
            } else {
                while (shotSucceded == false) {
                    shotSucceded = this.human.getShotAtPosition(this.computer.shootAtCoord());
                }
                if (this.human.hasLost() == true) {
                    gameOver();
                }

            }
            changeCurrentPlayer();
        }
        showGrids();
}

private void gameOver() {
        showGrids();
        System.out.println(this.currentPlayer + "has Won the game");
        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.initializeGame();
        while(true){
            game.playRound();
        }

          
    }

}
