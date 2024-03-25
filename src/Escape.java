import java.util.Scanner;

public class Escape {
    private Space[][] board;
    int row;
    int col;
    PointsPlayer p = new PointsPlayer();
    public Escape(){
        Board b = new Board(5, 25);
        board = b.getBoard();
        p = new PointsPlayer();
    }

    public void run(){
        board[3][1] = p;
        row = 3;
        col = 1;
        boolean points20 =true;
        while(points20){
            insertObstacles();
            for(int i = 0; i<3; i++){
                printEsc();
                playerTurn();
            }
            points20 = false;
        }
    }

    public void insertObstacles(){
        Obstacle X = new Obstacle();
        int random1;
        int random2;
        int random3;
        int random4;
        int random5;
        int random6;
        random1 = (int)(Math.random()*3)+22;
        random2 = (int)(Math.random()*3)+22;
        random3 = (int)(Math.random()*3)+22;
        random4 = (int)(Math.random()*5);
        random5 = (int)(Math.random()*5);
        random6 = (int)(Math.random()*5);
        board[random4][random1] = X;
        board[random5][random2] = X;
        board[random6][random3] = X;

    }

    public void printEsc(){
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                System.out.print(board[i][j].getSpace());
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public void playerTurn(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your move(W, A, S, or D)");
        String WASD = scan.nextLine();
        WASD = WASD.toUpperCase();
        if(WASD.equals("A")){
            if(col==0){
                System.out.println("Out of bounds");
            }else{
                board[row][col] = new Space("_");
                col--;
                board[row][col] = p;
            }
        }else if(WASD.equals("D")){
            if(col==24){
                System.out.println("Out of bounds");
            }else{
                board[row][col] = new Space("_");
                col++;
                board[row][col] = p;
            }
        }else if(WASD.equals("W")){
            if(row==0){
               System.out.println("Out of bounds");
            }else{
                board[row][col] = new Space("_");
                row--;
                board[row][col] = p;
            }
        }else if(WASD.equals("S")){
            if(row==4){
                System.out.println("Out of bounds");
            }else{
                board[row][col] = new Space("_");
                row++;
                board[row][col] = p;
            }
        }else{
            System.out.println("Invalid input");
        }
    }
}
