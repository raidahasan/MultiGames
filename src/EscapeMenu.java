import java.util.Scanner;
public class EscapeMenu {
    //make menu - options to play escapeInfinite (NeverEscape) - have a list of top 5 high scores - have option to play escape limited
    //have an arraylist to allow player to choose their special character and one to add to the arraylist with own special character

    private String choice = "";
    public void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to " + Colors.RED + " ESCAPE " + Colors.RESET);
        System.out.println("1. Classic Escape");
        System.out.println("2. NeverEscape - a run that only ends in death");
        System.out.println("3. Pick player character ");
        System.out.println("4. View top 5 scores");
        System.out.println("\nEnter your pick: (Anything else to quit)");
        choice = scan.nextLine();
    }



}
