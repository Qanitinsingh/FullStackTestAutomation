package design.pattern;

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static Singleton  getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public void testSingleton() {
        System.out.println("Singleton instance method called.");
    }
}
