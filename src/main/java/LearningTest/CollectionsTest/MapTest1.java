package LearningTest.CollectionsTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest1 {

    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>(16);

        /*
         添加：put
         */
        map.put("Tom", 18);
        map.put("Lucy", 20);
        map.put("Jack", 22);
        // {Tom=18, Lucy=20, Jack=22}
        System.out.println(map);

        HashMap<String, Integer> map1 = new HashMap<>(8);
        map1.put("Orange", 100);
        map1.put("Apple", 200);

        // 传入一个Map
        map.putAll(map1);
        // {Apple=200, Tom=18, Lucy=20, Jack=22, Orange=100}
        System.out.println(map);

        /*
        删除：remove
         */
        map.remove("Tom");
        //{Lucy=20, Jack=22}
        System.out.println(map);
        map.remove("Lucy", 20);
        System.out.println(map);

        /*
        修改
         */
        map.put("Tom", 33);

        /*
        查询：get
         */
        System.out.println(map.get("Apple"));

        /*
        长度:size
         */
        System.out.println(map.size());

        /*
        遍历key
         */
        for (String s : map.keySet()) {
            System.out.println(s);
        }

        /*
        遍历value
         */
        for (Integer value : map.values()) {
            System.out.println(value);
        }

        /*
        遍历key-value
         */
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry);
        }

        /*
        清空
         */
        map.clear();
        System.out.println(map.size());


    }
}
