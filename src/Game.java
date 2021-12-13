import java.io.*;
import java.util.Scanner;

public class Game {
    private Player p;
    private int x;
    private int y;

    public Game(Player p){
        loadFloorplan();
        this.p=p;
        readLocation('E');
        p.setPosition(x,y);
    }
    public void loadGame(){

    }
    public void printLocation(){
        System.out.println(String.format("Coordinaten: %d, %d",x,y));
    }
    private void readLocation(char l){
        for(int i=0;i<10;i++){
            for(int j=0;j<25;j++){
                if(floorplan[i][j]==l){
                    this.x=i;this.y=j;
                    break;
                }
            }
        }
    }

    private char[][] floorplan;

    private enum rooms {
        Gravel,Tree,River,WayTunnel,Cave,Mountain,Villager,Home,Dungeon,Shop,Exit
    }

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
    public void printFloorplan(){
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
}
