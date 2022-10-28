public class HumanPlayer extends Player {
    public HumanPlayer() {
        super();
        this.grid = new Grid(true);
        this.human = true;
        playBoats();
    }
    
    public void playBoats() {
        for (Boatsenum type : Boatsenum.values()) {
            for (int nrboat = 0; nrboat < type.numberofboat(); nrboat++) {
                System.out.println(String.format("Write the boat coordinates. The length is: %d", type.lengthofboat()));
                String coord = scanner.next();
                boolean input_valid = checkForValidInput(coord);
                if (input_valid == false) {
                    System.out.println("your input is invalid, input it again, the length of the boat is");
                    nrboat--;
                } else {
                    Boat boa = new Boat(type.typofboat(), type.lengthofboat(), coord, type.returnSymbol(), true);
                    boolean boatPlacable = grid.tryPlacement(boa);
                    if (boatPlacable == false || boa.getValidLength() == false) {
                        System.out.println("boat not placable plz place it at another position");
                        nrboat--;
                    } else {
                        System.out.println("boat was placed");
                    }
                }
            }
        }

    }

    public String shootAtCoord() {
        System.out.println(String.format("Shoot at coordinate: __"));
        String coord = scanner.next();
        return coord;

    }

    @Override
    public boolean getShotAtPosition(String coord) {
        boolean bombPlaced = this.grid.placeBomb(coord);
        if (bombPlaced == false) {
            return false;
        }
        else {
            bombPlaced = this.grid.placeBomb(coord);
            System.out.println("Shot was fired by the Computer");
            return true;
        }
    }
    @Override
    public void changeTurn() {
        playerTurn = "computer";
    }

    @Override
    public void showgrid(){
        this.grid.drawGrid();
    }
    
}