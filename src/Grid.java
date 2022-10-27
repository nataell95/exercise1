import java.util.*;

public class Grid {
    
    ArrayList<Boat> boats = new ArrayList<Boat>();
    Hashtable<String, Cell> cellDict = new Hashtable<String, Cell>();
    String header;
    boolean human;

    public Grid(boolean human) {
        initboard();
        computeHeader();
        this.human = human;
    }

    public void initboard() {
        int boardsize = 10;
        Cell empty_cell;
        String mergedCoord;
        for (int i = 0; i < boardsize; i++) {
            for (char c = 'A'; c <= 'J'; ++c) {
                mergedCoord = Character.toString(c) + Integer.toString(i);
                empty_cell = new Cell(mergedCoord, mergedCoord, false, false);
                cellDict.put(mergedCoord, empty_cell);
            }
        }
        drawGrid();
    }

    private void computeHeader(){
        if (human == true)
        {
            this.header = "===== OCEAN GRID =====";
        } else {
            this.header = "===== Target GRID =====";
        }
    }
    
    public void drawGrid() {
        int boardsize = 10;
        String cellValue;
        String mergedCoord;
        String vertical = "|";
        if (this.human == false) {
            this.header = "===== Oponent GRID =====";
        } else {
            this.header = "===== OCEAN GRID =====";
        }
        String plusMinusLine = " +-+-+-+-+-+-+-+-+-+-+";
        String xAxis = "  A B C D E F G H I J";
        String equals = "=======================";
        System.out.print(header);
        System.out.print("\n\n\n");
        System.out.println(xAxis);
        System.out.println(plusMinusLine);
        for (int row = 0; row < boardsize; row++) {
            System.out.print(row);
            for (char column = 'A'; column <= 'J'; ++column) {
                mergedCoord = Character.toString(column) + Integer.toString(row);
                cellValue = cellDict.get(mergedCoord).getValue();
                if (column != 'J') {
                    System.out.print(vertical + cellValue);
                } else {
                    System.out.print(vertical + cellValue + vertical);
                }
            }
            System.out.print(row);
            System.out.println("");

        }
        System.out.println(plusMinusLine);
        System.out.println(xAxis);
        System.out.println();
        System.out.println(equals);
        if (this.human == false){
            System.out.print("\n\n");
            System.out.print("-----------------------");
            System.out.print("\n\n");
        };

    }

    public class Cordsplit {
        String[] array;
        int xcoord;
        char ycoord;

        public Cordsplit(String coord) {
            array = coord.split("");
            xcoord = Integer.parseInt(array[1]);
            xcoord = array[0].charAt(0);
        }
    }

    public boolean tryBoatplacement(Boat boa) {
        ArrayList<Cell> cells = boa.getCellList();
        boolean placable;
        Cell dictCell;
        for (int i = 0; i < cells.size(); ++i) {
            Cell cell = cells.get(i);
            String cellcoord = cell.getCoord();
            boolean cellExists = cellDict.containsKey(cellcoord);
            dictCell = cellDict.get(cellcoord);
            if (cellExists == true) {
                if (dictCell.isboat == true) {
                    placable = false;
                    return placable;
                }
            } else {
                placable = false;
                return placable;
            }
        }
        placable = true;
        placeBoat(boa);
        return placable;
    }

    private void placeBoat(Boat boa) {
        boats.add(boa);
        ArrayList<Cell> cells = boa.getCellList();
        for (int i = 0; i < cells.size(); ++i) {
            Cell cell = cells.get(i);
            cellDict.put(cell.getCoord(), cell);
        }
    }

    public boolean placeBomb(String coord) {
        boolean checkPosition = cellDict.contains(coord);
        boolean alreadyShot = cellDict.contains(coord);
        if (checkPosition == false) {
            return false;
        } else if (alreadyShot == true) {
            return false;
        } else {
            cellDict.get("coord").isTouched();
            checkBoats();
            return true;
        }

    }

    private void checkBoats() {
        for (int i = 0; i < boats.size(); ++i) {
            boats.get(i).checkIfIsDestroyed();
        }
    }

    public boolean PlayerLost() {
        boolean lost;
        boolean issunk;
        for (int i = 0; i < boats.size(); ++i) {
            issunk = boats.get(i).isSunk();
            if (issunk == false) {
                lost = false;
                return lost;
            }
        }
        lost = true;
        return lost;
    
    }
    

}
