public class EscapeLimited extends Escape{

    public EscapeLimited(){
    }

    @Override
    public void run(){
        insertObstacle(X);
        while(!isHit()&&getPoints()<=100) {
            printEsc();
            playerTurn();
        }
        printEsc();
        if(isHit()){
            System.out.println("Hit obstacle - you did not escape :(");
        }else{
            System.out.println("You escaped!!");
        }
//        try{
//            Thread.sleep(2000);
//        }catch(Exception e){
//            System.out.println("Error");
//        }
    }
}
