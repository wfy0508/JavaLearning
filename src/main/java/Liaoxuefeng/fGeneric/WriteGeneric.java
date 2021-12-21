package Liaoxuefeng.fGeneric;

/*
 * @Author wfy
 * @Date 2020/10/27 15:34
 * com.wfy.java.fGeneric
 */

public class WriteGeneric {
    public static void main(String[] args) {
        // 使用定义个多个泛型类型
        MultiGenericPair<String, Integer> mgp = new MultiGenericPair<>("test", 123);
        System.out.println(mgp);
    }

    // 编写泛型类时，要特别注意，泛型类型<T>不能用于静态方法。例如：
    // static GenericPair<T> create(T first, T second) {
    //     return new GenericPair<T>(first, second);
    // }

    // 上述代码会导致编译错误，无法在静态方法create()的方法参数和返回类型上使用泛型类型T
    // 在网上搜索发现，可以在static修饰符后面加一个<T>，编译就能通过：
    // 但实际上，这个<T>和Pair<T>类型的<T>已经没有任何关系了。
    static <T> GenericPair<T> create1(T first, T second) {
        return new GenericPair<T>(first, second);
    }

    // 对于静态方法，我们可以单独改写为“泛型”方法，只需要使用另一个类型即可。
    // 对于上面的create()静态方法，我们应该把它改为另一种泛型类型，例如，<K>：
    // 这样才能清楚地将静态方法的泛型类型和实例类型的泛型类型区分开。
    static <K> GenericPair<K> create(K first, K second) {
        return new GenericPair<K>(first, second);
    }

}

// 编写泛型前，先创建一个类
class Pair {
    private String first;
    private String second;

    public Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}

// 将其中的特定类型（这里是String）全部转换为T
class GenericPair<T> {
    private T first;
    private T second;

    public GenericPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

}

// 还可以定义多个泛型类型
class MultiGenericPair<T, K> {
    private T first;
    private K second;

    public MultiGenericPair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    public String toString() {
        return "first: " + first + ", second: " + second;
    }
}