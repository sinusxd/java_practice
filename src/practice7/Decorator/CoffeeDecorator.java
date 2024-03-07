package practice7.Decorator;

public abstract class CoffeeDecorator implements Coffee {
    Coffee coffee;

    public  CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }
}
