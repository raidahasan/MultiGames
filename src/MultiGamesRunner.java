public class MultiGamesRunner {
    public static void main (String []args) {
        EscapeLimited esc = new EscapeLimited();
        esc.run();

        Bingo game = new Bingo();
        game.play();
    }
}