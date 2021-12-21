package Liaoxuefeng.fGeneric;

/*
 * @Author wfy
 * @Date 2020/10/30 11:05
 * com.wfy.java.fGeneric
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeErasure {
    public static void main(String[] args) {
        // 使用泛型的时候，我们编写的代码也是编译器看到的代码：
        Pair2<String> p = new Pair2<>("Hello", "World");
        String first = p.getFirst();
        String second = p.getLast();
        // 而虚拟机执行的代码并没有泛型：
        // Pair p = new Pair("Hello", "world");
        // String first = (String) p.getFirst();
        // String last = (String) p.getLast();
        // 所以，Java的泛型是由编译器在编译时实行的，编译器内部永远把所有类型T视为Object处理，
        // 但是，在需要转型的时候，编译器会根据T的类型自动为我们实行安全地强制转型。

        // 了解了Java泛型的实现方式——擦拭法，我们就知道了Java泛型的局限：
        // **1**. <T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型：
        // Pair2<int> p = new Pair2<>(1, 2); // 编译错误

        // **2**. 无法取得带泛型的Class。
        Pair2<String> p1 = new Pair2<>("hello", "world");
        Pair2<Integer> p2 = new Pair2<>(1, 2);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1 == c2); // true
        System.out.println(c1 == Pair2.class); // true
        // 因为T是Object，我们对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class。
        // 换句话说，所有泛型实例，无论T的类型是什么，getClass()返回同一个Class实例，因为编译后它们全部都是Pair<Object>。

        // **3**. 无法判断带泛型的类型
        Pair2<Integer> p3 = new Pair2<>(123, 456);
        // if( p3 instanceof Pair2<String> ){} // 无法判断p3是不是Pair2<String>
        // 原因和前面一样，并不存在Pair<String>.class，而是只有唯一的Pair.class。

        // **4**. 不能实例化T类型
        // 不能使用new T()来实例化，因为会被擦除为new Object()
        // 这样一来，创建new Pair<String>()和创建new Pair<Integer>()就全部成了Object，显然编译器要阻止这种类型不对的代码。

        // 泛型继承（子类没有泛型，可以正常实例化）
        IntPair ip = new IntPair(1, 2);
        // 前面讲了，我们无法获取Pair<T>的T类型，即给定一个变量Pair<Integer> p，无法从p中获取到Integer类型。
        // 但是，在父类是泛型类型的情况下，编译器就必须把类型T（对IntPair来说，也就是Integer类型）保存到子类的class文件中，
        // 不然编译器就不知道IntPair只能存取Integer这种类型。
        // 在继承了泛型类型的情况下，子类可以获取父类的泛型类型。
        // 例如：IntPair可以获取到父类的泛型类型Integer。获取父类的泛型类型代码比较复杂：
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }

    }
}

// 泛型是一种类似”模板代码“的技术，不同语言的泛型实现方式不一定相同。
// Java语言的泛型实现方式是擦拭法（Type Erasure）。
// 所谓擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的。
// 例如，我们编写了一个泛型类Pair<T>，这是编译器看到的代码：
class Pair2<T> {
    private T first;
    private T last;

    public Pair2(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
// 而虚拟机根本不知道泛型。会将T转换为Object
// Java使用擦拭法实现泛型，导致了：
// 1. 编译器把类型<T>视为Object；
// 2. 编译器根据<T>实现安全的强制转型。

// 泛型继承
// 一个类可以继承自一个泛型类。例如：父类的类型是Pair<Integer>，子类的类型是IntPair，可以这么继承：
class IntPair extends Pair2<Integer> {

    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}
