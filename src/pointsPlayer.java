import java.util.Scanner;
public class pointsPlayer extends Space{

    private String name = "Player";
    public pointsPlayer(){
        super("");
        askName();
    }

    public void askName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        name = scan.nextLine();
    }

}
