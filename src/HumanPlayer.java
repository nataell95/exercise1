import java.util.*;

public class HumanPlayer extends Player {
    public HumanPlayer(boolean human) {
        super(human);
        playBoats();
    }
    
    public void playBoats() {
        for (Boatsenum type : Boatsenum.values()) {
            for (int nrboat = 0; nrboat < type.numberofboat(); nrboat++) {
                Scanner scan = new Scanner(System.in);
                System.out.println(String.format("Write the boat coordinates. The length is: %d", type.lengthofboat()));
                String coord = scan.next();
                boolean input_valid = checkForValidInput(coord);
                if (input_valid == false) {
                    System.out.println("your input is invalid, input it again, the length of the boat is");
                    nrboat--;                    
                } else {
                    Boat boa = new Boat(type.typofboat(), type.lengthofboat(), coord, type.returnSymbol(), true);
                    boolean boatPlacable = grid.tryBoatplacement(boa);
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
    
}