public class Board {

    private Space[][] board;
    private int length;
    private int height;

    public Board(int height, int length){
        board = new Space[height][length];
        this.height = height;
        this.length = length;
        for(int i = 0; i<height; i++){
            for(int j = 0; j<length; j++){
                board[i][j]= new Space("_");
            }
        }
    }

    public Board() {
        board = new Space[8][8];
        this.height = 8;
        this.length = 8;
        for(int i = 0; i<height; i++){
            for(int j = 0; j<length; j++){
                board[i][j]= new Space("_");
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<length; j++){
                System.out.print(board[i][j].getSpace());
            }
            System.out.println();
        }
    }

    public Space[][] getBoard(){ return board; }
}
