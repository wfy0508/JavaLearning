package com.wfy.java.fGeneric;

/*
 * @Author wfy
 * @Date 2020/10/30 14:45
 * com.wfy.java.fGeneric
 */

public class ExtendsWildCard {
    public static void main(String[] args) {
        // 前面已经讲到了泛型的继承关系：Pair<Integer>不是Pair<Number>的子类。
        // 注意：传入的类型为Pair4<Number>, 实际的参数类型为(Integer, Integer)
        int sum = PairHelper.add(new Pair4<Number>(123, 321));
        System.out.println(sum);

        // 既然实际参数是Integer类型，试试传入Pair<Integer>：
        Pair4<Integer> p1 = new Pair4<>(123, 321);
        //int n = add(p1); // 编译器会直接提示不兼容的类型: Pair4<Integer>无法转换为Pair4<Number>
        // 原因很明显，因为Pair<Integer>不是Pair<Number>的子类，因此，add(Pair<Number>)不接受参数类型Pair<Integer>
        // 但是从add()方法的代码可知，传入Pair<Integer>是完全符合内部代码的类型规范，因为语句：
        // Number first = p.getFirst();
        // Number last = p.getLast();
        // 实际类型是Integer，引用类型是Number，没有问题。问题在于方法参数类型定死了只能传入Pair<Number>。

        // 有没有办法使得方法参数接受Pair<Integer>？
        // 办法是有的，这就是使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型。
        Pair4<Integer> p2 = new Pair4<>(123, 321);
        int n = add1(p2);
    }

    static int add(Pair4<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    // <? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number了。
    static int add1(Pair4<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
        //p.setFirst(new Integer(first.intValue() + 100)); // 不兼容的类型: Integer无法转换为capture#1,
        //p.setLast(new Integer(last.intValue() + 100)); // 不兼容的类型: Integer无法转换为capture#1,

        // p.setFirst传入的是Integer，p定义为<? extends Number>，为什么setFirst<? extends Number>不能传入Integer?
        // 原因还在于擦拭法。如果我们传入的p是Pair<Double>，显然它满足参数定义Pair<? extends Number>，
        // 然而，Pair<Double>的setFirst()显然无法接受Integer类型。
        // 这就是<? extends Number>通配符的一个重要限制：
        // 方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number)。

        // 这里唯一的例外是可以给方法参数传入null：
        // p.setFirst(null); ok, 但是下面这句就会抛出NullPointerException
        // p.getFirst().intValue(); // NullPointerException
    }
}

class Pair4<T extends Number> { //参数类型使用：<T extends Number>，会声明只接受Number及其子类
    private T first;
    private T last;

    public Pair4(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return this.first;
    }

    public T getLast() {
        return this.last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }
}

class PairHelper {
    static int add(Pair4<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
