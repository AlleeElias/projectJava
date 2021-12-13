import java.util.ArrayList;

public class Commands {
    private ArrayList<String> commands;
    private Player p;
    Game g;

    public Commands(Player p,Game g){
        loadCommands();
        this.p=p;
        this.g=g;
    }

    public void loadRooms(){
        ArrayList<ArrayList<Room>> rooms=new ArrayList<ArrayList<Room>>();
        for(int i=0;i<10;i++){
            ArrayList<Room> currentLine=new ArrayList<Room>();
            for(int j=0;j<25;j++){
                switch (g.getFloorplan()[i][j]){
                    case 'G':
                        currentLine.add(new Room(i,j, Room.roomTypes.Gravel));break;
                    case 'T':
                        currentLine.add(new Room(i,j, Room.roomTypes.Tree));break;
                    case 'R':
                        currentLine.add(new Room(i,j, Room.roomTypes.River));break;
                    case 'W':
                        currentLine.add(new Room(i,j, Room.roomTypes.WayTunnel));break;
                    case 'C':
                        currentLine.add(new Room(i,j, Room.roomTypes.Cave));break;
                    case 'M':
                        currentLine.add(new Room(i,j, Room.roomTypes.Mountain));break;
                    case 'V':
                        currentLine.add(new Room(i,j, Room.roomTypes.Villager));break;
                    case 'H':
                        currentLine.add(new Room(i,j, Room.roomTypes.Home));break;
                    case 'D':
                        currentLine.add(new Room(i,j, Room.roomTypes.Dungeon));break;
                    case 'S':
                        currentLine.add(new Room(i,j, Room.roomTypes.Shop));break;
                    case 'E':
                        currentLine.add(new Room(i,j, Room.roomTypes.Exit));break;
                    default:
                        System.out.println("Room error");
                }
            }
            rooms.add(currentLine);
        }
        g.setRooms(rooms);
    }

    public void execute(String command){
        command=command.toLowerCase();
        if(p.getStamina()>0){
        if(commands.contains(command)){
            switch (command){
                case "up":
                    p.movePlayer(command);
                    break;
                case "down":
                    p.movePlayer(command);
                    break;
                case "left":
                    p.movePlayer(command);
                    break;
                case "right":
                    p.movePlayer(command);
                    break;
                case "help":
                    g.printHelp();break;
                case "inventory":
                    p.checkInventory();break;
            }
        }else{System.out.println("Dit commando bestaat niet!");}}
        else{g.setFinished();}
    }

    public String readLocation(){
        String room="";
        char c=g.getFloorplan()[p.getX()][p.getY()];
        switch (c){
            case 'G':
                room="You are standing on gravel.";break;
            case 'T':
                room="You are standing near a tree.";break;
            case 'R':
                room="You are standing in the river.";break;
            case 'W':
                room="You are standing in a passage.";break;
            case 'C':
                room="You are exploring a cave.";break;
            case 'M':
                room="You are climbing a mountain.";break;
            case 'V':
                room="You are speaking with a villager.";break;
            case 'H':
                room="You are in your home.";break;
            case 'D':
                room="You are exploring a dungeon.";break;
            case 'S':
                room="You are trading in a shop.";break;
            case 'E':
                room="You are standing at the exit.";break;
            default:
                room="Room error";
        }
        return room;
    }

    private void loadCommands(){
        commands=new ArrayList<String>();
        commands.add("up");
        commands.add("down");
        commands.add("left");
        commands.add("right");
        commands.add("inventory");
    }
}
