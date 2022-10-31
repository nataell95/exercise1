public class Cell {
    private String value;
    private String coord;
    private String symbol;
    private boolean isboat;
    private boolean isTouched;
    private boolean human;
    
    public Cell(String coord, String symbol, boolean isboat, boolean human) {
        this.value = " ";
        this.coord = coord;
        this.symbol = symbol;
        this.isboat = isboat;
        this.isTouched = false;
        this.human = human;
        refreshSymbol();
    }

    private void refreshSymbol() {
        if (this.human == true & this.isboat == true) {
            this.value = this.symbol;
        }
        if (this.human == false & this.isboat == true) {
            this.value = " ";
        }
    }
    
    public String getValue() {
        return this.value;
    }

    public boolean getBolBoat() {
        return this.isboat;
    }
    
    public String getCoord()
    {
        return this.coord;
    }

    public boolean alreadyShoot() {
        return this.isTouched;
    }

    public void isTouched() {
        this.isTouched = true;
        if (this.isboat == true) {
            this.value = "X";
        } else {
            this.value = "0";
        }
    }

    public boolean aliveOrTouched()
    {
        return this.isTouched;
    }

    public void boatDestroyed() {
        this.value = this.symbol;
    }

}
