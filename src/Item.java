public class Item {
    private itemTypes type;
    private String name;
    private int number;

    public enum itemTypes{
        Stamina,Weapon
    }
    public Item(itemTypes type, String naam, int number){
        this.type=type;
        this.name=naam;
        this.number=number;
        createItem();
    }
    private void createItem(){
        
    }
}
