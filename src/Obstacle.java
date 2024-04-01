public class Obstacle extends Space {
    private int row;
    private int column;

    public Obstacle(){
        super("X");
    }

    public int getRow(){ return row; }

    public int getColumn() { return column; }

    public void setRow(int row1){ row = row1; }
    public void setColumn(int column1){ column = column1; }

}
