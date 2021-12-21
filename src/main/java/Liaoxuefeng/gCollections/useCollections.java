package Liaoxuefeng.gCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 17:42
 */

public class useCollections {
    public static void main(String[] args) {
        // 1. 创建空集合
        // Collections提供了一系列方法来创建空集合：
        // 1.1 创建空List：List<T> emptyList()
        // 1.2 创建空Map：Map<K, V> emptyMap()
        // 1.3 创建空Set：Set<T> emptySet()
        // 要注意到返回的空集合是不可变集合，无法向其中添加或删除元素。
        List<String> list = List.of();
        List<String> list1 = Collections.emptyList();

        // 2. 创建单元素集合
        // Collections提供了一系列方法来创建一个单元素集合：
        // 2.1 创建一个元素的List：List<T> singletonList(T o)
        // 2.2 创建一个元素的Map：Map<K, V> singletonMap(K key, V value)
        // 2.3 创建一个元素的Set：Set<T> singleton(T o)
        // 要注意到返回的单元素集合也是不可变集合，无法向其中添加或删除元素。
        List<String> list2 = List.of("apple");
        List<String> list3 = Collections.singletonList("apple");

        // 实际上，使用List.of(T...)更方便，
        // 因为它既可以创建空集合，也可以创建单元素集合，还可以创建任意个元素的集合。

        // Collections可以对List进行排序。因为排序会直接修改List元素的位置，因此必须传入可变List
        List<String> list4 = new ArrayList<>();
        list4.add("orange");
        list4.add("pear");
        list4.add("apple");
        System.out.println(list4);
        Collections.sort(list4); // 排序
        System.out.println(list4);
        Collections.shuffle(list4); // 洗牌
        System.out.println(list4);

        // 3. 不可变集合
        // Collections还提供了一组方法把可变集合封装成不可变集合：
        // 3.1 封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
        // 3.2 封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
        // 3.3 封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
        // 这种封装实际上是通过创建一个代理对象，拦截掉所有修改方法实现的。
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        List<String> immutable = Collections.unmodifiableList(mutable);
        try {
            immutable.add("orange");
        } catch (UnsupportedOperationException e){
            System.out.println(e); //UnsupportedOperationException
        }

        // 4. 线程安全集合
        // Collections还提供了一组方法，可以把线程不安全的集合变为线程安全的集合：
        // 4.1 变为线程安全的List：List<T> synchronizedList(List<T> list)
        // 4.2 变为线程安全的Set：Set<T> synchronizedSet(Set<T> s)
        // 4.3 变为线程安全的Map：Map<K,V> synchronizedMap(Map<K,V> m)
    }
}
