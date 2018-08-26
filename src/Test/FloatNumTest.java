package Test;

import java.math.BigDecimal;

public class FloatNumTest {
    public static boolean isEqual(double a, double b, int jd) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            return false;
        }
        return Math.abs(a - b) < Math.pow(10, -jd);
    }

    public static void main(String[] args) {
        System.out.println("1.01 + 2.02：" + (1.01 + 2.02));
        System.out.println("(1.01 + 2.02) == 3.03：" + ((1.01 + 2.02) == 3.03));
        System.out.println("new BigDecimal(\"1.34\")：" + new BigDecimal("1.34"));
        System.out.println("BigDecimal.valueOf(1.34)：" + BigDecimal.valueOf(1.34));
        System.out.println("new BigDecimal(Double.toString(1.34))：" + new BigDecimal(Double.toString(1.34)));
        System.out.println("new BigDecimal(1.34)：" + new BigDecimal(1.34));
        System.out.println("new BigDecimal(\"1.01\").add(new BigDecimal(\"2.02\"))：" + new BigDecimal("1.01").add(new BigDecimal("2.02")));
        System.out.println("new BigDecimal(\"3.03\").compareTo(new BigDecimal(\"1.01\").add(new BigDecimal(\"2.02\")))：" + new BigDecimal("3.03").compareTo(new BigDecimal("1.01").add(new BigDecimal("2.02"))));
        System.out.println();
        double r1 = 11.0 / 3;
        double r2 = 10.0 / 3 + 1.0 / 3;
        System.out.println("11.0 / 3：" + r1);
        System.out.println("10.0 / 3 + 1.0 / 3：" + r2);
        System.out.println("(11.0 / 3) == (10.0 / 3 + 1.0 / 3)：" + (r1 == r2));
        double cha = Math.abs(r1 - r2);
        System.out.println("|(11.0 / 3)-(10.0 / 3 + 1.0 / 3)|：" + cha);
        System.out.println("根据差值，与Math.pow(10, -10)做比较，来判断是否相等：" + (cha < Math.pow(10, -10)));
        System.out.println();
        System.out.println("使用isEqual()方法做判断");
        System.out.println("Math.abs(0.1d - 0.1f)：" + Math.abs(0.1d - 0.1f));
        System.out.println("0.1d == 0.1f，精度9：" + FloatNumTest.isEqual(0.1d, 0.1f, 9));
        System.out.println("0.1d == 0.1f，精度8：" + FloatNumTest.isEqual(0.1d, 0.1f, 8));
        System.out.println("0.1d == 0.1d，精度10：" + FloatNumTest.isEqual(0.1d, 0.1d, 10));
        System.out.println();
        System.out.println("Math.sqrt(-1.0)：" + Math.sqrt(-1.0));
        System.out.println("0.0 / 0.0：" + 0.0 / 0.0);
        System.out.println("0.0 / 0.0 + 1：" + (0.0 / 0.0 + 1));
        System.out.println("1.0 / 0.0：" + 1.0 / 0.0);
        System.out.println("-1.0 / 0.0：" + -1.0 / 0.0);
        System.out.println("(1.0 / 0.0) + (-1.0 / 0.0)：" + ((1.0 / 0.0) + (-1.0 / 0.0)));
        System.out.println("(0.0 / 0.0) == (0.0 / 0.0)：" + ((0.0 / 0.0) == (0.0 / 0.0)));
        System.out.println();
        Double a = Math.sqrt(-1.0);
        Double b = 0.0d / 0.0d;
        Double c = a + 200.0d;
        Double d = b + 1.0d;
        System.out.println("(Math.sqrt(-1.0)).equals(0.0d / 0.0d)：" + a.equals(b));
        System.out.println("(0.0d / 0.0d).equals(Math.sqrt(-1.0) + 200.0d)：" + b.equals(c));
        System.out.println("(Math.sqrt(-1.0) + 200.0d).equals(0.0d / 0.0d + 1.0d)：" + c.equals(d));
        System.out.println();
        System.out.println("0.1d == 0.1f：" + (0.1d == 0.1f));
        System.out.println("0.1f == 0.1f：" + (0.1f == 0.1f));
        System.out.println("0.1d == 0.1d：" + (0.1d == 0.1f));
        System.out.println("0.1f的32位二进制表示：" + Integer.toBinaryString(Float.floatToIntBits(0.1f)));
        System.out.println("0.1d的64位二进制表示：" + Long.toBinaryString(Double.doubleToLongBits(0.1d)));
        System.out.println("0.1f的64位二进制表示：" + Long.toBinaryString(Double.doubleToLongBits(0.1f)));
    }
}
