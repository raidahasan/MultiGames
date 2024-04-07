public class MultiGamesRunner {
    public static void main (String []args) {
        Escape esc = new Escape();
        esc.run();

        Bingo game = new Bingo();
        game.play();
    }
}