package Liaoxuefeng.gCollections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 10:44
 */

public class useSet {
    public static void main(String[] args) {
        // Set用于存储不重复的元素集合，它主要提供以下几个方法：
        // 1. 将元素添加进Set<E>：boolean add(E e)
        // 2. 将元素从Set<E>删除：boolean remove(Object e)
        // 3. 判断是否包含元素：boolean contains(Object e)
        Set<String> set = new HashSet<>();
        System.out.println(set.add("hello")); // true
        System.out.println(set.add("world")); // true
        System.out.println(set.remove("hello")); // true
        System.out.println(set.contains("world")); // true
        System.out.println(set.add("world")); //false
        System.out.println(set.size()); // 1

        // Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。
        // 因为放入Set的元素和Map的key类似，都要正确实现equals()和hashCode()方法，否则该元素无法正确地放入Set。
        // 最常用的Set实现类是HashSet，实际上，HashSet仅仅是对HashMap的一个简单封装

        // Set接口并不保证有序，而SortedSet接口则保证元素是有序的：
        // HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
        // TreeSet是有序的，因为它实现了SortedSet接口。
        HashSet<Object> set1 = new HashSet<>();
        set1.add("apple");
        set1.add("pear");
        set1.add("banana");
        for (Object o : set1) {
            System.out.println(o); // 输出的顺序既不是添加的顺序，也不是String排序的顺序
        }

        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add("pear");
        treeSet.add("banana");
        treeSet.add("apple");
        for (Object o : treeSet) {
            System.out.println(o); // 输出是按照字母顺序排列的
        }

    }
}
