import java.util.ArrayList;

public class Player {
    private ArrayList<Item> invent;
    private int stamina;
    private int x;
    private int y;

    public Player() {
        stamina = 10;
        invent = new ArrayList<Item>();
    }

    public void addItem(Item item){
        invent.add(item);
    }

    public void checkInventory() {
        if (invent.size() > 0) {
            for (Item i : invent
            ) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("Inventory is empty!");
        }
    }

    public void movePlayer(String direction) {
        if (stamina > 0) {
            switch (direction) {
                case "up":
                    x--;
                    break;
                case "down":
                    x++;
                    break;
                case "left":
                    y--;
                    break;
                case "right":
                    y++;
                    break;
            }
            stamina--;
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
        this.stamina += number;
    }

    public int getStamina() {
        return stamina;
    }
}
