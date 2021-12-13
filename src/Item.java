public class Item extends Player{
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
    }
    public void useItem(){
        if(type==itemTypes.Stamina){
            super.setStamina(number);
        }
        if(type==itemTypes.Weapon){
        }
    }
    public String toString(){
        if(type==itemTypes.Stamina){
            return String.format("%s which has %d healing.",name,number);
        }
        else if(type==itemTypes.Weapon){
            return String.format("%s which has %d damage.",name,Math.abs(number));
        }
        else{return "NO ITEM?";}
    }

    public itemTypes getType() {
        return type;
    }
}
