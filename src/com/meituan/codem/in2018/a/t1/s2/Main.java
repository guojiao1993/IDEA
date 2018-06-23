package com.meituan.codem.in2018.a.t1.s2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> location = new HashMap<>();
        location.put('A', 2);
        location.put('B', 2);
        location.put('C', 2);
        location.put('D', 3);
        location.put('E', 3);
        location.put('F', 3);
        location.put('G', 4);
        location.put('H', 4);
        location.put('I', 4);
        location.put('J', 5);
        location.put('K', 5);
        location.put('L', 5);
        location.put('M', 6);
        location.put('N', 6);
        location.put('O', 6);
        location.put('P', 7);
        location.put('Q', 7);
        location.put('R', 7);
        location.put('S', 7);
        location.put('T', 8);
        location.put('U', 8);
        location.put('V', 8);
        location.put('W', 9);
        location.put('X', 9);
        location.put('Y', 9);
        location.put('Z', 9);
        HashMap<Integer, Integer> distance = new HashMap<>();
        distance.put(0, 0);
        distance.put(1, 1);
        distance.put(2, 2);
        distance.put(3, 1);
        distance.put(4, 2);
        distance.put(5, 3);
        distance.put(6, 2);
        distance.put(7, 3);
        distance.put(8, 4);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] result = new int[num];
            for (int i = 0; i < num; i++) {
                String name = scanner.next();
                int cs = 0;
                int start = 1;
                for (int j = 0; j < name.length(); j++) {
                    char c = name.charAt(j);
                    int end = location.get(c);
                    int d = start - end;
                    if(d < 0) {
                        d = -d;
                    }
                    int add = distance.get(d);
                    switch (d) {
                        case 1: {
                            if((start == 3 && end == 4) || (start == 4 && end == 3)|| (start == 6 && end == 7)|| (start == 7 && end == 6)) {
                                add = 3;
                            }
                            break;
                        }
                        case 4: {
                            if((start == 3 && end == 7) || (start == 7 && end == 3)) {
                                add = 4;
                            }
                            break;
                        }
                    }
                    cs += add;
                    start = end;
                }
                result[i] = cs;
            }
            for (int i = 0; i < num; i++) {
                System.out.println(result[i]);
            }
        }
    }
}
