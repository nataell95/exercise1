public class HumanPlayer extends Player {
    private char coordinatesChars[];

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

    private boolean checkForValidInput(String coord) {
        this.coordinatesChars = coord.toCharArray();
        System.out.println(coord.indexOf(','));
        if (coord.length() != 5 || coord.indexOf(',') == -1) {
            return false;
        } else if (Character.isDigit(coordinatesChars[0]) == true || Character.isDigit(coordinatesChars[3]) == true
                || Character.isDigit(coordinatesChars[1]) == false || Character.isDigit(coordinatesChars[4]) == false) {
            return false;
        }
        else{
            return true;
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
    public void showgrid(){
        this.grid.drawGrid();
    }
    
}