package com.wfy.java.fGeneric;

/*
 * @Author wfy
 * @Date 2020/11/1 21:01
 * com.wfy.java.fGeneric
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperWildCard {
    public static void main(String[] args) {
        Pairs<Integer> p1 = new Pairs<>(123, 456);
        Pairs<Number> p2 = new Pairs<>(123.4, 567.8);
        Pairs<?> p3 = p2; // <?>通配符的特点是，Pairs<?>是所有Pairs<T>的超类，可以安全的向上转型。
        set(p1, 123, 456); // 传入Pairs<Integer>是允许的
        //set(p2, 123, 456); // 但是传入Pairs<Number>是不允许的。
        set1(p2, 123, 456); // 传入Pairs<Number>不允许的。

        System.out.println("p1: " + p1.getFirst() + ", " + p1.getLast());
        System.out.println("p2: " + p2.getFirst() + ", " + p2.getLast());

        set2(p1, 100);
        set2(p2, 100);

        // 作为方法参数，<? extends T>类型和<? super T>类型的区别在于：
        // 1. <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
        // 2. <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
        // 3. 一个是允许读不允许写(extends 不允许set)，另一个是允许写不允许读（super不允许get）。

        // 像Collections中的copy定义
        /*
        public static <T> void copy(List<? super T> dest, List<? extends T> src) {
          for (int i=0; i<src.size(); i++) {
              T t = src.get(i);
              dest.add(t);
          }
       }
         */
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Collections.copy(numberList, integerList); // OK
        // Collections.copy(integerList, numberList); // error, cannot copy List<Number> to List<Integer>

        // PECS原则
        // 何时使用extends，何时使用super？为了便于记忆，我们可以用PECS原则：Producer Extends Consumer Super。
        // 即：如果需要返回T，它是生产者（Producer），要使用extends通配符；
        // 如果需要写入T，它是消费者（Consumer），要使用super通配符。

    }

    // 前面已经讲到了泛型的继承关系：Pair<Integer>不是Pair<Number>的子类
    static void set(Pairs<Integer> p, Integer first, Integer last) {
        p.setFirst(first);
        p.setLast(last);
    }

    // 和extends通配符相反，这次，我们希望接受Pair<Integer>类型，以及Pair<Number>、Pair<Object>，
    // 因为Number和Object是Integer的父类，setFirst(Number)和setFirst(Object)实际上允许接受Integer类型。
    // 注意到Pairs<? super Integer>表示，方法参数接受所有泛型类型为Integer或Integer父类的Pair类型。
    static void set1(Pairs<? super Integer> p, Integer first, Integer last) {
        p.setFirst(first);
        p.setLast(last);
    }

    // void setFirst(? super Integer)的方法签名是void setFirst(? super Integer)
    // Pair<? super Integer>的getFirst()方法签名是? super Integer getFirst();
    static void set2(Pairs<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

    // 无限定通配符
    //我们已经讨论了<? extends T>和<? super T>作为方法参数的作用。
    // 实际上，Java的泛型还允许使用无限定通配符（Unbounded Wildcard Type），即只定义一个?：
    static void sample(Pairs<?> p) {
        System.out.println("test");
    }

    // 因为<?>通配符既没有extends，也没有super，因此：
    // 不允许调用set(T)方法并传入引用（null除外）；
    // 不允许调用T get()方法并获取T引用（只能获取Object引用）。
    // 换句话说，既不能读，也不能写，那只能做一些null判断：
    static boolean isNull(Pairs<?> p) {
        return p.getFirst() == null || p.getLast() == null;
    }

    //大多数情况下，可以引入泛型参数<T>消除<?>通配符：
    static <T> boolean isNull1(Pairs<T> p) {
        return p.getFirst() == null || p.getLast() == null;
    }

    // <?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类：
}

class Pairs<T> {
    private T first;
    private T last;

    public Pairs(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
