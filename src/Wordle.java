import java.util.Scanner;

public class Wordle {
    // user gets 6 tries to guess a 5-letter word
    private Board wordleBoard = new Board(6, 5);
    private String[] wordList = {"smart", "kitty", "drive", "jokes", "apple", "sunny", "today", "check", "fresh", "froze"};
    private String word = "";
    private String guess;
    private boolean gameOver = false;
    private int tries = 0;

    public Wordle() {
        startWordle();
    }

    public void welcome() {
        System.out.println(Colors.PURPLE + "{--------------------------------------}");
        System.out.println("    Welcome to Shubhechchha's Wordle!   ");
        System.out.println("{--------------------------------------}" + Colors.RESET);
    }

    public void pickWord(String[] list) {
        int randomInt = (int) (Math.random() * 10);
        word = list[randomInt];
    }
    public void startWordle() {
        while (!gameOver) {
            Scanner scan = new Scanner(System.in);
            welcome();
            pickWord(wordList);
            System.out.println("Random word chosen!");
            wordleBoard.printBoard();
            System.out.println();
            System.out.print("Make your guess: ");
            guess = scan.nextLine();
            checkLetter(guess, tries);
            boolean check = checkGuess(guess);
            tries++;
            while (!check && tries <= 5) {
                System.out.print("Try again!: ");
                guess = scan.nextLine();
                checkLetter(guess, tries);
                check = checkGuess(guess);
                tries++;
            }
            if (check) {
                gameOver = true;
                System.out.println();
                System.out.println(Colors.GREEN + "Correct!");
                System.out.println();
                System.out.println("   0         0    ");
                System.out.println();
                System.out.println(" ---------------- ");
                System.out.println(" |||||||||||||||| ");
                System.out.println(" ---------------- " + Colors.RESET);
            } else {
                gameOver = true;
                System.out.println();
                System.out.println(Colors.RED + "You failed Wordle!");
                System.out.println();
                System.out.println("   0         0    ");
                System.out.println("   |         |    ");
                System.out.println("   |         |    ");
                System.out.println("   |         |    ");
                System.out.println();
                System.out.println(" ---------------- " + Colors.RESET);
            }
        }
    }

    public boolean checkGuess(String guess) {
        if (guess.equals(word)) {
            return true;
        }
        return false;
    }

    public void checkLetter(String guess, int tries) {
        for (int i = 0; i < guess.length(); i++) {
            if (guess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                wordleBoard.setBoard(tries, i," " + Colors.GREEN + guess.substring(i, i + 1) + Colors.RESET + " " );
            } else if (word.contains(guess.substring(i, i + 1))) {
                wordleBoard.setBoard(tries, i," " + Colors.YELLOW + guess.substring(i, i + 1) + Colors.RESET + " " );
            } else {
                wordleBoard.setBoard(tries, i, " " + Colors.RED + guess.substring(i, i + 1) + Colors.RESET + " ");
            }
        }
        wordleBoard.printBoard();
    }

}
