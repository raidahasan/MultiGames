import java.util.Scanner;

public class Escape {
    private Space[][] board;
    Obstacle X = new Obstacle();
    Obstacle Y = new Obstacle();
    Obstacle Z = new Obstacle();
    Obstacle A = new Obstacle();
    Obstacle B = new Obstacle();
    private boolean hit = false;
    int playerInput =0;
    int row;
    int col;
    PointsPlayer p = new PointsPlayer();
    public Escape(){
        Board b = new Board(5, 25);
        board = b.getBoard();
        p = new PointsPlayer();
        hit = false;
    }

    public void run(){
        board[3][1] = p;
        row = 3;
        col = 1;
        insertObstacle(X);
        while(!hit) {
            printEsc();
            playerTurn();
        }
        printEsc();
    }

    public void insertObstacle(Obstacle obstacle){
        obstacle.setColumn(24);  //((int)(Math.random()*3)+22)
        obstacle.setRow((int)(Math.random()*5));
        board[obstacle.getRow()][obstacle.getColumn()] = obstacle;

    }

    public void updateObstacle(Obstacle obstacle){
        board[obstacle.getRow()][obstacle.getColumn()] = new Space("_");
        if(obstacle.getColumn()!=0){
            obstacle.setColumn(obstacle.getColumn()-1);
            board[obstacle.getRow()][obstacle.getColumn()] = obstacle;
        }else{
            board[obstacle.getRow()][obstacle.getColumn()] = new Space("_");
            insertObstacle(obstacle);
        }
    }
    public void updateAllObstacles(){
        updateObstacle(X);
        updateObstacle(Y);
        updateObstacle(Z);
        updateObstacle(A);
        updateObstacle(B);
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

    public boolean hitObstacle(){
        if(board[row][col] instanceof Obstacle){
            System.out.println("You died");
            return true;
        }
        return false;
    }
    public void playerTurn(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your move (W for up, S for down)");
        String WASD = scan.nextLine();
        WASD = WASD.toUpperCase();
        playerInput++;
        if(WASD.equals("W")){
            if(row==0){
               System.out.println("Out of bounds");
            }else{
                board[row][col] = new Space("_");
                row--;
                hit = hitObstacle();
                board[row][col] = p;
            }
        }else if(WASD.equals("S")){
            if(row==4){
                System.out.println("Out of bounds");
            }else{
                board[row][col] = new Space("_");
                row++;
                hit = hitObstacle();
                board[row][col] = p;
            }
        }else{
            System.out.println("Stayed still");
            hit = hitObstacle();
        }
        if(playerInput==3){
            insertObstacle(Y);
        }
        if(playerInput==5){
            insertObstacle(Z);
        }
        if(playerInput==7){
            insertObstacle(A);
        }
        if(playerInput==9){
            insertObstacle(B);
        }
        if(playerInput<3){
            updateObstacle(X);
        }else if(playerInput<5){
            updateObstacle(X);
            updateObstacle(Y);
        }else if(playerInput<7){
            updateObstacle(X);
            updateObstacle(Y);
            updateObstacle(Z);
        }else if(playerInput<9){
            updateObstacle(X);
            updateObstacle(Y);
            updateObstacle(Z);
            updateObstacle(A);
        }else{
            updateAllObstacles();
        }

    }
}
