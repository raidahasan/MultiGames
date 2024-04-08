import java.util.Scanner;

public class MultiGamesRunner {
    public MultiGamesRunner(){
        runnerFinal();
    }
    public static void runnerFinal () {
        Scanner scan = new Scanner(System.in);
        System.out.println(Colors.RED + "{ -------------------------  }" + Colors.RESET);
        System.out.println(Colors.BLUE + "   WELCOME TO " + Colors.RED + "SARS ARCADE!! " + Colors.RESET);
        System.out.println(Colors.BLUE + "{ -------------------------  }" + Colors.RESET);
        System.out.println();
        mainMenu();
        System.out.println();
        System.out.print("Which game would you like to play? (x to quit): ");
        String option = scan.nextLine();
        System.out.println();

        while (!option.equals("x")) {
            if (option.equals("1")) {
                EscapeMenu esc = new EscapeMenu();
                esc.runner();
                System.out.println();
                mainMenu();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
                System.out.println();
            } else if (option.equals("2")) {
                Bingo game = new Bingo();
                game.play();
                System.out.println();
                mainMenu();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
                System.out.println();
            } else if (option.equals("3")) {
                Wordle myWordle = new Wordle();
                System.out.println();
                mainMenu();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
                System.out.println();
            } else if (option.equals("4")) {
                BattleshipGame game = new BattleshipGame();
                game.startGame();
                System.out.println();
                mainMenu();
                System.out.println();
                System.out.print("Which game would you like to play next? (x to quit): ");
                option = scan.nextLine();
                System.out.println();
            }else{
                System.out.print("Invalid option, try again: ");
                option = scan.nextLine();
            }
        }
        System.out.println(Colors.RED + "THANK YOU FOR VISITING SARS ARCADE!" + Colors.RESET);
        System.out.println(Colors.BLUE + "Visit again!" + Colors.RESET);
    }

    public static void mainMenu() {
        System.out.println(Colors.YELLOW + "Arcade Games:");
        System.out.println("1. Escape Limited");
        System.out.println("2. Bingo");
        System.out.println("3. Wordle");
        System.out.println("4. Battle Ship" + Colors.RESET);
    }
}