package com.meituan.codem.in2018.b.t4.s2;

import java.util.Scanner;

public class Main {
    /**
     * CodeM 2018 初赛B轮 第4题 第1次尝试
     *
     * @param args a
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int r = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            double r1 = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
            if (r1 == Math.pow(2 * r, 2)) {
                System.out.println(0);
                continue;
            }
            r1 = Math.sqrt(r1);
            double d2 = Math.pow(x2, 2) + Math.pow(y2, 2);
            double r2 = 0;
            double r3 = 0;
            if (d2 == Math.pow(r, 2)) {
                r3 = 0;
            } else {
                double x4 = x2 * r / Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
                double y4 = y2 * r / Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
                double x3 = -x4;
                double y3 = -y4;
                r2 = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
                r3 = Math.sqrt(Math.pow((x4 - x2), 2) + Math.pow((y4 - y2), 2));
            }
            if (r1 < (r2 + r3)) {
                System.out.println(r1);
            } else {
                System.out.println(r2 + r3);
            }
        }
    }
}
