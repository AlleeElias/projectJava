public class Player {
    private int x;
    private int y;

    public Player(){

    }
    public void movePlayer(String direction){
        switch (direction){
            case "up":x--;break;
            case "down":x++;break;
            case "left":y--;break;
            case "right":y++;break;
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
