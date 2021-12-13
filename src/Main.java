public class Main {
    public static void main(String[] args) {
        Player p=new Player();
        Game g=new Game(p);
        g.printFloorplan();
        g.printLocation();
    }
}
