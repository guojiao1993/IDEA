package lambda;

public class RunnableTest {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello")).start();
    }
}
