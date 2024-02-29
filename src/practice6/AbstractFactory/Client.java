package practice6.AbstractFactory;

public class Client {
    private AbstractProductA abstractProductA;
    private AbstractProductB abstractProductB;

    public Client(AbstractFactory factory){
        abstractProductA = factory.createProductA();
        abstractProductB = factory.createProductB();
    }
    public void someOperation(){
        System.out.println(abstractProductA.getClass().getName() + " " + abstractProductB.getClass().getName());
    }
}
