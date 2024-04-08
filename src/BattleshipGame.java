import java.util.Scanner;

public class BattleshipGame extends Board {
    private Ship[] ships;
    private final int NUM_SHIPS = 5;

    private int playerHits;
    private int opponentHits;
    private int playerPoints;
    private int opponentPoints;
    private Scanner scanner;

    public BattleshipGame() {
        super(8, 8); // Assuming a standard 8x8 board for Battleship
        ships = new Ship[NUM_SHIPS];
        playerHits = 0;
        opponentHits = 0;
        playerPoints = 0;
        opponentPoints = 0;
        initializeShips();
        placeShipsRandomly();
        scanner = new Scanner(System.in);
    }

    private void initializeShips() {
        // Define the ships with their names and sizes
        ships[0] = new Ship("Carrier", 5);
        ships[1] = new Ship("Battleship", 4);
        ships[2] = new Ship("Cruiser", 3);
        ships[3] = new Ship("Submarine", 3);
        ships[4] = new Ship("Destroyer", 2);
    }

    private void placeShipsRandomly() {
        for (Ship ship : ships) {
            boolean placed = false;
            while (!placed) {
                int row = (int) (Math.random() * getHeight());
                int col = (int) (Math.random() * getLength());
                boolean horizontal = Math.random() < 0.5;

                if (canPlaceShip(ship, row, col, horizontal)) {
                    placeShip(ship, row, col, horizontal);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlaceShip(Ship ship, int row, int col, boolean horizontal) {
        if (horizontal) {
            if (col + ship.getSize() > getLength()) return false;
            for (int c = col; c < col + ship.getSize(); c++) {
                if (!getBoard()[row][c].getSpace().equals(" _ ")) return false;
            }
        } else {
            if (row + ship.getSize() > getHeight()) return false;
            for (int r = row; r < row + ship.getSize(); r++) {
                if (!getBoard()[r][col].getSpace().equals(" _ ")) return false;
            }
        }
        return true;
    }

    private void placeShip(Ship ship, int row, int col, boolean horizontal) {
        if (horizontal) {
            for (int c = col; c < col + ship.getSize(); c++) {
                getBoard()[row][c].setSpace(" " + ship.getName().charAt(0) + " ");
            }
        } else {
            for (int r = row; r < row + ship.getSize(); r++) {
                getBoard()[r][col].setSpace(" " + ship.getName().charAt(0) + " ");
            }
        }
    }

    public void printBoard(boolean showShips) {
        Space[][] board = getBoard();
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (!showShips && !board[i][j].getSpace().equals(" _ ") && !board[i][j].getSpace().equals(" O ") && !board[i][j].getSpace().equals(" X ")) {
                    System.out.print(" _ ");
                } else {
                    System.out.print(board[i][j].getSpace());
                }
            }
            System.out.println();
        }
    }

    public boolean attack(int row, int col, boolean playerTurn) {
        if (getBoard()[row][col].getSpace().equals(" O ") || getBoard()[row][col].getSpace().equals(" X ")) {
            System.out.println("Already hit this spot!");
            return false; // Already hit
        } else {
            if (getBoard()[row][col].getSpace().equals(" _ ")) {
                getBoard()[row][col].setSpace(" X ");
                return false; // Miss
            } else {
                char shipInitial = getBoard()[row][col].getSpace().charAt(1);
                getBoard()[row][col].setSpace(" O ");
                if (playerTurn) {
                    playerHits++;
                    if (isShipSunk(shipInitial, true)) {
                        playerPoints++;
                        markSunkShip(shipInitial, true);
                        System.out.println("Player sunk a ship!");
                    }
                } else {
                    opponentHits++;
                    if (isShipSunk(shipInitial, false)) {
                        opponentPoints++;
                        markSunkShip(shipInitial, false);
                        System.out.println("Opponent sunk a ship!");
                    }
                }
                return true; // Hit
            }
        }
    }

    private boolean isShipSunk(char shipInitial, boolean playerTurn) {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (getBoard()[i][j].getSpace().charAt(1) == shipInitial && !getBoard()[i][j].getSpace().equals(" O ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void markSunkShip(char shipInitial, boolean playerTurn) {
        char mark = playerTurn ? 'P' : 'C';
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (getBoard()[i][j].getSpace().charAt(1) == shipInitial) {
                    getBoard()[i][j].setSpace(" " + mark + " ");
                }
            }
        }
    }

    private boolean isGameOver() {
        return playerPoints == NUM_SHIPS || opponentPoints == NUM_SHIPS;
    }

    public void startGame() {
        System.out.println("Battleship game started!");
        printBoard(false); // Print the player's board without showing ships

        while (!isGameOver()) {
            playerTurn();
            printBoard(false); // Reprint the board after player's turn
            if (isGameOver()) break; // Check if player has won after their turn
            opponentTurn();
            printBoard(false); // Reprint the board after opponent's turn
        }

        if (playerPoints > opponentPoints) {
                    System.out.println("Player wins!");
        } else if (playerPoints < opponentPoints) {
            System.out.println("Opponent wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    private void playerTurn() {
        System.out.println("Player's turn:");
        int row, col;
        do {
            System.out.print("Enter row (0-7): ");
            row = scanner.nextInt();
            System.out.print("Enter column (0-7): ");
            col = scanner.nextInt();
        } while (!isValidAttack(row, col));

        boolean isHit = attack(row, col, true);
        if (isHit) {
            System.out.println("Player hit a ship!");
        } else {
            System.out.println("Player missed!");
        }
    }

    private void opponentTurn() {
        System.out.println("Opponent's turn:");
        int row, col;
        do {
            row = (int) (Math.random() * getHeight());
            col = (int) (Math.random() * getLength());
        } while (!isValidAttack(row, col));

        boolean isHit = attack(row, col, false);
        if (isHit) {
            System.out.println("Opponent hit a ship!");
        } else {
            System.out.println("Opponent missed!");
        }
    }

    private boolean isValidAttack(int row, int col) {
        return row >= 0 && row < getHeight() && col >= 0 && col < getLength() &&
                getBoard()[row][col].getSpace().equals(" _ ");
    }
}

