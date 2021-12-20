import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    private ArrayList<String> commands;
    private Player p;
    private Game g;
    private Scanner s;

    public Commands(Player p, Game g) {
        loadCommands();
        this.p = p;
        this.g = g;
        this.s = new Scanner(System.in);
    }

    public void loadRooms() {
        ArrayList<ArrayList<Room>> rooms = new ArrayList<ArrayList<Room>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Room> currentLine = new ArrayList<Room>();
            for (int j = 0; j < 25; j++) {
                switch (g.getFloorplan()[i][j]) {
                    case 'G':
                        currentLine.add(new Room(i, j, Room.roomTypes.Gravel));
                        break;
                    case 'T':
                        currentLine.add(new Room(i, j, Room.roomTypes.Tree));
                        break;
                    case 'R':
                        currentLine.add(new Room(i, j, Room.roomTypes.River));
                        break;
                    case 'W':
                        currentLine.add(new Room(i, j, Room.roomTypes.WayTunnel));
                        break;
                    case 'C':
                        currentLine.add(new Room(i, j, Room.roomTypes.Cave));
                        break;
                    case 'M':
                        currentLine.add(new Room(i, j, Room.roomTypes.Mountain));
                        break;
                    case 'V':
                        currentLine.add(new Room(i, j, Room.roomTypes.Villager));
                        break;
                    case 'H':
                        currentLine.add(new Room(i, j, Room.roomTypes.Home));
                        break;
                    case 'D':
                        currentLine.add(new Room(i, j, Room.roomTypes.Dungeon));
                        break;
                    case 'S':
                        currentLine.add(new Room(i, j, Room.roomTypes.Shop));
                        break;
                    case 'E':
                        currentLine.add(new Room(i, j, Room.roomTypes.Exit));
                        break;
                    default:
                        System.out.println("Room error");
                }
            }
            rooms.add(currentLine);
        }
        g.setRooms(rooms);
    }

    public void execute(String command) {
        command = command.toLowerCase();
        if (p.getStamina() > 0) {
            if (commands.contains(command)) {
                switch (command) {
                    case "run":
                        move();
                        break;
                    case "help":
                        g.printHelp();
                        break;
                    case "inventory":
                        p.checkInventory();
                        break;
                    case "exit":
                        g.exit();
                        break;
                    case "look":
                        g.getRooms().get(p.getX()).get(p.getY()).checkRoom();
                        break;
                    case "take":
                        takeItem();
                        break;
                    case "use":
                        useItem();
                        break;
                    case "map":
                        g.printFloorplan();
                        break;
                    case "fight":
                        g.fight();
                        break;
                    case "buy":
                        buyItem();
                        break;
                    case "steal":
                        stealItem();
                        break;
                }
            } else {
                System.out.println("Dit commando bestaat niet!");
            }
        } else {
            g.setFinished();
        }
    }
    //Buy an item
    public void buyItem(){

    }
    //Steal an item
    public void stealItem(){

    }

    //Choice of which item to take
    private void takeItem() {
        System.out.println("Welk item wil u nemen?");
        String choice = s.nextLine();
        p.addItem(g.getRooms().get(p.getX()).get(p.getY()).takeItem(choice));
    }

    //Choices after choosing to run
    private void move() {
        try {
            System.out.println("Where do you want to run? (up, down, left or right)");
            String command = s.nextLine().trim().toLowerCase();
            p.movePlayer(command);
        } catch (ArrayIndexOutOfBoundsException oob) {
            System.out.println("Can't move that way!");
        }
    }

    private void useItem() {
        System.out.println("Which item would you like to use?");
        p.checkInventory();
        String choice = s.nextLine();
        p.checkItem(choice);
    }

    public void printCommands() {
        System.out.println("Possible commands:");
        for (String s : commands
        ) {
            System.out.println(s);
        }
    }

    //Not used anymore
    public String readLocation() {
        String room = "";
        char c = g.getFloorplan()[p.getX()][p.getY()];
        switch (c) {
            case 'G':
                room = "You are standing on gravel.";
                break;
            case 'T':
                room = "You are standing near a tree.";
                break;
            case 'R':
                room = "You are standing in the river.";
                break;
            case 'W':
                room = "You are standing in a passage.";
                break;
            case 'C':
                room = "You are exploring a cave.";
                break;
            case 'M':
                room = "You are climbing a mountain.";
                break;
            case 'V':
                room = "You are speaking with a villager.";
                break;
            case 'H':
                room = "You are in your home.";
                break;
            case 'D':
                room = "You are exploring a dungeon.";
                break;
            case 'S':
                room = "You are trading in a shop.";
                break;
            case 'E':
                room = "You are standing at the exit.";
                break;
            default:
                room = "Room error";
        }
        return room;
    }

    //add commands to the list
    private void loadCommands() {
        commands = new ArrayList<String>();
        commands.add("run");
        commands.add("inventory");
        commands.add("use");
        commands.add("exit");
        commands.add("look");
        commands.add("take");
        commands.add("help");
        commands.add("map");
        commands.add("fight");
        commands.add("buy");
        commands.add("steal");
    }
}
