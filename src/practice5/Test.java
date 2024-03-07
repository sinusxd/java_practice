package practice5;

public class Test {
    public static void main(String[] args) {
        ClassSingleton a = ClassSingleton.getInstance();
        ClassSingleton b = ClassSingleton.getInstance();
        FinalSingleton a1 = FinalSingleton.getInstance();
        FinalSingleton b1 = FinalSingleton.getInstance();
        LazySingleton a2 = LazySingleton.getInstance();
        LazySingleton b2 = LazySingleton.getInstance();
        System.out.println(a.hashCode() + " " + b.hashCode());
        System.out.println(a1.hashCode() + " " + b1.hashCode());
        System.out.println(a2.hashCode() + " " + b2.hashCode());
    }
}
