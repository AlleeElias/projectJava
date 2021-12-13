import java.util.ArrayList;

public class Player {
    private ArrayList<Item> invent;
    private int stamina;
    private int gold;
    private int x;
    private int y;

    public Player() {
        gold=0;
        stamina = 10;
        invent = new ArrayList<Item>();
    }

    public void addItem(Item item){
        if(item.getType()== Item.itemTypes.Gold){
            gold+=item.getNumber();
            //invent.remove(item);
        }else{
            invent.add(item);
        }
    }
    public void useItem(int number){
        Item usage=invent.get(number);
        if(usage.getType()==Item.itemTypes.Stamina){
            setStamina(usage.getNumber());
            invent.remove(usage);
        }
    }

    public void checkInventory() {
        System.out.println(String.format("You have %d stamina left!",stamina));
        if (invent.size() > 0) {
            for (Item i : invent
            ) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("Inventory is empty!");
        }
        System.out.println(String.format("You have %d gold.",gold));
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
}
