package practice5;

public class ClassSingleton {
    private ClassSingleton(){}
    private static class SingletonHolder{
        private static final ClassSingleton instance = new ClassSingleton();
    }
    public static ClassSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
