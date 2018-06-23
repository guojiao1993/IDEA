package com.meituan.codem.in2018.a.t2.s1;

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
            System.out.println(func(array));
        }
    }

    public static int func(int[] array) {
        int i = 0;
        int num = array.length;
        for (; i < num; i++) {
            if(array[i] != 0) {
                break;
            }
        }
        if(i == num) {
            return 0;
        } else {
            int f = 0;
            int z = 0;
            boolean isF = false;
            boolean isT = false;
            for (int j = 0; j < num; j++) {
                if(array[j] == 0) {
                    continue;
                }
                if(array[j] < 0) {
                    if(!isF) {
                        isF = true;
                        array[j] += 1;
                        f = j;
                    }
                    if (isT) {
                        break;
                    }
                } else {
                    if(!isT) {
                        isT = true;
                        array[j] -= 1;
                        z = j;
                    }
                    if (isF) {
                        break;
                    }
                }
            }
            return z + f + func(array);
        }
    }
}
