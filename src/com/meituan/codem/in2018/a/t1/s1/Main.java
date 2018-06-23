package com.meituan.codem.in2018.a.t1.s1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] result = new int[num];
            for (int i = 0; i < num; i++) {
                String name = scanner.next();
                int cs = 0;
                int start = 1;
                for (int j = 0; j < name.length(); j++) {
                    char c = name.charAt(j);
                    int end = 0;
                    switch (c) {
                        case 'A':
                        case 'B':
                        case 'C': {
                            end = 2;
                            break;
                        }
                        case 'D':
                        case 'E':
                        case 'F': {
                            end = 3;
                            break;
                        }
                        case 'G':
                        case 'H':
                        case 'I': {
                            end = 4;
                            break;
                        }
                        case 'J':
                        case 'K':
                        case 'L': {
                            end = 5;
                            break;
                        }
                        case 'M':
                        case 'N':
                        case 'O': {
                            end = 6;
                            break;
                        }
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S': {
                            end = 7;
                            break;
                        }
                        case 'T':
                        case 'U':
                        case 'V': {
                            end = 8;
                            break;
                        }
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z': {
                            end = 9;
                            break;
                        }
                    }
                    int distance = start - end;
                    if(distance < 0) {
                        distance = -distance;
                    }
                    int add = 0;
                    switch (distance) {
                        case 1: {
                            add = 1;
                            break;
                        }
                        case 2: {
                            add = 2;
                            break;
                        }
                        case 3: {
                            add = 1;
                            break;
                        }
                        case 4: {
                            add = 2;
                            break;
                        }
                        case 5: {
                            add = 3;
                            break;
                        }
                        case 6: {
                            add = 2;
                            break;
                        }
                        case 7: {
                            add = 3;
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
