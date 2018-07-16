package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 来自《面试宝典》
 */
public class C4410 {
    public static void main(String[] args) {
        judgeChineseCharactor("Hello World");
        judgeChineseCharactor("Hello 你 World 好 Tiger 吗 ？");
    }

    /**
     * 找出所给字符串中的所有中文，以空格分隔
     * @param str 中英混合字符串
     */
    public static void judgeChineseCharactor(String str) {
        if(str == null || str.length() == 0) {
            System.out.println("无汉字");
            return;
        }
        // 判断是否存在中文字符
        if(str.getBytes().length == str.length()) {
            System.out.println("无汉字");
        } else {
            String regEx = "[\u4e00-\u9fa5]";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.print(matcher.group(0) + " ");
            }
        }
    }
}
