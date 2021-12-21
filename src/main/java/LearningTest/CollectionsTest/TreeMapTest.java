package LearningTest.CollectionsTest;

import org.junit.Test;

import java.net.Inet4Address;
import java.util.*;

/**
 * @author yanlingwang
 */
public class TreeMapTest {
    @Test
    public void test() {
        TreeMap<Object, Object> treeMap = new TreeMap<>();

        User user1 = new User("Tom", 20);
        User user2 = new User("Jack", 19);
        User user3 = new User("Lucy", 22);
        User user4 = new User("John", 30);
        treeMap.put(user1, 98);
        treeMap.put(user2, 99);
        treeMap.put(user3, 100);
        treeMap.put(user4, 88);

        /*
        自然排序
         */
        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());

        }
    }

    @Test
    public void test1() {
        TreeMap<Object, Object> treeMap1 = new TreeMap<>((o1, o2) -> {
            if (o1 instanceof User && o2 instanceof User) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                return Integer.compare(u1.getAge(), u2.getAge());
            } else {
                throw new RuntimeException("输入类型不匹配！");
            }

        });

        User user1 = new User("Tom", 20);
        User user2 = new User("Jack", 19);
        User user3 = new User("Lucy", 22);
        User user4 = new User("John", 30);
        treeMap1.put(user1, 98);
        treeMap1.put(user2, 99);
        treeMap1.put(user3, 100);
        treeMap1.put(user4, 88);

        /*
        定制排序：按照年龄升序排列
         */
        Set set = treeMap1.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());


        }
    }
}
