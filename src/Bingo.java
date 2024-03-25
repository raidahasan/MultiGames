import java.util.Random;
public class Bingo {
   int[][] bingo = new int[5][5];

   public Bingo() {
       Random random = new Random();
       for (int r = 0; r < bingo.length; r++) {
          for (int c = 0; c < bingo[0].length; c++) {

          }
       }
   }

   public int[][] getBingo() {
       return bingo;
   }

   public void setBingo(int[][] bingo) {
       this.bingo = bingo;
   }
}
