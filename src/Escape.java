public class Escape {
    private Space[][] board;
    PointsPlayer p = new PointsPlayer();
    public Escape(){
        Board b = new Board(8, 10);
        board = b.getBoard();
        p = new PointsPlayer();
    }

    public void run(){
        board[1][1] = p;
        boolean points20 =true;
        while(points20){
            insertObstacles();
            for(int i = 0; i<3; i++){
                printEsc();
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
        random1 = (int)(Math.random()*10);
        random2 = (int)(Math.random()*10);
        random3 = (int)(Math.random()*10);
        random4 = (int)(Math.random()*8);
        random5 = (int)(Math.random()*8);
        random6 = (int)(Math.random()*8);
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

}
