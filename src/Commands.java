import java.util.ArrayList;

public class Commands {
    private ArrayList<String> commands;
    private Player p;

    public Commands(Player p){
        loadCommands();
        this.p=p;
    }

    public void execute(String command){
        command=command.toLowerCase();
        if(command.contains(command)){
            switch (command){
                case "up":
                    p.movePlayer(command);
                case "down":
                    p.movePlayer(command);
                case "left":
                    p.movePlayer(command);
                case "right":
                    p.movePlayer(command);
            }
        }else{System.out.println("Dit commando bestaat niet!");}
    }

    private void loadCommands(){
        commands=new ArrayList<String>();
        commands.add("up");
        commands.add("down");
        commands.add("left");
        commands.add("right");
    }
}
