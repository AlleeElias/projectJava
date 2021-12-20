import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Room {
    private int x;
    private int y;
    private roomTypes type;
    private HashMap<Item, Integer> items;
    private NPC trader;
    private Enemy enem;

    public enum roomTypes {
        Gravel, Tree, River, WayTunnel, Cave, Mountain, Villager, Home, Dungeon, Shop, Exit
    }

    public Room(int x, int y, roomTypes type) {
        this.items = new HashMap<Item, Integer>();
        this.x = x;
        this.y = y;
        this.type = type;
        fillRoom();
    }

    //fill room with stuff
    private void fillRoom() {
        //check random number
        Random r = new Random();
        int rand = 0;
        switch (type) {
            case Gravel:
                rand = r.nextInt(10);
                //add random item
                if (rand == 5) {
                    putItem(new Item(Item.itemTypes.Stamina, "Stamina Potion", 2, 25));
                }
                //Always add items to gravel, only for debugging
                putItem(new Item(Item.itemTypes.Stamina, "Stamina Potion", 5, 50));
                putItem(new Item(Item.itemTypes.Gold, "MONEY", 50, 50));
                break;
            case Tree:
                //Randomise hidden treasure
                rand = r.nextInt(5);
                if (rand == 2) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", r.nextInt(51), 0));
                }
                putItem(new Item(Item.itemTypes.Weapon, "Stick", 1, 5));
                break;
            case River:
                //Randomise hidden treasure
                rand = r.nextInt(5);
                if (rand == 2) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", r.nextInt(51), 0));
                }
                break;
            case WayTunnel:
                putItem(new Item(Item.itemTypes.Sell, "Rock", 5, 5));
                rand = r.nextInt(5);
                if (rand == 2) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", r.nextInt(51), 0));
                }
                break;
            case Cave:
                rand = r.nextInt(5);
                if (rand == 2) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", r.nextInt(51), 0));
                }
                enem=new Enemy("Troll",10,2);
                break;
            case Mountain:
                rand = r.nextInt(5);
                if (rand == 2) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", r.nextInt(51), 0));
                }
                enem=new Enemy("Wolf",5,1);
                break;
            case Villager:
                trader=new NPC("Wanderer",150);
                break;
            case Home:
                break;
            case Dungeon:
                rand = r.nextInt(5);
                if (rand == 2) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", r.nextInt(251), 0));
                }
                enem=new Enemy("LOBSTER",25,5);
                break;
            case Shop:
                trader=new NPC("Shopkeeper",250);
                break;
            case Exit:
                //A very small chance that you can find enough gold on the exit and win instantly
                rand = r.nextInt(500);
                if (rand == 5) {
                    putItem(new Item(Item.itemTypes.Gold, "Hidden Treasure", 1500, 0));
                }
                break;
        }
    }

    //Check if the item is already on the ground
    private void putItem(Item item) {
        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + 1);
        } else {
            items.put(item, 1);
        }
    }

    //Take an item out of the room
    public Item takeItem(String item) {
        for (Item i : items.keySet()
        ) {
            if (i.getName().equals(item)) {
                if (items.get(i) > 1) {
                    items.replace(i, items.get(i) - 1);
                    return i;
                } else {
                    items.remove(i);
                    return i;
                }
            } else {
                return i;
            }
        }
        return null;
    }

    //check the room contents
    public void checkRoom() {
        if (items.size() > 0) {
            for (Item i : items.keySet()
            ) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("No items in this room!");
        }
    }

    @Override
    public String toString() {
        return String.format("De kamer %s is op plaats %d, %d.", this.type.toString(), this.x + 1, this.y + 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
