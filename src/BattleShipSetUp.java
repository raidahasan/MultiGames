public class BattleShipSetUp extends BattleShip {
    private int boardSize;
    private int numShips;
    public BattleShipSetUp(String player1,String player2, int boardSize, int numShips){
        super(player1, player2);
        this.boardSize = boardSize;
        this.numShips = numShips;
    }
}
