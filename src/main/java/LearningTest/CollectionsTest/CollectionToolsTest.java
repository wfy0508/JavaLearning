package LearningTest.CollectionsTest;

import org.junit.Test;

import java.util.*;

/**
 * @author Summer
 */
public class CollectionToolsTest {
    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(234);
        list.add(89);
        list.add(-90);
        list.add(820);
        list.add(-12);
        System.out.println("origin: " + list);

        // sort
        Collections.sort(list);
        System.out.println("sort: " + list);

        //reverse
        Collections.reverse(list);
        System.out.println("reverse: " + list);

        // copy
        // 报异常java.lang.IndexOutOfBoundsException: Source does not fit in dest
        //List<Integer> dest = new ArrayList<>();
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println("dest: " + dest);

        // shuffle
        Collections.shuffle(list);
        System.out.println("shuffle: " + list);

        //frequency
        System.out.println("89出现的次数：" + Collections.frequency(list, 89));

        // max
        System.out.println("max: " + Collections.max(list));

        //min
        System.out.println("min: " + Collections.min(list));

        // swap
        Collections.swap(list, 1, 3);
        System.out.println("swap: " + list);


    }

    @Test
    public void test1(){
        //线程安全控制
        List<Integer> list = new ArrayList<>();
        list.add(234);
        list.add(89);
        list.add(-90);
        list.add(820);
        list.add(-12);

        // 把线程不安全的List转为线程安全的List
        List<Integer> synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList);
    }
}
