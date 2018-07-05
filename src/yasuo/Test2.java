package yasuo;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test2 {

    public static char[] fineLeft(char[] ca) {
        char[] cat = new char[ca.length];
        for (int i = 0; i < ca.length; i++) {
            cat[i] = '0';
        }
        int index = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '1') {
                index = i;
                break;
            }
        }
        cat[index] = '1';
        return cat;
    }

    public static char[] findRight(char[] ca) {
        int index = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '1') {
                index = i;
                break;
            }
        }
        if (index == 0) {
            char[] cat = new char[ca.length + 1];
            for (int i = 0; i < cat.length; i++) {
                cat[i] = '0';
            }
            cat[index] = '1';
            return cat;
        } else {
            char[] cat = new char[ca.length];
            for (int i = 0; i < cat.length; i++) {
                cat[i] = '0';
            }
            cat[index - 1] = '1';
            return cat;
        }
    }

    public static int onlyOneOne(char[] ca) {
        int count = 0;
        int index = ca.length;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '1') {
                count++;
                if (count > 1) {
                    return -1;
                }
                index = i;
            }
        }
        return index;
    }

    public static boolean binaryEqu(char[] ca1, char[] ca2) {
        int length1 = ca1.length;
        int length2 = ca2.length;
        int length = length1 < length2 ? length2 : length1;
        if (length1 != length2) {
            char[] cat = new char[length];
            for (int i = 0; i < length; i++) {
                cat[i] = '0';
            }
            if (length1 < length) {
                System.arraycopy(ca1, 0, cat, length - length1, length1);
                ca1 = cat;
            } else {
                System.arraycopy(ca2, 0, cat, length - length2, length2);
                ca2 = cat;
            }
        }
        return new String(ca1).equals(new String(ca2));
    }

    public static int binaryCom(char[] ca1, char[] ca2) {
        int length1 = ca1.length;
        int length2 = ca2.length;
        int length = length1 < length2 ? length2 : length1;
        if (length1 != length2) {
            char[] cat = new char[length];
            for (int i = 0; i < length; i++) {
                cat[i] = '0';
            }
            if (length1 < length) {
                System.arraycopy(ca1, 0, cat, length - length1, length1);
                ca1 = cat;
            } else {
                System.arraycopy(ca2, 0, cat, length - length2, length2);
                ca2 = cat;
            }
        }
        return new String(ca1).compareTo(new String(ca2));
    }

    public static char[] binaryDiv(char[] ca) {
        for (int i = ca.length - 2; i >= 0; i--) {
            ca[i + 1] = ca[i];
        }
        ca[0] = '0';
        return ca;
    }

    public static char[] binarySub(char[] ca1, char[] ca2) {
        int length1 = ca1.length;
        int length2 = ca2.length;
        int length = length1 < length2 ? length2 : length1;
        if (length1 != length2) {
            char[] cat = new char[length];
            for (int i = 0; i < length; i++) {
                cat[i] = '0';
            }
            if (length1 < length) {
                System.arraycopy(ca1, 0, cat, length - length1, length1);
                ca1 = cat;
            } else {
                System.arraycopy(ca2, 0, cat, length - length2, length2);
                ca2 = cat;
            }
        }
        char[] ca = new char[length];
        for (int i = 0; i < length; i++) {
            ca[i] = '0';
        }
        char p = '0';
        for (int i = length - 1; i >= 0; i--) {
            char c1 = ca1[i];
            char c2 = ca2[i];
            if (c1 == '1' && c2 == '1') {
                if (p == '0') {
                    ca[i] = '0';
                } else {
                    ca[i] = '1';
                }
                continue;
            }
            if (c1 == '1' && c2 == '0') {
                if (p == '0') {
                    ca[i] = '1';
                } else {
                    ca[i] = '0';
                    p = '0';
                }
                continue;
            }
            if (c1 == '0' && c2 == '1') {
                if (p == '0') {
                    ca[i] = '1';
                    p = '1';
                } else {
                    ca[i] = '0';
                }
                continue;
            }
            if (c1 == '0' && c2 == '0') {
                if (p == '0') {
                    ca[i] = '0';
                } else {
                    ca[i] = '1';
                }
                continue;
            }
        }
        return ca;
    }

    public static char[] binaryAdd(char[] ca1, char[] ca2) {
        int length1 = ca1.length;
        int length2 = ca2.length;
        int length = length1 < length2 ? length2 : length1;
        if (length1 != length2) {
            char[] cat = new char[length];
            for (int i = 0; i < length; i++) {
                cat[i] = '0';
            }
            if (length1 < length) {
                System.arraycopy(ca1, 0, cat, length - length1, length1);
                ca1 = cat;
            } else {
                System.arraycopy(ca2, 0, cat, length - length2, length2);
                ca2 = cat;
            }
        }
        char[] ca = new char[length];
        for (int i = 0; i < length; i++) {
            ca[i] = '0';
        }
        char p = '0';
        for (int i = length - 1; i >= 0; i--) {
            char c1 = ca1[i];
            char c2 = ca2[i];
            if (c1 == '1' && c2 == '1') {
                ca[i] = p;
                p = '1';
                continue;
            }
            if ((c1 == '1' && c2 == '0') || (c1 == '0' && c2 == '1')) {
                if (p == '0') {
                    ca[i] = '1';
                } else {
                    ca[i] = '0';
                }
                continue;
            }
            if (c1 == '0' && c2 == '0') {
                ca[i] = p;
                p = '0';
                continue;
            }
        }
        return ca;
    }

    public static char[] genCF(int length, int isOnlyOneOne, int ws) {
        char[] jw = new char[ws];
        // 是0，使用全1进位表示
        if (isOnlyOneOne == length) {
            for (int i = 0; i < ws; i++) {
                jw[i] = '1';
            }
        } else {
            // 计算次方
            int jwi = length - isOnlyOneOne - 1;
            for (int i = 0; i < ws; i++) {
                jw[i] = '0';
            }
            int index = ws - 1;
            while (jwi != 0) {
                if (jwi % 2 == 0) {
                    jw[index] = '0';
                } else {
                    jw[index] = '1';
                }
                jwi = jwi / 2;
                index--;
            }
        }
        return jw;
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        main32(null);
        main64(null);
        main128(null);
    }

    public static void mainq(String[] args) throws ClassNotFoundException, IOException {
        String file = Class.forName("yasuo.Test2").getResource("/yasuo/8.txt").getFile();
        FileOutputStream fos = new FileOutputStream(file);
        byte[] bytes = "你好".getBytes();
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    public static void main32(String[] args) throws IOException, ClassNotFoundException {
//        char[] ca = binaryAdd("1101010111".toCharArray(), "00100111".toCharArray());
//        for (int i = 0; i < ca.length; i++) {
//            System.out.print(ca[i]);
//        }
//        System.out.println(onlyOneOne("0011".toCharArray()));
//        char[] ca = "0100".toCharArray();
//        char[] cat = findRight(ca);
//        for (int i = 0; i < cat.length; i++) {
//            System.out.print(cat[i]);
//        }
        String file = Class.forName("yasuo.Test2").getResource("/yasuo/32.txt").getFile();
        FileOutputStream fos = new FileOutputStream(file);

        char[] ca = new char[32];
        for (int i = 0; i < ca.length; i++) {
            ca[i] = '0';
        }
        TreeMap<Integer, Integer> record = new TreeMap<>();
        cs(ca, 0, record, fos);
        String s = "***********************************\n";
        System.out.print(s);
        fos.write(s.getBytes());
        Set<Map.Entry<Integer, Integer>> entries = record.entrySet();
        for (Map.Entry<Integer, Integer> entry:entries) {
            String info = entry.getKey() + "\t" + entry.getValue() + "\n";
            System.out.print(info);
            fos.write(info.getBytes());
        }
        fos.close();
    }

    public static void main64(String[] args) throws IOException, ClassNotFoundException {
//        char[] ca = binaryAdd("1101010111".toCharArray(), "00100111".toCharArray());
//        for (int i = 0; i < ca.length; i++) {
//            System.out.print(ca[i]);
//        }
//        System.out.println(onlyOneOne("0011".toCharArray()));
//        char[] ca = "0100".toCharArray();
//        char[] cat = findRight(ca);
//        for (int i = 0; i < cat.length; i++) {
//            System.out.print(cat[i]);
//        }
        String file = Class.forName("yasuo.Test2").getResource("/yasuo/64.txt").getFile();
        FileOutputStream fos = new FileOutputStream(file);

        char[] ca = new char[64];
        for (int i = 0; i < ca.length; i++) {
            ca[i] = '0';
        }
        TreeMap<Integer, Integer> record = new TreeMap<>();
        cs(ca, 0, record, fos);
        String s = "***********************************\n";
        System.out.print(s);
        fos.write(s.getBytes());
        Set<Map.Entry<Integer, Integer>> entries = record.entrySet();
        for (Map.Entry<Integer, Integer> entry:entries) {
            String info = entry.getKey() + "\t" + entry.getValue() + "\n";
            System.out.print(info);
            fos.write(info.getBytes());
        }
        fos.close();
    }

    public static void main128(String[] args) throws IOException, ClassNotFoundException {
//        char[] ca = binaryAdd("1101010111".toCharArray(), "00100111".toCharArray());
//        for (int i = 0; i < ca.length; i++) {
//            System.out.print(ca[i]);
//        }
//        System.out.println(onlyOneOne("0011".toCharArray()));
//        char[] ca = "0100".toCharArray();
//        char[] cat = findRight(ca);
//        for (int i = 0; i < cat.length; i++) {
//            System.out.print(cat[i]);
//        }
        String file = Class.forName("yasuo.Test2").getResource("/yasuo/128.txt").getFile();
        FileOutputStream fos = new FileOutputStream(file);

        char[] ca = new char[128];
        for (int i = 0; i < ca.length; i++) {
            ca[i] = '0';
        }
        TreeMap<Integer, Integer> record = new TreeMap<>();
        cs(ca, 0, record, fos);
        String s = "***********************************\n";
        System.out.print(s);
        fos.write(s.getBytes());
        Set<Map.Entry<Integer, Integer>> entries = record.entrySet();
        for (Map.Entry<Integer, Integer> entry:entries) {
            String info = entry.getKey() + "\t" + entry.getValue() + "\n";
            System.out.print(info);
            fos.write(info.getBytes());
        }
        fos.close();
    }

    public static void cs(char[] ca, int i, TreeMap<Integer, Integer> record, FileOutputStream fos) throws IOException {
        if(i == ca.length - 1) {
            ca[i] = '0';
            String r = binaryToJW(ca);
            int length = r.length();
            String info = length + "\t" + r + "\n";
//            System.out.print(info);
//            fos.write(info.getBytes());
            Integer value = record.get(length);
            if(value == null) {
                record.put(length, 1);
            } else {
                record.put(length, value + 1);
            }
            ca[i] = '1';
            r = binaryToJW(ca);
            length = r.length();
            info = length + "\t" + r + "\n";
//            System.out.print(info);
//            fos.write(info.getBytes());
            value = record.get(length);
            if(value == null) {
                record.put(length, 1);
            } else {
                record.put(length, value + 1);
            }
            return;
        }
        ca[i] = '0';
        cs(ca, i+ 1, record, fos);
        ca[i] = '1';
        cs(ca, i+ 1, record, fos);
        ca[i] = '0';
    }

    public static String binaryToJW(char[] ca) {
        int ws = (int) (Math.log(ca.length) / Math.log(2) + 1);
        // 判断是否是2的整数次方
        // 是整数次方
        int isOnlyOneOne = onlyOneOne(ca);
        if (isOnlyOneOne != -1) {
            char[] r = genCF(ca.length, isOnlyOneOne, ws);
            return new String(r);
        } else {
            // 寻找左右端点
            char[] left = fineLeft(ca);
            char[] right = findRight(ca);
            char[] leftI = new char[left.length];
            System.arraycopy(left, 0, leftI, 0, left.length);
            char[] rightI = new char[right.length];
            System.arraycopy(right, 0, rightI, 0, right.length);
            char[] prefer = null;
            StringBuffer f = new StringBuffer();
            StringBuffer m = new StringBuffer();
            StringBuffer z = new StringBuffer();
            while (true) {
                char[] disL = binarySub(ca, leftI);
                char[] disR = binarySub(rightI, ca);
                char[] dist = null;
                int disp = binaryCom(disL, disR);
                // 右区间
                if (disp == 1) {
                    leftI = binaryAdd(leftI, binaryDiv(binarySub(rightI, leftI)));
                    prefer = rightI;
                    dist = binarySub(prefer, ca);
                } else {
                    rightI = binaryAdd(leftI, binaryDiv(binarySub(rightI, leftI)));
                    prefer = leftI;
                    dist = binarySub(ca, prefer);
                }
                isOnlyOneOne = onlyOneOne(dist);
                if (isOnlyOneOne != -1) {
                    char[] r = genCF(dist.length, isOnlyOneOne, ws);
                    if (binaryCom(ca, prefer) == -1) {
                        f.append(r);
                    } else {
                        z.append(r);
                    }
                    ca = prefer;
                    leftI = left;
                    rightI = right;
                }
                if (binaryEqu(ca, left) || binaryEqu(ca, right)) {
                    m.append(genCF(ca.length, onlyOneOne(ca), ws));
                    return f.toString() + m.toString() + z.toString();
                }
            }
        }
    }
}
