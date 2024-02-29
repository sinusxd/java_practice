package practice6.Prototype;

public class ConcretePrototype1 implements Prototype{
    String name;
    public ConcretePrototype1(String name){
        this.name = name;
    }
    ConcretePrototype1(ConcretePrototype1 prototype){
        this.name = prototype.name;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
