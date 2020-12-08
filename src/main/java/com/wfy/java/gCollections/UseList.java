package com.wfy.java.gCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/11/9 16:21
 */

public class UseList {
    public static void main(String[] args) {
        // 1. List是最基础的一种集合：它是一种有序列表。
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Microsoft");
        list.add(null); //允许添加null
        System.out.println(list.get(1));
        System.out.println(list.size());

        // 2. 使用of快速创建一个列表
        List<Integer> list1 = List.of(1, 2, 3, 4, 5); // 但是不能传入null

        // 3 List转Array
        // 3.1 List转Array，但是这样会丢失类型信息，实际很少使用
        Object[] array = list.toArray();
        System.out.println(array.getClass()); // Object

        // 3.2 给toArray(T[])传入一个类型相同的Array， List内部自动把元素复制传入到Array中。
        String[] array1 = list.toArray(new String[3]);
        System.out.println(array1.getClass()); // String

        // 3.3 如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回；
        String[] array2 = list.toArray(new String[1]);
        for (Object o : array2) {
            if (o != array2[array2.length - 1]) {
                System.out.print(o + " "); // Apple Microsoft null null null
            } else {
                System.out.println(o);
            }
        }

        // 3.4 如果传入的数组比List元素还要多，那么填充完元素后，剩下的数组元素一律填充null。
        String[] array3 = list.toArray(new String[5]);
        for (Object o : array3) {
            System.out.print(o + " "); // Apple Microsoft null null null
        }
        System.out.println("\n");

        // 3.5 最常用的就是传入一个恰好大小的数组：
        String[] array4 = list.toArray(new String[0]);
        for (Object o : array4) {
            System.out.print(o + " "); // Apple Microsoft null null null
        }

        // 3.6 另一重更简洁的方法是通过List接口定义的T[] toArray(IntFunction<T[]> generator)方法：
        String[] array5 = list.toArray(String[]::new);

        // 4 Array转List
        Integer[] array6 = {1, 2, 3};
        List<Integer> list2 = List.of(array6);

        List<Integer> imul_list = List.of(123,456, 789); // 返回的列表为不可变，不能修改
        //imul_list.add(999);

    }
}
