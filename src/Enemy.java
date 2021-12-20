import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int damage;
    private boolean isDead;

    public Enemy(String naam, int health, int damage) {
        this.name = naam;
        this.health = health;
        this.damage = damage;
    }

    //dice roll for fighting and deciding who damages who
    public void diceRoll(Player p) {
        Random r = new Random();
        int rand = r.nextInt(4);
        if (rand >= 1) {
            p.setStamina(-damage);
            System.out.println("Player lost!");
        } else {
            if (health - p.getDamage() > 0 && !isDead) {
                System.out.println("Player won!");
                health -= p.getDamage();
            }else{
                isDead=true;
                System.out.println("Enemy defeated!");
                p.addGold(r.nextInt(51));
            }
        }
    }
}
