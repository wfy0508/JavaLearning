package Liaoxuefeng.fGeneric;

/*
 * @Author wfy
 * @Date 2020/11/1 22:33
 * com.wfy.java.fGeneric
 */


import java.util.Arrays;

public class GenericCareful {
    public static void main(String[] args) {
        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr)); // ok

        String[] firstTwo = pickTwo("one", "two", "three");
        // System.out.println(Arrays.toString(firstTwo)); // ClassCastException
        // 原因还是因为擦拭法，在pickTwo()方法内部，编译器无法检测K[]的正确类型，因此返回了Object[]。

        // 如果仔细观察，可以发现编译器对所有可变泛型参数都会发出警告，
        // 除非确认完全没有问题，才可以用@SafeVarargs消除警告。

        // ※※※ 如果在方法内部创建了泛型数组，最好不要将它返回给外部使用。

    }

    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
}
