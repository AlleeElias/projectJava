public class Room {
    private int x;
    private int y;
    private roomTypes type;

    public Room(int x,int y,roomTypes type){
        this.x=x;
        this.y=y;
        this.type=type;
    }
   public enum roomTypes {
        Gravel,Tree,River,WayTunnel,Cave,Mountain,Villager,Home,Dungeon,Shop,Exit
    }

    @Override
    public String toString() {
        return String.format("De kamer %s is op plaats %d, %d.",this.type.toString(),this.x,this.y);
    }
}
