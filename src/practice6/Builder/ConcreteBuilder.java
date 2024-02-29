package practice6.Builder;

public class ConcreteBuilder implements Builder {

    @Override
    public void buildRoof() {
        System.out.println("Построил крышу");
    }

    @Override
    public void buildWall() {
        System.out.println("Построил стену");
    }

    @Override
    public void buildFloor() {
        System.out.println("Построил пол");
    }
}
