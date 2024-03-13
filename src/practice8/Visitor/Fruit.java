package practice8.Visitor;

public class Fruit implements ItemElement{
    private int price;
    private int weight;
    private String name;

    public Fruit(int price, int weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
