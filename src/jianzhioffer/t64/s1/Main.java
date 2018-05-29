package jianzhioffer.t64.s1;

public class Main {
    static int sum = 0;
    public Main() {
        sum++;
    }
    public static void main(String[] args) {
        Main[] m = new Main[5];
        m[0] = new Main();
        System.out.println(sum);
    }
}
