import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    private char[][] floorplan;
    private ArrayList<ArrayList<Room>> rooms;
    private Player p;
    private Commands c;
    private int x;
    private int y;
    private String command;
    private boolean finished;
    Scanner scan;
    private Room currentRoom;

    public Game(Player p){
        this.rooms=new ArrayList<ArrayList<Room>>();
        scan=new Scanner(System.in);
        loadFloorplan();
        this.p=p;
        this.c=new Commands(this.p,this);
        c.loadRooms();
        startGame();
    }
    private void startGame(){
        readLocation('E');
        p.setPosition(x,y);
        //printLocation();
        //printHelp();
        //printRooms();
        while(!finished){
            this.x=p.getX();this.y=p.getY();
            currentRoom=rooms.get(x).get(y);
            System.out.println(currentRoom.toString());
            System.out.println("What to do?");
            command=scan.nextLine();
            c.execute(command);
            //printLocation();
        }
        System.out.printf("GAME OVER");
    }

    //Confirm exit choice
    public void exit(){
        System.out.println("Are you sure you want to exit? (y/n)");
        String confirm= scan.nextLine().toLowerCase();
        if(confirm.equals("y")){
            System.exit(666);
        }else {
            System.out.println("Returning to game!");
        }
    }

    //Read the location of a chosen character
    private void readLocation(char l){
        // Loop through the arrays until the right character is found
        for(int i=0;i<10;i++){
            for(int j=0;j<25;j++){
                if(floorplan[i][j]==l){
                    this.x=i;this.y=j;
                    //Exit after finding
                    break;
                }
            }
        }
    }
    //Print the help file
    public void printHelp(){

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

    public char[][] getFloorplan() {
        return floorplan;
    }
    public void setFinished(){
        finished=true;
    }
    public void setRooms(ArrayList<ArrayList<Room>> rooms){
        this.rooms=rooms;
    }

    public ArrayList<ArrayList<Room>> getRooms() {
        return rooms;
    }

    //Debug methods
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
    //Print data from rooms
    private void printRooms(){
        for (ArrayList<Room> ar:rooms
             ) {
            for (Room r:ar
                 ) {
                System.out.println(r.toString());
            }
        }
    }
    //Print the location of the player
    private void printLocation(){
        System.out.println(c.readLocation());
        System.out.println(String.format("Coordinaten: %d, %d",p.getX(),p.getY()));
    }
}
