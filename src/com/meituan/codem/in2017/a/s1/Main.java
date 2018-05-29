package com.meituan.codem.in2017.a.s1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int[] cs = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            for (int n = l; n <= r; n++) {
                if(n == 1) {
                    cs[1]++;
                    continue;
                }
                for (int i = 1; i <= n / 2; i++)
                    if (n % i == 0) {
                        cs[String.valueOf(i).charAt(0) - 48]++;
                        int shang = n / i;
                        if(shang != i) {
                            cs[String.valueOf(n / i).charAt(0) - 48]++;
                        }
                    }
            }
            for (int i = 1; i <= 9; i++) {
                System.out.println(cs[i]);
            }
        }
    }
}
