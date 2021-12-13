import java.io.*;
import java.util.Scanner;

public class Game {
    private static char[][] floorplan;

    static void loadFloorplan(){
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

    static void printFloorplan(){
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
