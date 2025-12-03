package design.pattern;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.testSingleton();
    }
}
