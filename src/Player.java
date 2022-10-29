import java.util.Scanner;

abstract class Player {
    boolean human;
    Grid grid;
    Scanner scanner;
    String playerTurn = "computer";

    public Player() {
        this.scanner = new Scanner(System.in);
    }

    public enum Boatsenum {
        CARRIER("Carrier", 6,2,"C"),
        BATTLESHIP("Battleship", 4,2,"B"),
        SUBMARINE("Submarine", 3,2,"S"),
        PATROLBOAT("Patrolboat", 2,2,"P");

        private final String type;
        private final int length;
        private final int numberof;
        private final String symbol;

        private Boatsenum(String type, int length, int numberof,String symbol) {
            this.type = type;
            this.length = length;
            this.numberof = numberof;
            this.symbol = symbol;
        }

        public String typofboat() {
            return this.type;
        }

        public int lengthofboat() {
            return this.length;
        }

        public int numberofboat() {
            return this.numberof;
        }

        public String returnSymbol() {
            return this.symbol;
        }
    }
    

    public boolean hasLost() {
        return this.grid.PlayerLost();
    }

    public boolean checkForValidInput(String input) {/*has to be done */
        return true;
    }
    
    abstract boolean getShotAtPosition(String coord);
    
    abstract void changeTurn();

    abstract void showgrid();

    abstract String shootAtCoord();

    public void playRound() {
        
    }
}
