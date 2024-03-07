package practice7.Decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
