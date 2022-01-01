public class Item extends Player{
    private itemTypes type;
    private String name;
    private int number;
    private int value;
    private int weight;

    public enum itemTypes{
        Stamina,Weapon,Gold,Sell
    }
    public Item(itemTypes type, String naam, int number,int value,int weight){
        this.type=type;
        this.name=naam;
        this.number=number;
        this.value=value;
        this.weight=weight;
    }
    public String toString(){
        return String.format("%s of type %s %d with value %d",name,type,number,value);
    }

    public itemTypes getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
