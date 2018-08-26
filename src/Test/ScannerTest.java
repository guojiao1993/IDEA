package Test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        testNext();
        testNextLine();
    }

    public static void testNext() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
    }

    public static void testNextLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
    }
}
