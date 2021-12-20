import java.util.HashMap;

public class Player {
    private HashMap<Item, Integer> invent;
    private int stamina;
    private int gold;
    private int x;
    private int y;
    private int damage;
    private boolean weaponized;

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
                    i.useItem();
                    invent.replace(i,invent.get(i));
                }
                else if(invent.get(i)==1){
                    i.useItem();
                    invent.remove(i);
                }
            }
            //System.out.println(i.toString()+" x "+invent.get(i));
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

    public void setDamage(int number){
        damage+=number;
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

    public boolean isWeaponized() {
        return weaponized;
    }

    public void setWeaponized(boolean weaponized) {
        this.weaponized = weaponized;
    }
}
