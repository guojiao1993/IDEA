package test;

public class CharTest {
    public static void main(String[] args) {
        System.out.println("语言\t\t" + "示例" + "\t\t" + "Unicode码");
        System.out.println("-------------------------");
        System.out.println("英文\t\t" + 'a' + "\t\t" + (int)'a');
        System.out.println("俄文\t\t" + 'И' + "\t\t" + (int)'И');
        System.out.println("藏文\t\t" + 'म' + "\t\t" + (int)'म');
        System.out.println("日文\t\t" + 'へ' + "\t\t" + (int)'へ');
        System.out.println("中文\t\t" + '中' + "\t\t" + (int)'中');
    }
}
