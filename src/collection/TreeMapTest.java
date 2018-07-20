package collection;

import java.util.*;

/**
 * TreeMap排序测试
 * <p>参考：https://blog.csdn.net/wthfeng/article/details/51934704
 */
public class TreeMapTest {
    public static void main(String[] args) {
        sort();
        System.out.println();
        sortR();
        System.out.println();
        sortValue();
        System.out.println();
        sortValueR();
        System.out.println();
        sortApple();
    }

    /**
     * 将Key按自然顺序（从小到大）进行排序
     */
    public static void sort() {
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "e");
        treeMap.put("c", "h");
        treeMap.put("g", "c");
        treeMap.put("b", "z");
        // Key相同，则替换Value
        treeMap.put("a", "f");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    /**
     * 将Key按从大到小进行排序
     */
    public static void sortR() {
        // 进一步简化
        Map<String, String> treeMap = new TreeMap<>(Comparator.comparing(String::toString).reversed());
        // 简化
//        Map<String, String> treeMap = new TreeMap<>(Comparator.comparing((String s) -> s.toString()).reversed());
        // 普通Lambda表达式
//        Map<String, String> treeMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        // 匿名内部类的写法
//        Map<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        treeMap.put("a", "e");
        treeMap.put("c", "h");
        treeMap.put("g", "c");
        treeMap.put("b", "z");
        // Key相同，则替换Value
        treeMap.put("a", "f");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    /**
     * 将Value按自然顺序（从小到大）进行排序
     */
    public static void sortValue() {
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "e");
        treeMap.put("c", "h");
        treeMap.put("g", "c");
        treeMap.put("b", "z");
        // Key相同，则替换Value
        treeMap.put("a", "f");
        // 将Map转换为List
        List<Map.Entry<String, String>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, Comparator.comparing((Map.Entry<String, String>::getValue)));
//        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    /**
     * 将Value按从大到小进行排序
     */
    public static void sortValueR() {
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "e");
        treeMap.put("c", "h");
        treeMap.put("g", "c");
        treeMap.put("b", "z");
        // Key相同，则替换Value
        treeMap.put("a", "f");
        // 将Map转换为List
        List<Map.Entry<String, String>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, Comparator.comparing((Map.Entry<String, String>::getValue)).reversed());
//        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
//            @Override
//            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    public static void sortApple() {
        List<Apple> apples = new ArrayList<>();
        Random random = new Random(12);
        for (int i = 0; i < 10; i++) {  //生成10个苹果，重量随机生成
            Apple apple = new Apple();
            apple.setWeight(random.nextInt(1000));
            apple.setPrice(random.nextInt(50));
            apples.add(apple);
        }
        // 定义三个相同重量的苹果，但价格不同
        Apple apple1 = new Apple();
        apple1.setWeight(888);
        apple1.setPrice(19);
        apples.add(apple1);
        Apple apple2 = new Apple();
        apple2.setWeight(888);
        apple2.setPrice(511);
        apples.add(apple2);
        Apple apple3 = new Apple();
        apple3.setWeight(888);
        apple3.setPrice(283);
        apples.add(apple3);
        System.out.println("排序前");
        for (Apple apple : apples) { //打印10个苹果的顺序
            System.out.println(apple);
        }
        // 默认以价格倒序排序
        Collections.sort(apples);
        System.out.println("以价格排序");
        for (Apple apple : apples) { //排序后的顺序
            System.out.println(apple);
        }
        // 自定义以重量正序排序
        // 在重量相同时，会进一步调用自身的compareTo方法
        Collections.sort(apples, Comparator.comparing(Apple::getWeight));
        System.out.println("以重量排序");
        for (Apple apple : apples) { //排序后的顺序
            System.out.println(apple);
        }
    }
}

/**
 * 苹果类
 */
class Apple implements Comparable<Apple> {
    /**
     * 重量
     */
    private Integer weight;
    /**
     * 价格
     */
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {   //重写toString()方法，方面输出
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("Apple:(weight:");
        sb.append(weight);
        sb.append(",\trice:");
        sb.append(price);
        sb.append(")]");
        return sb.toString();
    }

    // 实现内部排序，以价格倒序排序
    @Override
    public int compareTo(Apple o) {
        return o.price.compareTo(price);
    }
}
