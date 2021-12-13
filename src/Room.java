import java.util.ArrayList;

public class Room {
    private int x;
    private int y;
    private roomTypes type;
    private ArrayList<Item> items;

    public Room(int x,int y,roomTypes type){
        this.x=x;
        this.y=y;
        this.type=type;
        fillRoom();
    }
    private void fillRoom(){
        switch (type){
            case Gravel:
                items=new ArrayList<Item>();
        }
    }
   public enum roomTypes {
        Gravel,Tree,River,WayTunnel,Cave,Mountain,Villager,Home,Dungeon,Shop,Exit
    }

    @Override
    public String toString() {
        return String.format("De kamer %s is op plaats %d, %d.",this.type.toString(),this.x+1,this.y+1);
    }
}
