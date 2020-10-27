package com.wfy.java.fGeneric;

/*
 * @Author wfy
 * @Date 2020/10/27 14:24
 * com.wfy.java.fGeneric
 */

import java.util.ArrayList;
import java.util.List;

public class GenericDefine {
    public static void main(String[] args) {
        // Java标准库提供的ArrayList，它可以看作“可变长度”的数组，因为用起来比数组更方便。
        // 实际上ArrayList内部就是一个Object[]数组，配合一个当前分配的长度，就可以充当“可变数组”

        // 如果使用ArrayList来存储String，需要强制转型，并且容易出错，必须按照下面的方法编写代码：
        ArrayList arrayList = new ArrayList();
        arrayList.add("hello");
        String s1 = (String) arrayList.get(0);
        System.out.println(s1);
        //并且容易出现误转型
        arrayList.add(new Integer(123));
        //String s2 = (String) arrayList.get(1); //转型错误:Integer cannot be cast to String
        // 这可能就需要为每一种类型编写一种ArrayList，但是太麻烦了

        // 为了解决这个问题，我们可以编写一个模板，可以创建任意类型的ArrayList<T>
        ArrayList<String> list = new ArrayList<String>(); // 创建String类型的ArrayLIst
        ArrayList<Integer> intList = new ArrayList<Integer>(); // 创建Integer类型的ArrayList
        ArrayList<Float> floatArrayList = new ArrayList<Float>(); // 创建Float类型的ArrayList
        // 泛型就是定义一种模板，例如ArrayList<T>，然后在代码中为用到的类创建对应的ArrayList<类型>，由编译器做类型检查

        // 在Java标准库中的ArrayList<T>实现了List<T>接口，它可以向上转型为List<T>：
        List<String> lst = new ArrayList<String>(); // 即类型ArrayList<T>可以向上转型为List<T>。
        // 但是不能将ArrayList<Integer>向上转型为List<Number>或ArrayList<Number>
    }
}
