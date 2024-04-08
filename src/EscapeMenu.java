import java.util.Scanner;
public class EscapeMenu {
    //make menu - options to play escapeInfinite (NeverEscape) - have a list of top 5 high scores - have option to play escape limited
    //have an arraylist to allow player to choose their special character and one to add to the arraylist with own special character
    Scanner scan = new Scanner(System.in);
    Escape esc = new Escape();
    EscapeLimited escapeLimited = new EscapeLimited();

    public EscapeMenu(){
        runner();
    }
    private String choice = "";
    public void menu(){
        System.out.println("\nWelcome to " + Colors.RED + " ESCAPE " + Colors.RESET);
        System.out.println("1. Classic Escape");
        System.out.println("2. NeverEscape - a run that only ends in death");
        System.out.println("3. View top 5 scores");
        System.out.print("\nEnter your pick (x to quit): ");
        choice = scan.nextLine();
    }

    public void runner(){
        menu();
        while(!choice.equals("x")){
            if(choice.equals("1")){
                escapeLimited.run();
            }else if(choice.equals("2")){
                esc.run();
            }else if(choice.equals("3")){
                for(int i = 0; i<=4; i++){
                    System.out.println(i+1 + ". " + esc.getTop5()[i]);
                }
            }
            menu();
        }
    }
}
