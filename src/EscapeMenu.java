import java.util.Scanner;
public class EscapeMenu {
    Escape esc = new Escape();
    Scanner scan = new Scanner(System.in);

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
        while(!choice.equals("x")){
            menu();
            if(choice.equals("1")){
                EscapeLimited escapeLimited = new EscapeLimited();
                escapeLimited.run();
            }else if(choice.equals("2")){
                esc = new Escape();
                esc.run();
            }else if(choice.equals("3")){
                for(int i = 0; i <= 4; i++){
                    System.out.println(i + 1 + ". " + esc.getTop5()[i]);
                }
            }
        }
    }

}
