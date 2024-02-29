package practice6.FactoryMethod;

public abstract class Creator {
    public abstract Product factoryMethod();
    public void anOperation(){
        System.out.println(this.getClass().getName());
    }
}
