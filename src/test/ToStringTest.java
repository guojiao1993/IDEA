package test;

public class ToStringTest {
    public static void main(String[] args) {
        System.out.println("toString()方法输出测试：");
        System.out.println();
        System.out.println("基本数据类型");
        System.out.println("new Byte((byte)1)：" + new Byte((byte)1));
        System.out.println("new Short((short)1))：" + new Short((short)1));
        System.out.println("new Character('a'))：" + new Character('a'));
        System.out.println("new Integer(1))：" + new Integer(1));
        System.out.println("new Long(1))：" + new Long(1));
        System.out.println("new Boolean(true))：" + new Boolean(true));
        System.out.println("new Float(1))：" + new Float(1));
        System.out.println("new Double(1))：" + new Double(1));
        System.out.println();
        System.out.println("引用类型");
        System.out.println("new String(\"s\"))：" + new String("s"));
        System.out.println("new ToStringTest()：" + new ToStringTest());
        System.out.println();
        System.out.println("一维数组类型");
        System.out.println("new byte[3]：" + new byte[3]);
        System.out.println("new short[3]：" + new short[3]);
        System.out.println("new char[3]：" + new char[3]);
        System.out.println("new int[3]：" + new int[3]);
        System.out.println("new long[3]：" + new long[3]);
        System.out.println("new boolean[3]：" + new boolean[3]);
        System.out.println("new float[3]：" + new float[3]);
        System.out.println("new double[3]：" + new double[3]);
        System.out.println("new String[3]：" + new String[3]);
        System.out.println("new ToStringTest[3]：" + new ToStringTest[3]);
        System.out.println();
        System.out.println("多维数组类型");
        System.out.println("new byte[3]：" + new byte[3]);
        System.out.println("new byte[3][3]：" + new byte[3][3]);
        System.out.println("new byte[3][3][3]：" + new byte[3][3][3]);
        System.out.println("new byte[3][3][3][3]：" + new byte[3][3][3][3]);
    }
}
