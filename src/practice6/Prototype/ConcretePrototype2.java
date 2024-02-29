package practice6.Prototype;

public class ConcretePrototype2 implements Prototype{
    int name;
    public ConcretePrototype2(int name){
        this.name = name;
    }
    ConcretePrototype2(ConcretePrototype2 prototype){
        this.name = prototype.name;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this);
    }

    public int getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
