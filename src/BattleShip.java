import java.util.ArrayList;
import java.util.Random;

public class BattleShip {
    private String player1;
    private String player2;
    private int score1 = 0;
    private int score2 = 0;
    private boolean hit = false;
    private boolean missed = false;
    private ArrayList<String> positions;

    public BattleShip(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
        positions = new ArrayList<>();
    }

    public ArrayList<String> getPositions() {
        return positions;
    }


    public void placeShip(int x, String)
}
