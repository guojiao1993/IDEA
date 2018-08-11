package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Map<List<String>, String> map = new HashMap<>();
        map.put(list, "abc");
        System.out.println(map);
    }
}
