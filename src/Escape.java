public class Escape {
    private Space[][] board;
    private int points = 0;
    public Escape(){
        Board b = new Board(8, 8);
        board = b.getBoard();
        PointsPlayer p = new PointsPlayer();
    }

    public void addOrSubPoints(int p){ points+=p; }
}
