import java.util.ArrayList;

public class Player {
    private ArrayList<String> invent;
    private int stamina;
    private int x;
    private int y;

    public Player() {
        stamina = 10;
        invent=new ArrayList<String>();
    }

    public void checkInventory(){
        for (String s:invent
             ) {
            System.out.println(s);
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
    public int getStamina(){
        return stamina;
    }
}
