public class Board {

    private Space[][] board;

    public Board(){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                board[i][j]= new Space("_");
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                System.out.print(board[i][j].getSpace());
            }
            System.out.println();
        }
    }

    public Space[][] getBoard(){ return board; }
}
