public class Player {
    private int x;
    private int y;

    public Player(){

    }
    public void movePlayer(String direction){
        switch (direction){
            case "up":y--;break;
            case "down":y++;break;
            case "left":x--;break;
            case "right":x++;break;
        }
    }
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
