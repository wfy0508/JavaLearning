package Liaoxuefeng.fGeneric;

/*
 * @Author wfy
 * @Date 2020/10/27 14:45
 * com.wfy.java.fGeneric
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UseGeneric {
    public static void main(String[] args) {
        //使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object：
        List list = new ArrayList();
        list.add("Hello");
        list.add(123);
        String first = (String) list.get(0);
        Integer second = (Integer) list.get(1);
        System.out.println("first: " + first + ", second: " + second);
        // 此时，只能把<T>当作Object使用，没有发挥泛型的优势。
        // 当我们定义泛型类型<String>后，List<T>的泛型接口变为强类型List<String>：
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Hello");
        strList.add("world");
        String s1 = strList.get(0); // 无需转型
        String s2 = strList.get(1); // 无需转型

        // 当我们定义泛型类型<Number>后，List<T>的泛型接口变为强类型List<Number>：
        List<Number> numberList = new ArrayList<Number>();
        numberList.add(123);
        numberList.add(123.456);
        Number num1 = numberList.get(0);
        Number num2 = numberList.get(1);

        // 编译器如果能自动推断出泛型类型，就可以省略后面的泛型类型。
        List<Number> numberList1 = new ArrayList<>();

        // 除了ArrayList<T>使用了泛型，还可以在接口中使用泛型。
        // 例如，Arrays.sort(Object[])可以对任意数组进行排序，但待排序的元素必须实现Comparable<T>这个泛型接口：
        String[] ss = new String[]{"Orange", "Apple", "Pear"};
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));

        // 这是因为String本身已经实现了Comparable<String>接口。如果换成我们自定义的Person类型试试：
        Person[] p = new Person[]{
                new Person("Tom", 20),
                new Person("Lucky", 15),
                new Person("Jack", 30)
        };
        Arrays.sort(p); // 没有实现Comparable时，无法将Person转型为Comparable
        System.out.println(Arrays.toString(p));

    }
}

class Person implements Comparable<Person> {
    private String name = "";
    private int score = 0;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return this.name + " " + this.score;
    }

    @Override
    public int compareTo(@NotNull Person o) {
        return this.name.compareTo(o.name);
    }
}
