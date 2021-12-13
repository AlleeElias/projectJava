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
        String room="non";
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
