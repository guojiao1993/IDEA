package yasuo;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

public class Test {
    public static String byteToBits(byte b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            // 0x80 是一个首位为1，其余位数为0的整数
            int t = (b & 0x80 >>> i) >>> (7 - i);
            sb.append(t);
        }
        return sb.toString();
    }

    public static void mainx(String[] args) {
        int n = -1;
        int[] c = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        if (n < 0) {
            c[0] = 1;
            n = -n;
            int w = 7;
            int[] f = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
            while (n != 0) {
                f[w] = n % 2;
                n = n / 2;
                w--;
            }
            for (int i = 1; i <= 7; i++) {
                f[i] = f[i] == 0 ? 1 : 0;
            }
        } else if (n > 0) {
            int w = 7;
            while (n != 0) {
                c[w] = n % 2;
                n = n / 2;
                w--;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main4(String[] args) {
        String s2 = new BigInteger("10000010", 2).toString(10);
        System.out.println(s2);
    }

    public static void main3(String[] args) {
        byte b = 56;
        System.out.println(Byte.toString(b));
        int i = 556;
        System.out.println(Integer.toBinaryString(i));
    }

    public static void mainz(String[] args) throws ClassNotFoundException, IOException {
        int max = 0;
        for (long i = Long.MAX_VALUE / 2; i < Long.MAX_VALUE; i++) {
            System.out.print(i + "：");
            long a = i;
            // 取2的指数
            double s1 = Math.log(a) / Math.log(2);
            // 判断指数是否为整数
            if (s1 % 1 == 0) {
                System.out.print((int) Math.pow(2, s1));
            } else {
                ArrayList<Integer> f = new ArrayList<>();
                ArrayList<Integer> z = new ArrayList<>();
                double left = Math.pow(2, (int) s1);
                double right = Math.pow(2, (int) (s1 + 1));
                double leftI = left;
                double rightI = right;
                double prefer = 3;
                int count = 0;
                while (true) {
                    if (Math.abs(a - leftI) > Math.abs(a - rightI)) {
                        leftI = leftI + (rightI - leftI) / 2;
                        prefer = rightI;
                    } else {
                        rightI = leftI + (rightI - leftI) / 2;
                        prefer = leftI;
                    }
                    double s = Math.abs(a - prefer);
                    if (Math.log(s) / Math.log(2) % 1 == 0) {
                        if (a < prefer) {
                            s = -s;
                            f.add((int) s);
                        } else {
                            z.add((int) s);
                        }
//                        System.out.print((int)s + "\t\t");
                        count++;
                        a = (int) prefer;
                        leftI = left;
                        rightI = right;
                    }
                    if (a == (int) left || a == (int) right) {
                        // 打印负
                        for (int j = 0; j < f.size(); j++) {
                            System.out.print(f.get(j) + "\t\t");
                        }
                        // 打印中值
                        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + a + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                        // 打印正
                        for (int j = 0; j < z.size(); j++) {
                            System.out.print(z.get(j) + "\t\t");
                        }
                        // 打印次数
                        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + count);
                        if (count > max) {
                            max = count;
                        }
                        break;
                    }
                }
            }
            System.out.println();
        }
        System.out.println(max);
    }

    public static void maini(String[] args) throws ClassNotFoundException, IOException {
        int max = 0;
        for (int i = Integer.MAX_VALUE / 2; i < Integer.MAX_VALUE; i++) {
            System.out.print(i + "：");
            int a = i;
            // 取2的指数
            double s1 = Math.log(a) / Math.log(2);
            // 判断指数是否为整数
            if (s1 % 1 == 0) {
                System.out.print((int) Math.pow(2, s1));
            } else {
                ArrayList<Integer> f = new ArrayList<>();
                ArrayList<Integer> z = new ArrayList<>();
                double left = Math.pow(2, (int) s1);
                double right = Math.pow(2, (int) (s1 + 1));
                double leftI = left;
                double rightI = right;
                double prefer = 3;
                int count = 0;
                while (true) {
                    if (Math.abs(a - leftI) > Math.abs(a - rightI)) {
                        leftI = leftI + (rightI - leftI) / 2;
                        prefer = rightI;
                    } else {
                        rightI = leftI + (rightI - leftI) / 2;
                        prefer = leftI;
                    }
                    double s = Math.abs(a - prefer);
                    if (Math.log(s) / Math.log(2) % 1 == 0) {
                        if (a < prefer) {
                            s = -s;
                            f.add((int) s);
                        } else {
                            z.add((int) s);
                        }
//                        System.out.print((int)s + "\t\t");
                        count++;
                        a = (int) prefer;
                        leftI = left;
                        rightI = right;
                    }
                    if (a == (int) left || a == (int) right) {
                        // 打印负
                        for (int j = 0; j < f.size(); j++) {
                            System.out.print(f.get(j) + "\t\t");
                        }
                        // 打印中值
                        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + a + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                        // 打印正
                        for (int j = 0; j < z.size(); j++) {
                            System.out.print(z.get(j) + "\t\t");
                        }
                        // 打印次数
                        System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + count);
                        if (count > max) {
                            max = count;
                        }
                        break;
                    }
                }
            }
            System.out.println();
        }
        System.out.println(max);
    }

    public static void mainy(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        int max = 0;
        long a = Long.MAX_VALUE;
        System.out.print(a + "：");
        // 取2的指数
        double a1 = Math.log(a);
        double a2 = Math.log(2);
        double s1 = a1 / a2;
        // 判断指数是否为整数
        if (s1 % 1 == 0) {
            System.out.print((int) Math.pow(2, s1));
        } else {
            ArrayList<Integer> f = new ArrayList<>();
            ArrayList<Integer> z = new ArrayList<>();
            double left = Math.pow(2, (int) s1);
            double right = Math.pow(2, (int) (s1 + 1));
            double leftI = left;
            double rightI = right;
            double prefer = 3;
            int count = 0;
            while (true) {
                if (Math.abs(a - leftI) > Math.abs(a - rightI)) {
                    leftI = leftI + (rightI - leftI) / 2;
                    prefer = rightI;
                } else {
                    rightI = leftI + (rightI - leftI) / 2;
                    prefer = leftI;
                }
                double s = Math.abs(a - prefer);
                if (Math.log(s) / Math.log(2) % 1 == 0) {
                    if (a < prefer) {
                        s = -s;
                        f.add((int) s);
                    } else {
                        z.add((int) s);
                    }
                    count++;
                    a = (long) prefer;
                    leftI = left;
                    rightI = right;
                }
                if (a == (int) left || a == (int) right) {
                    // 打印负
                    for (int j = 0; j < f.size(); j++) {
                        System.out.print(f.get(j) + "\t\t");
                    }
                    // 打印中值
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + a + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
                    // 打印正
                    for (int j = 0; j < z.size(); j++) {
                        System.out.print(z.get(j) + "\t\t");
                    }
                    // 打印次数
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + count);
                    if (count > max) {
                        max = count;
                    }
                    break;
                }
            }
        }
        System.out.println();
        System.out.println(max);
    }

    public static void mainq(String[] args) throws ClassNotFoundException, IOException {
        BigInteger bigInteger = new BigInteger("414928810191186042771186097301165550642518436687108186689992645824084324504513098247654712827871251776383502581751964291136026366803358887504123975513280670260795097716184396192760604151447593872827243215550837278278514021610619953108178812144615435754681193452988821408000288184613333903055274083733493276466087122823035826617229751557471996479714279179625508470956023372404611598268483735704857361322985323425391120477092228186576159181653059437894543670894090346777304247545126156680699772401102554178061428428780196649582367938683326229028958198588065198746462175769546126715709770635058266486063512673635555729520660558661561865762076291879485436347451649565923063354084966897058743986663034157725691951466286386865150507772554842460352559690480846222872704818895463973758561567120819354168796656106428783899600558035723124630862404242692138616985782609797731430137771014195104192446240784184349135251161452788382899898267150336909101361220226416325033865595830981523046065956081639293829195746914982826932575116817080956161431709337709135951957344587871607169209208704283615875386586500542948412556769445414085544158354180249241835891125578375236153191431380588067449973742139458325892386668178142038211910532798921223237658375718541279094860124983056000278706887664063307822924906020953702879657960152124436684416907549067904309794535134711562446123617042300837430297910403995014420484385212337262931099183247815835211433149201823239812993316307644132698009862686201902938744765722353554881480949936946259661752409316522761205714816451160753485274251736503467835008434936916963626221630297029553572973902821642020340686081347449663399477651458879169749057695102959144559629185462499546147908897506547667162078669594976365116781991961702089056762514087252938612027770526185779628912643311765732142908732915976403775488295195845275954867957673834994249879972848079790106537510764146945766272568061247830216609679439759548436234988467204775031534355315125842661882704368905543688974754483121087921546170663301873865058646473295227975864191779285529595898013889447510001838961068838918280372221164446075582581046166916772978927034489555466662138417385147418968973544124856193551895613768528326891041287989066572085113037078882328620677495120117595257560443500315793100898325087124123315315474627341682968517042928042387754607120684463192568438466526033024674231749828306442133373203659714921594480549313897897319365475506801778345498215164068481587691856632898404", 10);
        System.out.println(bigInteger.toString(10));
        while (bigInteger.compareTo(BigInteger.ZERO) != 0) {
            bigInteger = bigInteger.divide(new BigInteger("10000000000000000000000000000000", 10));
            System.out.print("a");
        }
    }

    public static void mainr(String[] args) {
        String a = "a.txt";
        String b = "b.txt";
        String d = "d.txt";
        byte[] buffer = new byte[1024];
        buffer[0] = -1;
        buffer[1] = -1;
        int read = 0;
        StringBuffer sb = new StringBuffer();
        System.out.println("*******************************************");
        for (int i = 0; i < 2; i++) {
            System.out.print(buffer[i] + " ");
            sb.append(byteToBits(buffer[i]));
        }
        System.out.println();

        String s = sb.toString();
        System.out.println("*******************************************");
        System.out.println(s);
        System.out.println("*******************************************");
        System.out.println(new BigInteger(s, 2).toString(10));
        System.out.println("*******************************************");
        System.out.println(new BigInteger(s, 2).toString(36));
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String a = "a.txt";
        String b = "b.txt";
        String d = "d.txt";
        String p = "p.jpg";
        String q = "q.jpg";
        InputStream inputStream = Class.forName("yasuo.Test").getResourceAsStream("/yasuo/" + q);
        byte[] buffer = new byte[1024];
        int read = 0;
        StringBuffer sb = new StringBuffer();
        while ((read = inputStream.read(buffer)) != -1) {
            System.out.println("*******************************************");
            for (int i = 0; i < read; i++) {
                System.out.print(buffer[i] + " ");
                sb.append(byteToBits(buffer[i]));
//                if((i+1) % 2 == 0) {
//                    sb.append(" ");
//                }
            }
            System.out.println();
        }
        inputStream.close();
        String s = sb.toString();
        System.out.println("*******************************************");
        System.out.println(s);
//        System.out.println("*******************************************");
//        s = s.replace(" ", "");
//        System.out.println(new BigInteger(s, 2).toString(10));
//        System.out.println("*******************************************");
//        System.out.println(new BigInteger(s, 2).toString(36));
    }
}
