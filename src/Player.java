import java.util.HashMap;

public class Player {
    private HashMap<Item, Integer> invent;
    private int stamina;
    private int gold;
    private int x;
    private int y;
    private int damage;

    public Player() {
        gold = 0;
        stamina = 10;
        invent = new HashMap<>();
        this.damage=2;
    }

    public void addItem(Item item) {
        if(item!=null){
        if (invent.containsKey(item)) {
            invent.replace(item, invent.get(item) + 1);
        } else {
            if (item.getType() == Item.itemTypes.Gold) {
                gold += item.getNumber();
                //invent.remove(item);
            } else {
                invent.put(item, 1);
            }
        }}
    }

    public void checkItem(String item) {
        for (Item i : invent.keySet()) {
            if(i.getName().equals(item)){
                if(invent.get(i)>1){
                    useItem(i);
                }
                else if(invent.get(i)==1){
                    useItem(i);
                    invent.remove(i);
                }
            }
            //System.out.println(i.toString()+" x "+invent.get(i));
        }
    }

    //Seperate to keep checking of correct item and actual usage clearly distinct
    private void useItem(Item item){
        if(item.getType()== Item.itemTypes.Stamina){
            setStamina(item.getNumber());
            invent.replace(item,invent.get(item)-1);
        }
    }

    public void checkInventory() {
        //Only go over list if the inventory is not empty
        if (invent.size() > 0) {
            for (Item i : invent.keySet()) {
                System.out.println(i.toString()+" x "+invent.get(i));
            }
        } else {
            System.out.println("Inventory is empty!");
        }
        System.out.println(String.format("You have %d stamina left!", stamina));
        System.out.println(String.format("You have %d gold.", gold));
    }

    //Moving the player
    public void movePlayer(String direction) {
        //Mismatched x and y coords but they work this way
        if (stamina > 0) {
            switch (direction) {
                case "up":
                    x--;
                    stamina--;
                    break;
                case "down":
                    x++;
                    stamina--;
                    break;
                case "left":
                    y--;
                    stamina--;
                    break;
                case "right":
                    y++;
                    stamina--;
                    break;
                default:
                    System.out.println("That direction does not exist!");
            }
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStamina(int number) {
        stamina += number;
    }

    public int getStamina() {
        return stamina;
    }

    public int getDamage() {
        return damage;
    }
    public void addGold(int amount){
        gold+=amount;
    }
}
