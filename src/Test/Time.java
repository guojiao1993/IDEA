package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String t = sdf.format(new Date(Long.parseLong("1515054961750")));
        System.out.println(t);
    }
}
