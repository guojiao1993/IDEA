package com.meituan.codem.in2018.b.t1.s1;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * CodeM 2018 初赛B轮 第1题 第1次尝试
     *
     * @param args a
     */
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[] source = new int[n * m];
            int[] result = new int[n * m];
            String resultT = null;
            int num = 0;
            int max = 0;
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                String t = scanner.next();
                int index = (x - 1) * n + (y - 1);
                // 进入会议室
                if (z == 0) {
                    source[index]++;
                    if (source[index] == 1) {
                        num++;
                        // 记录最大亮灯数情况
                        if (num >= max) {
                            // 记录最晚时间情况
                            if(resultT != null && t.compareTo(resultT) < 0) {
                                continue;
                            }
                            max = num;
                            resultT = t;
                            result = Arrays.copyOf(source, source.length);
                        }
                    }
                    // 退出会议室
                } else {
                    source[index]--;
                    if (source[index] == 0) {
                        num--;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (result[i * n + j] > 0) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                }
                System.out.println();
            }
        }
    }
}
