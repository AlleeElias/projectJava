import java.io.*;
import java.util.Scanner;

public class Game {
    private char[][] floorplan;
    private Player p;
    private Commands c;
    private int x;
    private int y;
    private String command;
    private boolean finished;
    Scanner scan;

    public Game(Player p){
        scan=new Scanner(System.in);
        loadFloorplan();
        this.p=p;
        this.c=new Commands(this.p,this);
        startGame();
    }
    private void startGame(){
        readLocation('E');
        p.setPosition(x,y);
        printLocation();
        printHelp();
        while(!finished){
            System.out.println("What to do?");
            command=scan.nextLine();
            c.execute(command);
            printLocation();
        }
        System.out.printf("GAME OVER");
    }
    //Print the location of the player
    private void printLocation(){
        System.out.println(c.readLocation());
        System.out.println(String.format("Coordinaten: %d, %d",p.getX(),p.getY()));
    }

    //Read the location of a chosen character
    private void readLocation(char l){
        // Loop through the arrays until the right character is found
        for(int i=0;i<10;i++){
            for(int j=0;j<25;j++){
                if(floorplan[i][j]==l){
                    this.x=i;this.y=j;
                    break;
                }
            }
        }
    }
    //Print the help file
    public void printHelp(){

    }

    private enum rooms {
        Gravel,Tree,River,WayTunnel,Cave,Mountain,Villager,Home,Dungeon,Shop,Exit
    }
    //Read floorplan file and load the data into floorplan array
    private void loadFloorplan(){
        floorplan=new char[10][25];
        try{
            BufferedReader bf=new BufferedReader(new FileReader("plattegrond.txt"));
            String lijn;
            int i=0;
            while ((lijn=bf.readLine()) !=null){
                int j=0;
                try(Scanner rowScanner=new Scanner(lijn)){
                    for (char c:lijn.toCharArray()
                         ) {
                        floorplan[i][j]=c;
                        j++;
                    }
                }
                i++;
            }
        }catch(IOException fnf){
            System.out.println(fnf);
        }
    }
    //Print data from floorplan
    private void printFloorplan(){
        if(floorplan!=null){
            for(int i=0;i<10;i++){
                for(int j=0;j<25;j++){
                    System.out.print(floorplan[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println("Geen array!");
        }
    }

    public char[][] getFloorplan() {
        return floorplan;
    }
    public void setFinished(){
        finished=true;
    }
}
