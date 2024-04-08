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
                board[i][j]= new Space("  ");
            }
        }
    }

    public Space[][] getBoard(){ return board; }

    public int getLength(){
        return length;
    }

    public int getHeight(){
        return height;
    }

    public void setBoard(int row, int col, String space) {
        board[row][col] = new Space(space);
    }

    public Board() {
        board = new Space[8][8];
        this.height = 8;
        this.length = 8;
        for(int i = 0; i<height; i++){
            for(int j = 0; j<length; j++){
                board[i][j]= new Space("  ");
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

    public void printBoard(String b){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<length; j++) {
                if (board[i][j].getSpace().equals(" O ")) {
                    System.out.print(Colors.GREEN + board[i][j].getSpace() + Colors.RESET);
                } else if (board[i][j].getSpace().equals(" X ")) {
                    System.out.print(Colors.RED + board[i][j].getSpace() + Colors.RESET);
                } else {
                    System.out.print(Colors.BLUE + board[i][j].getSpace() + Colors.RESET);
                }
            }
            System.out.println();
        }
    }

    public Space getBoardSpace(int r, int c) {
        return board[r][c];
    }
}