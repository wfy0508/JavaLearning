package Liaoxuefeng.gCollections;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 16:55
 */

public class useIterator {
    public static void main(String[] args) {
        // Java的集合类都可以使用for each循环，List、Set和Queue会迭代每个元素，Map会迭代每个key。以List为例：
        List<String> list = List.of("Apple", "Google", "Microsoft");
        for (String s : list) {
            System.out.println(s);
        }

        // 实际上，Java编译器并不知道如何遍历List。
        // 上述代码能够编译通过，只是因为编译器把for each循环通过Iterator改写为了普通的for循环
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }

        // 把这种通过Iterator对象遍历集合的模式称为迭代器。
        // 使用迭代器的好处在于，调用方总是以统一的方式遍历各种集合类型，而不必关系它们内部的存储结构。


        // 如果我们自己编写了一个集合类，想要使用for each循环，只需满足以下条件：
        // 集合类实现Iterable接口，该接口要求返回一个Iterator对象；
        // 用Iterator对象迭代集合内部数据。
        // 这里的关键在于，集合类通过调用iterator()方法，返回一个Iterator对象，这个对象必须自己知道如何遍历该集合。
        //一个简单的Iterator示例如下，它总是以倒序遍历集合：
        ReverseList<String> reverseList = new ReverseList<>();
        reverseList.add("apple");
        reverseList.add("pear");
        reverseList.add("orange");
        for (String s : reverseList) {
            System.out.println(s);
        }

        // 虽然ReverseList和ReverseIterator的实现类稍微比较复杂，
        // 但是，注意到这是底层集合库，只需编写一次。
        // 而调用方则完全按for each循环编写代码，根本不需要知道集合内部的存储逻辑和遍历逻辑。
        // 在编写Iterator的时候，我们通常可以用一个内部类来实现Iterator接口，
        // 这个内部类可以直接访问对应的外部类的所有字段和方法。
        // 例如，上述代码中，内部类ReverseIterator可以用ReverseList.this获得当前外部类的this引用，
        // 然后，通过这个this引用就可以访问ReverseList的所有字段和方法。
    }
}

class ReverseList<T> implements Iterable<T> {
    private List<T> list = new ArrayList<>();

    public void add(T t){
        list.add(t);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        ReverseIterator(int index) {
            this.index = index;
        }


        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}
