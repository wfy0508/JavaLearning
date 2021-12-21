package Liaoxuefeng.gCollections;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/21 16:24
 */

public class EqualsAndHashCode {
    public static void main(String[] args) {
        String k1 = "a";
        Map<String, Integer> map = new HashMap<>();
        map.put(k1, 123);
        String k2 = new String("a");
        System.out.println(k1 == k2);
        System.out.println(k1.equals(k2));
    }
}
