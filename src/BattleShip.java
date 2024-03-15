import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {
    private String player1;
    private String player2;
    private int score1 = 0;
    private int score2 = 0;
    private boolean hit = false;
    private boolean missed = false;
    private ArrayList<String> positions;
    private String position;

    public BattleShip(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
        positions = new ArrayList<>();
    }

    public ArrayList<String> getPositions() {
        return positions;
    }

    public String getPosition(){
        return position;
    }

    public void askPosition(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter move (LETTER#): ");
        position  = scan.nextLine();
    }

    public void placeShip(String position) {
        positions.add(position);
    }

    public boolean occupiesPosition(String position) {
        return positions.contains(position);
    }



    public void placeShip(Ship ship, String position) {
        ship.placeShip(position);
        ships.add(ship);
    }

    public boolean checkHit(String position) {
        for (Ship ship : ships) {
            if (ship.occupiesPosition(position)) {
                ship.getPositions().remove(position);
                return true;
            }
        }
        return false;
    }
