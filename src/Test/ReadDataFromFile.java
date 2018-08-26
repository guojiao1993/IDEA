package Test;

import java.util.Scanner;

public class ReadDataFromFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new ReadDataFromFile().getClass().getResourceAsStream("data"));
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
