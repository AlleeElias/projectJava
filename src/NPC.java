import java.util.ArrayList;
import java.util.Random;

public class NPC {
    private String name;
    private int gold;
    private ArrayList<Item> allItems;
    private Item item;

    public NPC(String name,int gold){
        this.name=name;
        this.gold=gold;
        fillShop();
    }
    //DONE
    //CHoose random item to sell!
    private void fillShop(){
        allItems=new ArrayList<Item>();
        allItems.add(new Item(Item.itemTypes.Stamina,"Stamina Potion",5,25));
        allItems.add(new Item(Item.itemTypes.Stamina,"Strong Potion",10,50));
        allItems.add(new Item(Item.itemTypes.Stamina,"ULTRA Potion",15,75));
        allItems.add(new Item(Item.itemTypes.Stamina,"Golden Apple",25,100));

        Random r=new Random();
        int rand=r.nextInt(allItems.size());
        item=allItems.get(rand);
    }

    public void buyItem(){
        gold+=item.getValue();
    }
    //Taken from room class to check inventory
    public void showItem() {
        System.out.println(item.toString());
    }

    //ALL GETTERS AND SETTERS

    public Item getItem() {
        return item;
    }
}
