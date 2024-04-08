import java.util.Scanner;

public class MultiGamesRunner {
    public static void main (String []args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(Colors.BLUE + "{ /////////////////////////  }");
        System.out.println("{  WELCOME TO SARS ARCADE!! }");
        System.out.println("{ /////////////////////////  }" + Colors.RESET);
        System.out.println();
        mainMenu();
        System.out.println();
        System.out.print("Which game would you like to play? (x to quit): ");
        String option = scan.nextLine();
        System.out.println();

        while (!option.equals("x")) {
            if (option.equals("1")) {
                EscapeLimited esc = new EscapeLimited();
                esc.run();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
            } else if (option.equals("2")) {
                Bingo game = new Bingo();
                game.play();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
            } else if (option.equals("3")) {
                Wordle myWordle = new Wordle();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
            }else if(option.equals("x")){
                break;
            }else{
                option = scan.nextLine();
            }
        }
    }

    public static void mainMenu() {
        System.out.println("Arcade Games:");
        System.out.println("1. Escape Limited");
        System.out.println("2. Bingo");
        System.out.println("3. Wordle");
        System.out.println("4. Battle Ship");
    }
}