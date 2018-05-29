package com.meituan.codem.in2018.t1.s1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a1 = new int[n];
            int[] a2 = new int[n];
            for (int i = 0; i < n; i++) {
                a1[i] = scanner.nextInt();
                a2[i] = scanner.nextInt();
            }
            int[] b1 = new int[m];
            int[] b2 = new int[m];
            for (int i = 0; i < m; i++) {
                b1[i] = scanner.nextInt();
                b2[i] = scanner.nextInt();
            }
            double qs = 0;
            double qs1 = 0;
            for (int i = 0; i < n; i++) {
                qs += a1[i];
                if(a2[i] == 1) {
                    qs1 += a1[i] * 0.8;
                } else {
                    qs1 += a1[i];
                }
            }
            double qs2 = Double.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                if(qs >= b1[i]) {
                    qs2 = Double.min(qs2, qs - b2[i]);
                }
            }
            qs = Double.min(qs1, qs2);
            System.out.println(String.format("%.2f",qs));
        }
    }
}
