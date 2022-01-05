import java.io.*;
import java.util.ArrayList;
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
    private NPC goodGuy;
    private Enemy badGuy;

    public Game(Player p) {
        this.rooms = new ArrayList<ArrayList<Room>>();
        scan = new Scanner(System.in);
        loadFloorplan();
        this.p = p;
        this.c = new Commands(this.p, this);
        c.loadRooms();
        startGame();
    }

    //Game start and loop
    private void startGame() {
        //Read the location of exit to set start position
        readLocation('E');
        p.setPosition(x, y);
        //Give the player a starting item
        p.addItem(new Item(Item.itemTypes.Stamina,"Starting potion",5,5,5));
        //printLocation();
        printHelp();
        //printRooms();

        //Start a loop to keep running until the player wins
        while (!finished) {
            //Had to try catch here to catch the oob
            try{
                this.x = p.getX();
                this.y = p.getY();
                currentRoom = rooms.get(x).get(y);

            }catch (IndexOutOfBoundsException oob){
                //If it fails, room is unchanged but player is not, thus needing player position to be reset to the current room
                p.setPosition(currentRoom.getX(), currentRoom.getY());
                System.out.println("Can't run that way!");
                p.setStamina(1);
            }
            if(p.getGold()>=500){
                System.out.println("You won the game!");
                System.exit(69);
            }
            //Show the current room everytime the player does something
            System.out.println(currentRoom.toString());
            System.out.println("What to do?");
            //Read the command and then pass it to commands class to be executed
            command = scan.nextLine().trim().toLowerCase();
            c.execute(command);
            //printLocation();
        }
        System.out.printf("GAME OVER");
    }

    //Fight an enemy
    public void fight(){
        //If the room has an enemy
        if(rooms.get(p.getX()).get(p.getY()).getEnem()!=null){
            this.badGuy=rooms.get(p.getX()).get(p.getY()).getEnem();
            badGuy.diceRoll(this.p);
        }else{
            System.out.println("Nobody to fight!");
        }
    }

    //Confirm exit choice
    public void exit() {
        System.out.println("Are you sure you want to exit? (y/n)");
        String confirm = scan.nextLine().toLowerCase();
        if (confirm.equals("y")) {
            System.exit(666);
        } else {
            System.out.println("Returning to game!");
        }
    }

    //Read the location of a chosen character
    private void readLocation(char l) {
        // Loop through the arrays until the right character is found
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 25; j++) {
                if (floorplan[i][j] == l) {
                    this.x = i;
                    this.y = j;
                    //Exit after finding
                    break;
                }
            }
        }
    }

    //Print the help
    public void printHelp() {
        System.out.println(String.format("You have to walk around and look for items.\nWhen you have found enough gold, you can pay to leave.\nIf you run out of stamina,you lose!\nPlease keep in mind that inventories start counting from 0."));
        c.printCommands();
    }

    //Read floorplan file and load the data into floorplan array
    private void loadFloorplan() {
        floorplan = new char[10][25];
        try {
            BufferedReader bf = new BufferedReader(new FileReader("plattegrond.txt"));
            String lijn;
            int i = 0;
            while ((lijn = bf.readLine()) != null) {
                int j = 0;
                try (Scanner rowScanner = new Scanner(lijn)) {
                    for (char c : lijn.toCharArray()
                    ) {
                        floorplan[i][j] = c;
                        j++;
                    }
                }
                i++;
            }
        } catch (IOException fnf) {
            System.out.println(fnf);
        }
    }

    //Debug methods
    //Print data from floorplan
    public void printFloorplan() {
        if (floorplan != null) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 25; j++) {
                    System.out.print(floorplan[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Geen array!");
        }
    }

    //Print data from rooms
    private void printRooms() {
        for (ArrayList<Room> ar : rooms
        ) {
            for (Room r : ar
            ) {
                System.out.println(r.toString());
            }
        }
    }

    //Print the location of the player
    private void printLocation() {
        System.out.println(c.readLocation());
        System.out.println(String.format("Coordinaten: %d, %d", p.getX(), p.getY()));
    }

    //ALL GETTERS AND SETTERS
    public char[][] getFloorplan() {
        return floorplan;
    }

    public void setFinished() {
        finished = true;
    }

    public void setRooms(ArrayList<ArrayList<Room>> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<ArrayList<Room>> getRooms() {
        return rooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
