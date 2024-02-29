package practice6;

import practice6.AbstractFactory.*;
import practice6.Builder.Builder;
import practice6.Builder.ConcreteBuilder;
import practice6.Builder.Director;
import practice6.FactoryMethod.*;
import practice6.Prototype.ConcretePrototype1;
import practice6.Prototype.ConcretePrototype2;
import practice6.Prototype.Prototype;

public class Test {
    public static void main(String[] args) {
        // Фабричный метод
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
        creator.anOperation();
        // Абстрактная фабрика
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();
        Client client1 = new Client(factory1);
        Client client2 = new Client(factory2);
        client1.someOperation();
        client2.someOperation();
        // Билдер
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        // Прототип
        Prototype prototype = new ConcretePrototype1("Senya");
        Prototype prototype1 = prototype.clone();
        Prototype prototype2 = new ConcretePrototype2(19);
        Prototype prototype3 = prototype2.clone();
        prototype.print();
        prototype1.print();
        prototype2.print();
        prototype3.print();
    }
}
