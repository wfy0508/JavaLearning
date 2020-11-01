package com.wfy.java.fGeneric;

/*
 * @Author wfy
 * @Date 2020/11/1 21:56
 * com.wfy.java.fGeneric
 */

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class GenericAndReflect {
    public static void main(String[] args) throws Exception {
        //Java的部分反射API也是泛型。例如：Class<T>就是泛型：
        Class<String> clazz = String.class; // 这样编译会有警告Raw use of parameterized class 'Class'
        String str = clazz.newInstance();

        Class<String> clazz1 = String.class; // 指定参数类型后，不会再有警告
        String str1 = (String) clazz1.newInstance();

        // 调用Class的getSuperclass()方法返回的Class类型是Class<? super T>：
        Class<? super String> sup = String.class.getSuperclass();

        // 构造方法Constructor<T>也是泛型：
        Class<Integer> clazz2 = Integer.class;
        Constructor<Integer> cons = clazz2.getConstructor(int.class);
        Integer i = cons.newInstance(123);

        // 我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组：
        Pairs<String>[] ps = null; // ok
        //Pairs<String>[] ps1 = new Pairs<String>[2]; // compile error!

        // 必须通过强制转型实现带泛型的数组：
        @SuppressWarnings("unchecked")
        Pairs<String>[] ps2 = (Pairs<String>[]) new Pairs[2];

        // 使用泛型数组要特别小心，因为数组实际上在运行期没有泛型，编译器可以强制检查变量ps，因为它的类型是泛型数组。
        // 但是，编译器不会检查变量arr，因为它不是泛型数组。因为这两个变量实际上指向同一个数组，
        // 所以，操作arr可能导致从ps获取元素时报错，例如，以下代码演示了不安全地使用带泛型的数组：
        Pairs[] arr = new Pairs[2];
        Pairs<String>[] ps3 = (Pairs<String>[]) arr;
        ps3[0] = new Pairs<String>("a", "b");
        arr[1] = new Pairs<Integer>(1, 2);
        Pairs<String> p = ps3[1];
        // String s = p.getFirst(); //Integer cannot be cast to String

        // 要想安全的使用泛型数组，必须扔掉arr的引用
        @SuppressWarnings("unchecked")
        Pairs<String>[] ps4 = (Pairs<String>[]) new Pairs[2];
        // 由于拿不到原始数组的引用，就只能对泛型数组ps进行操作，这种操作就是安全的。

        String[] ss = ArrayHelper.asArray("a", "b", "c");
        Integer[] ns = ArrayHelper.asArray(1, 2, 3);
    }
}

// 带泛型的数组实际上是编译器的类型擦除：
// 所以我们不能直接创建泛型数组T[]，因为擦拭后代码变为Object[]：
// public class Abc<T> {
//     T[] createArray() {
//         return new T[5]; // 编译报错
//     }
// }

// 必须借助Class<T>来创建泛型数组：
class Abc<T> {
    T[] createArray(Class<T> cls) {
        return (T[]) Array.newInstance(cls, 5);
    }
}

//我们还可以利用可变参数创建泛型数组T[]：
class ArrayHelper {
    @SafeVarargs
    static <T> T[] asArray(T... objs) {
        return objs;
    }
}