import java.util.Scanner;

public class BattleshipGame extends Board {
    private Board battleShipBoard;
    private Board battleShipBoardAns;
    private int playerHit;
    private int opponentHit;
    private int shipCounter;
    private Scanner scan;

    public BattleshipGame() {
        battleShipBoard  = new Board(8, 8);
        battleShipBoardAns = new Board(8,8);
        scan = new Scanner(System.in);
    }

    public void startGame() {
        initializeAnswerBoard();
        battleShipBoard.printBoard("b");
        playGame();
    }
    public void initializeAnswerBoard() {
        for (int r = 0; r < 3; r++) {
            battleShipBoardAns.setBoard(r, 5, " O ");
        }
        for (int r = 1; r < 6; r++) {
            battleShipBoardAns.setBoard(r, 1, " O ");
        }
        for (int c = 0; c < 4; c++) {
            battleShipBoardAns.setBoard(7, c, " O ");
        }
        for (int c = 5; c < 8; c++) {
            battleShipBoardAns.setBoard(6, c, " O ");
        }
        for (int c = 6; c < 8; c++) {
            battleShipBoardAns.setBoard(3, c, " O ");
        }
    }

    public void playGame() {
        while (shipCounter < 17) {
            System.out.println(Colors.YELLOW + "Player's Attack" + Colors.RESET);
            boolean play = playerAttack();
            battleShipBoard.printBoard("b");
            if (play) {
                playGame();
            } else {
                System.out.println(Colors.PURPLE + "Opponent's Attack" + Colors.RESET);
                opponentAttack();
                battleShipBoard.printBoard("b");
            }
            playGame();
        }
        battleShipBoard.printBoard("b");
        System.out.println(Colors.YELLOW + "Player Score: " + Colors.RESET + playerHit);
        System.out.println(Colors.PURPLE + "Opponent Score: " + Colors.RESET + opponentHit);
        if (playerHit > opponentHit) {
            System.out.println(Colors.GREEN + "Player Won!!" + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "Opponent Won :(" + Colors.RESET);
        }
    }

    public boolean opponentAttack() {
        int r = (int) (Math.random() * 7);
        int c = (int) (Math.random() * 7);
        if (battleShipBoard.getBoardSpace(r, c).getSpace().equals(" O ") || battleShipBoard.getBoardSpace(r, c).getSpace().equals(" X ")) {
            opponentAttack();
        } else {
            if (battleShipBoardAns.getBoardSpace(r, c).getSpace().equals(" O ")) {
                battleShipBoard.setBoard(r, c, " O ");
                opponentHit++;
                shipCounter++;
                System.out.println("Opponent Hit a Ship!!");
                battleShipBoard.printBoard("b");
                opponentAttack();
            } else {
                    battleShipBoard.setBoard(r, c, " X ");
                    System.out.println("Opponent missed player's turn");
                    return false;
            }
        }
        return false;
    }

    public boolean playerAttack() {
        System.out.print("Which row (0-7): ");
        int r = scan.nextInt();
        scan.nextLine();
        System.out.print("Which column (0-7): ");
        int c = scan.nextInt();
        scan.nextLine();
        if (battleShipBoard.getBoardSpace(r, c).getSpace().equals(" O ") || battleShipBoard.getBoardSpace(r, c).getSpace().equals(" X ")) {
            return true;
        } else {
            if (battleShipBoardAns.getBoardSpace(r, c).getSpace().equals(" O ")) {
                battleShipBoard.setBoard(r, c, " O ");
                playerHit++;
                shipCounter++;
                System.out.println("Player Hit a Ship!!");
                return true;
            } else {
                battleShipBoard.setBoard(r, c, " X ");
                System.out.println("Player missed opponent's turn");
                return false;
            }
        }
    }
}

