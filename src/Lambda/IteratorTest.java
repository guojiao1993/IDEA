package Lambda;

import java.util.Arrays;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List feature1 = Arrays.asList("1", "2", "3");
        feature1.forEach(n -> System.out.print(n + " "));
        System.out.println();
        List feature2 = Arrays.asList("4", "5", "6");
        feature2.forEach(System.out::println);
    }
}
