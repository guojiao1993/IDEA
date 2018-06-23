package com.meituan.codem.in2018.b.t1.s2;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    /**
     * CodeM 2018 初赛B轮 第1题 第2次尝试
     *
     * @param args a
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            int[] source = new int[n * m];
            int[] result = new int[n * m];
            int num = 0;
            int max = 0;
            Map<String, Integer[]> map = new TreeMap<String, Integer[]>();

            for (int i = 0; i < k; i++) {
                Integer[] xyz = new Integer[3];
                xyz[0] = scanner.nextInt();
                xyz[1] = scanner.nextInt();
                xyz[2] = scanner.nextInt();
                String t = scanner.next();
                map.put(t, xyz);
            }

            Set<Map.Entry<String, Integer[]>> entries = map.entrySet();
            for (Map.Entry<String, Integer[]> entry : entries) {
                String t = entry.getKey();
                Integer[] value = entry.getValue();
                int x = value[0];
                int y = value[1];
                int z = value[2];
                int index = (x - 1) * n + (y - 1);
                // 进入会议室
                if (z == 0) {
                    source[index]++;
                    if (source[index] == 1) {
                        num++;
                        // 记录最大亮灯数情况
                        if (num >= max) {
                            max = num;
                            System.arraycopy(source, 0, result, 0, source.length);
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
