import java.util.ArrayList;
import java.util.Collections;

class BingoCard {
    private int[][] card;

    public BingoCard() {
        card = new int[5][5];
        generateCard();
    }

    private void generateCard() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int numIndex = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    card[i][j] = 0; // Middle space is free
                } else {
                    card[i][j] = numbers.get(numIndex++);
                }
            }
        }
    }

    public void printCard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(card[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
