

abstract class Player {
    boolean human;
    Grid grid;

    public Player(boolean human) {
        this.grid = new Grid(human);
        this.grid.initboard();
        this.human = human;
    }

    public enum Boatsenum {
        CARRIER("Carrier", 6,0,"C"),
        BATTLESHIP("Battleship", 4,0,"B"),
        SUBMARINE("Submarine", 3,0,"S"),
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
    

    public boolean hasLost(Grid grid) {
        if (grid.PlayerLost() == true) {
            return true;
        }
        else {
            return false;
        }
        
    }

    public boolean checkForValidInput(String input){/*has to be done */
        return true;
    }
    
    public void showgrid() {
        this.grid.drawGrid();
    }

    public void shootboat(Grid grid, String coord) {
        grid.placeBomb(coord);
    }


    public void playRound() {
        
    }
}
