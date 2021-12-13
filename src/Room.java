import java.util.ArrayList;
import java.util.Random;

public class Room {
    private int x;
    private int y;
    private roomTypes type;
    private ArrayList<Item> items;

    public enum roomTypes {
        Gravel,Tree,River,WayTunnel,Cave,Mountain,Villager,Home,Dungeon,Shop,Exit
    }

    public Room(int x,int y,roomTypes type){
        this.items=new ArrayList<Item>();
        this.x=x;
        this.y=y;
        this.type=type;
        fillRoom();
    }
    //fill room with stuff
    private void fillRoom(){
        //check random number
        Random r=new Random();
        int rand=0;
        switch (type){
            case Gravel:
                rand=r.nextInt(10);
                //add random item
                if(rand==5){
                    items.add(new Item(Item.itemTypes.Stamina,"Stamina Potion",2));
                }
                //Always add items to gravel, only for debugging
                items.add(new Item(Item.itemTypes.Stamina,"Stamina Potion",5));
                items.add(new Item(Item.itemTypes.Gold,"MONEY",50));
                break;
            case Tree:
                //Randomise hidden treasure
                rand=r.nextInt(5);
                if(rand==2){
                    items.add(new Item(Item.itemTypes.Gold,"Hidden Treasure",r.nextInt(51)));
                }
                items.add(new Item(Item.itemTypes.Weapon,"Stick",1));break;
            case River:
                //Randomise hidden treasure
                rand=r.nextInt(5);
                if(rand==2){
                    items.add(new Item(Item.itemTypes.Gold,"Hidden Treasure",r.nextInt(51)));
                }break;
        }
    }

    //Take an item out of the room
    public Item takeItem(int i){
        Item taken=items.get(i);
        items.remove(i);
        return taken;
    }
    //check the room contents
    public void checkRoom(){
        if(items.size()>0){
            for (Item i:items
                 ) {
                System.out.println(i.toString());
            }
        }else{
            System.out.println("No items in this room!");
        }
    }

    @Override
    public String toString() {
        return String.format("De kamer %s is op plaats %d, %d.",this.type.toString(),this.x+1,this.y+1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
