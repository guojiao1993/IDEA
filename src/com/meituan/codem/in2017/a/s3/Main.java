package com.meituan.codem.in2017.a.s3;

public class Main {

    public static void main(String[] args) {
        compute(75);
    }

    /**
     * 自己研究用
     * @param x
     */
    private static void compute(int x) {
        for (int i = 1; i <= 9; i++) {   // i为约数y的最高位数字
            System.out.println("约数y的最高位数字：" + i);
            System.out.println();
            for (long j = 1; i * j <= x; j *= 10) { // 构造以i为最高位数字的约数
                System.out.println("构造以" + i + "为最高位数字的约数：" + j);
                // 约数y 从 [i*j,min((i+1)*j-1,x)],[1,1],[10,19],[100,199]...
                // 例如：[10,19](i=1,j=10,x>19)
                long start = i * j;
                long end = Math.min((i + 1) * j - 1, x);
                long slip;
                System.out.println("约数y：[" + start + "," + end + "]");
                System.out.println();
                for (long y = start; y <= end; y += slip) {
                    long mul = x / y;  // [1,x]中能够整除y的个数为x/y
                    System.out.println("[1," + x + "]中能够整除" + y + "的个数为：" + mul);
                    long remain = x - mul * y; // 大于y却不能整除y的有remain个
                    System.out.println("大于" + y * mul + "却不能整除" + y + "的有" + remain + "个");
                    // slip为在[start,end]区间中与y值具有相同mul的值的个数
                    slip = 1 + Math.min(remain / mul, end - y);
                    System.out.println(slip + "为在[" + start + "," + end + "]区间中与" + y + "值具有相同" + mul + "的值的个数");
                    System.out.println("以" + i + "开头的约数数量加" + mul * slip);
                    System.out.println();
                }
            }
        }
    }

    /**
     * 原帖代码
     * https://blog.csdn.net/qq_26579801/article/details/80409686
     * @param a
     * @param x
     */
    private static void compute(long[] a, int x) {
        for (int i = 1; i <= 9; i++) {   // i为约数y的最高位数字
            for (long j = 1; i * j <= x; j *= 10) { //构造以i为最高位数字的约数
                //约数y 从 [i*j,min((i+1)*j-1,x)],[1,1],[10,19],[100,199]...
                // 例如：[10,19](i=1,j=10,x>19)
                long start = i * j;
                long end = Math.min((i + 1) * j - 1, x);
                long slip;
                for (long y = start; y <= end; y += slip) {
                    long mul = x / y;  //[1,x]中能够整除y的个数为x/y
                    long remain = x - mul * y; //大于y却不能整除y的有remain个
                    //slip为在[start,end]区间中与y值具有相同mul的值的个数
                    slip = 1 + Math.min(remain / mul, end - y);
                    a[i] += mul * slip;
                }
            }
        }
    }

}
