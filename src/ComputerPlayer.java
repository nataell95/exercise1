import java.util.*;
import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(boolean human) {
        super(human);
        playBoats();
    }
    
    public void playBoats() {
        Random r = new Random();
        int lastNumber;
        int firstNumber;
        char firstLetter;
        char lastLetter;
        String coord;
        for (Boatsenum type : Boatsenum.values()) {
            for (int nrboat = 0; nrboat < type.numberofboat(); nrboat++) {
                int letter = r.nextInt(2);
                if (letter == 0) {
                    firstNumber = r.nextInt(10);
                    lastNumber = firstNumber + type.lengthofboat()-1;
                    firstLetter = (char) (r.nextInt(10) + 'A');
                    lastLetter = firstLetter;
                } else {
                    firstLetter = (char) (r.nextInt(10) + 'A');
                    lastLetter = (char) (type.lengthofboat()-1 + firstLetter);
                    firstNumber = r.nextInt(10);
                    lastNumber = firstNumber;
                }

                coord = Character.toString(firstLetter) + Integer.toString(firstLetter) + "," + Character.toString(lastLetter) + Integer.toString(lastNumber) ;
                boolean input_valid = checkForValidInput(coord);
                if (input_valid == false) {
                    nrboat--;                    
                } else {
                    Boat boa = new Boat(type.typofboat(), type.lengthofboat(), coord, type.returnSymbol(), true);
                    boolean boatPlacable = grid.tryBoatplacement(boa);
                    if (boatPlacable == false) {
                        nrboat--; 
                    } else {
                        System.out.println("boat was placed");
                    }
                }
            }
        }
    }
    
}