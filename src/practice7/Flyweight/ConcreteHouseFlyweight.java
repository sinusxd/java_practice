package practice7.Flyweight;

public class ConcreteHouseFlyweight implements HouseFlyWeight{
    private int floors;
    private int rooms;

    public ConcreteHouseFlyweight(int floors, int rooms) {
        this.floors = floors;
        this.rooms = rooms;
    }

    @Override
    public void display(String address) {
        System.out.println("House at " + address + " with " + floors + " floors and " + rooms + " rooms");
    }
}
