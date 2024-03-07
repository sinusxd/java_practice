package practice7.Decorator;

public class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with milk";
    }

    @Override
    public int getCost() {
        return super.getCost() + 50;
    }
}
