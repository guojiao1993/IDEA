package com.meituan.codem.in2018.a.t2.s3;

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
            for (int i = num - 1; i > -1; i--) {
                if (array[i] < 0) {
                    cs += (-array[i]) * i;
                    for (int j = 0; j < i; j++) {
                        if (array[j] > 0) {
                            if (array[j] >= (-array[i])) {
                                cs += (-array[i]) * j;
                                array[j] += array[i];
                                array[i] = 0;
                                break;
                            } else {
                                cs += array[j] * j;
                                array[i] += array[j];
                                array[j] = 0;
                            }
                        }
                    }
                }
                if (array[i] > 0) {
                    for (int j = i - 1; j > -1; j--) {
                        if (array[j] < 0) {
                            if ((-array[j]) >= array[i]) {
                                cs += array[i] * (i - j);
                                array[j] += array[i];
                                array[i] = 0;
                                break;
                            } else {
                                cs += (-array[j]) * (i - j);
                                array[i] += array[j];
                                array[j] = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(cs);
        }
    }

}
