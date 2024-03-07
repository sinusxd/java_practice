package practice7.Decorator;

public class ChocolateDecorator extends CoffeeDecorator{
    ChocolateDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with chocolate";
    }

    @Override
    public int getCost() {
        return super.getCost() + 100;
    }
}
