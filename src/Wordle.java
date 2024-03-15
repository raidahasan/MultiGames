public class Wordle {
    Board wordleBoard = new Board();
    String[] wordList = {"Smart", "Kitty", "Drive", "Jokes", "Apple", "Sunny", "Today", "Check", "Fresh", "Froze"};
    String word = "";

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
        welcome();
        pickWord(wordList);

    }

}
