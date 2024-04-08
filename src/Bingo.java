import java.util.ArrayList;
import java.util.Scanner;


public class Bingo {
    private BingoCard card;
    private ArrayList<Integer> calledNumbers;


    public Bingo() {
        card = new BingoCard();
        calledNumbers = new ArrayList<>();
    }


    public void play() {
        System.out.println("Welcome to Bingo!");
        card.printCard();
        playRound();
    }


    private void playRound() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Let's play a round! Here are your 5 random numbers:");


        // Generate and display 5 random numbers
        for (int i = 0; i < 5; i++) {
            int randomNumber = generateRandomNumber();
            calledNumbers.add(randomNumber);
            System.out.println("Number " + (i + 1) + ": " + randomNumber);
        }


        // Check if the user got bingo
        System.out.println("Did you get Bingo? (Y/N)");
        String input = scanner.next();
        if (input.equalsIgnoreCase("Y")) {
            checkBingo();
        } else {
            System.out.println("Okay, let's continue!");
            playRound();
        }
        System.out.println();
    }


    private int generateRandomNumber() {
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * 75) + 1;
        } while (calledNumbers.contains(randomNumber));
        return randomNumber;
    }


    private void checkBingo() {
        // Check if the card contains all the called numbers
        for (int number : calledNumbers) {
            if (!card.containsNumber(number)) {
                System.out.println("Sorry, you don't have Bingo yet!");
                return;
            }
        }
        System.out.println("Congratulations! You got Bingo!");
    }
}

