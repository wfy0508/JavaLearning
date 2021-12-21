package LearningTest.CollectionsTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/18 18:43
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    /**
     * List常用方法
     */
    @Test
    public void test() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.add("AA");
        list.add("BB");
        list.add(new Person("Tom", 20));
        System.out.println(list);

        // add(int index, Collection eles)
        list.add(1, "CC");
        System.out.println(list);

        // addAll
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        System.out.println(list.size());

        // get
        System.out.println(list.get(1));

        // index: 不存在就返回-1
        System.out.println(list.indexOf("BB"));

        // lastIndexOf
        System.out.println(list.lastIndexOf("BB"));

        // remove
        list.remove(1);
        System.out.println(list);

        // set
        list.set(3, new Person("Tom", 33));
        System.out.println(list);

        // sublist
        System.out.println(list.subList(2, 4));
    }
}
