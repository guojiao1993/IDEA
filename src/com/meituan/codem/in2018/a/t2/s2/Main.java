package com.meituan.codem.in2018.a.t2.s2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = scanner.nextInt();
            }
            for (int i = 0; i < num; i++) {
                array[i] -= scanner.nextInt();
            }
            int cs = 0;
            for (int i = 0; i < num; i++) {
                if(array[i] > 0) {
                    cs += array[i] * i;
                } else if(array[i] < 0) {
                    cs += (-array[i]) * i;
                }
            }
            System.out.println(cs);
        }
    }

}
