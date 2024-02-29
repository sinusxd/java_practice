package practice5;

public class FinalSingleton {
    private static FinalSingleton instance = new FinalSingleton();
    private FinalSingleton(){}

    public FinalSingleton getInstance(){
        return instance;
    }
}
