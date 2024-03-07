package practice7.Flyweight;

public class UnsharedHouseFlyweight implements HouseFlyWeight{
    private String address;
    private double price;

    public UnsharedHouseFlyweight(String address, double price) {
        this.address = address;
        this.price = price;
    }

    @Override
    public void display(String address) {
        System.out.println("Unique house at " + this.address + " with price $" + this.price);
    }
}
