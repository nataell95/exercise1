import java.util.ArrayList;
import java.lang.Math;
public class Boat {
    String type;
    int length;
    String[] coord;
    String symbol;
    ArrayList<Cell> cells = new ArrayList<Cell>();
    ArrayList<String> fullCoordinateList = new ArrayList<String>();
    char tmpFChar = Character.MIN_VALUE;
    char tmpSChar = Character.MIN_VALUE;
    int tmpFInt = Integer.MIN_VALUE;
    int tmpSInt = Integer.MIN_VALUE;
    String mergedCoord = "";
    boolean horizontal = false;
    boolean vertical = false;
    boolean isDestroyed;
    boolean human;
    boolean validLength;
    
    public Boat(String type, int lenght, String coord, String symbol, boolean human) {
        this.type = type;
        this.length = lenght;
        this.symbol = symbol;
        this.isDestroyed = false;
        this.human = human;
        this.getCoordinates(coord,lenght);
        this.getValidLength();
        this.makeCells();

    }

    public ArrayList<Cell> getCellList(){
        return cells;
    }



    
    public void receiveHit() {
        for (int index = 0; index < cells.size(); index++) { 		      
            cells.get(index); 		
        }   		
    }
    
    public String getTypeChar() {
        return this.type;
    }

    public boolean getValidLength() {
        return this.validLength;
    }
    
    public int getLength() {
        return this.length;
    }

    public boolean isSunk() {
        return this.isDestroyed;
    }

    public boolean checkIfIsDestroyed() {
        boolean cellTouched;
        for (int i = 0; i < cells.size(); ++i) {
            cellTouched = cells.get(i).aliveOrTouched();
            if (cellTouched == false) {
                return false;
            }
        }
        this.isDestroyed = true;
        CellStatusToDestroyed();
        return isDestroyed;
    }
    
    private void CellStatusToDestroyed() {
        Cell cell;
        for (int i = 0; i < cells.size(); ++i) {
            cell = cells.get(i);
            cell.boatDestroyed();
        }
    }

    private void getCoordinates(String cord,int lenght) {
        String[] coordinatsList = cord.split(",");
        String[] firstCoordinate = coordinatsList[0].split("");
        char fFirstPosition = firstCoordinate[0].charAt(0);
        int fSecondPosition = Integer.parseInt(firstCoordinate[1]);
        String[] secondCoordinate = coordinatsList[1].split("");
        char sFirstPosition = secondCoordinate[0].charAt(0);
        int sSecondPosition = Integer.parseInt(secondCoordinate[1]);
        int compareChars = Character.compare(fFirstPosition, sFirstPosition);
        
        if ((Math.abs(compareChars) != lenght-1 & compareChars != 0)
                || (Math.abs(fSecondPosition-sSecondPosition) != 0
                        & Math.abs(fSecondPosition-sSecondPosition) != length-1)) {
            this.validLength = false;
        } else {
            this.validLength = true;
        if (compareChars > 0){
            horizontal = true;
            tmpFChar = sFirstPosition;
            tmpSChar = fFirstPosition;
        } else if(compareChars < 0){
            horizontal = true;
            tmpFChar = fFirstPosition;
            tmpSChar = sFirstPosition;
        } else if(fSecondPosition > sSecondPosition){
            vertical = true;
            tmpFInt = sSecondPosition;
            tmpSInt = fSecondPosition;
        } else if (fSecondPosition < sSecondPosition){
            vertical = true;
            tmpFInt = fSecondPosition;
            tmpSInt = sSecondPosition;
        }
        
        if (horizontal == true){
            for (char c = tmpFChar; c <= tmpSChar;++c){
                mergedCoord = Character.toString(c) + Integer.toString(fSecondPosition);
                fullCoordinateList.add(mergedCoord);
            }
        } else if(vertical == true) {
            for (int i = tmpFInt; i <= tmpSInt;++i){
                mergedCoord = Character.toString(fFirstPosition) + Integer.toString(i);
                fullCoordinateList.add(mergedCoord);
            }   
        }
    }
    }

    private void makeCells() {
        for (int i = 0; i < fullCoordinateList.size(); i++) { 		      
            Cell cell = new Cell(fullCoordinateList.get(i),this.symbol,true, this.human);
            cells.add(cell);
        } 
    }


}
