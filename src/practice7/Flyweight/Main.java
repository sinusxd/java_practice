package practice7.Flyweight;

public class Main {
    public static void main(String[] args) {
        HouseFlyweightFactory factory = new HouseFlyweightFactory();

        HouseFlyWeight sharedHouse1 = factory.getHouseFlyweight(2, 3);
        sharedHouse1.display("123 Main St");

        HouseFlyWeight sharedHouse2 = factory.getHouseFlyweight(2, 3);
        sharedHouse2.display("456 Elm St");

        HouseFlyWeight unsharedHouse = new UnsharedHouseFlyweight("789 Oak St", 250000.0);
        unsharedHouse.display("");
    }
}
