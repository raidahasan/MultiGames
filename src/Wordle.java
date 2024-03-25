import java.util.Scanner;

public class Wordle {

    // user gets 6 tries to guess a 5-letter word
    Board wordleBoard = new Board(6, 5);
    String[] wordList = {"Smart", "Kitty", "Drive", "Jokes", "Apple", "Sunny", "Today", "Check", "Fresh", "Froze"};
    String word = "";
    String guess;

    public Wordle() { }

    public void welcome() {
        System.out.println("{--------------------------------------}");
        System.out.println("    Welcome to Shubhechchha's Wordle!   ");
        System.out.println("{--------------------------------------}");
    }

    public void pickWord(String[] list) {
        int randomInt = (int) (Math.random() * 5);
        word = list[randomInt];
    }
    public void startWordle() {
        Scanner scan = new Scanner(System.in);
        welcome();
        pickWord(wordList);
        System.out.println("Random word chosen!");
        System.out.println("Make your guess: ");
        guess = scan.nextLine();
        boolean check = checkGuess(guess);
    }

    public boolean checkGuess(String guess) {
        if (guess.equals(word)) {
            return true;
        }
        return false;
    }

}
