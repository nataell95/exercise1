import java.util.Random;

public class ComputerPlayer extends Player {
    private Random r = new Random();
    private int lastNumber;
    private int firstNumber;
    private char firstLetter;
    private char lastLetter;
    private String coord;

    public ComputerPlayer() {
        super();
        this.human = false;
        this.grid = new Grid(false);
        playBoats();
    }
    
    public void playBoats() {
        for (Boatsenum type : Boatsenum.values()) {
            for (int nrboat = 0; nrboat < type.numberofboat(); nrboat++) {
                int letter = r.nextInt(2);
                if (letter == 0) {
                    firstNumber = r.nextInt(10);
                    lastNumber = firstNumber + type.lengthofboat() - 1;
                    firstLetter = (char) (r.nextInt(10) + 'A');
                    lastLetter = firstLetter;
                } else {
                    firstLetter = (char) (r.nextInt(10) + 'A');
                    lastLetter = (char) (type.lengthofboat() - 1 + firstLetter);
                    firstNumber = r.nextInt(10);
                    lastNumber = firstNumber;
                }
                coord = Character.toString(firstLetter) + Integer.toString(firstNumber) + ","
                        + Character.toString(lastLetter) + Integer.toString(lastNumber);
                Boat boa = new Boat(type.typofboat(), type.lengthofboat(), coord, type.returnSymbol(), false);
                boolean boatPlacable = grid.tryPlacement(boa);
                if (boatPlacable == false) {
                    nrboat--;
                }
                
            }
        }
    }

    public String shootAtCoord() {
        firstNumber = r.nextInt(10);
        firstLetter = (char) (r.nextInt(10) + 'A');
        coord = Character.toString(firstLetter) + Integer.toString(firstNumber);
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
            System.out.println("Shot was fired by the Human");
            return true;
        }
    }
    @Override
    public void showgrid() {
        this.grid.drawGrid();
    }
    

}