public class PointsPlayer extends Space{
    int posRow;
    int posCol;
    int points = 0;
    private String name = "Player";
    public PointsPlayer(){
        super("P");
    }
    public int getPoints(){ return points; }

    public void addOrSubPoints(int p){ points+=p; }
}
