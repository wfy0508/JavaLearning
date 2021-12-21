package Liaoxuefeng.gCollections;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 15:33
 */

public class userDeque {
    public static void main(String[] args) {
        // 双端队列
        Deque<String> q = new LinkedList<>();
        q.offerFirst("W");
        q.offer("O"); // offer实际上是offerLast
        q.offer("R");
        q.offer("L");
        q.offerLast("D");
        System.out.println(q.pollFirst());
        System.out.println(q.pollLast());

        // LinkedList真是一个全能选手，它即是List，又是Queue，还是Deque。
        // 但是我们在使用的时候，总是用特定的接口来引用它，
        // 这是因为持有接口说明代码的抽象层次更高，而且接口本身定义的方法代表了特定的用途。
        // 不推荐的写法:
        LinkedList<String> d1 = new LinkedList<>();
        d1.offerLast("z");
        // 推荐的写法：
        Deque<String> d2 = new LinkedList<>();
        d2.offerLast("z");
        //可见面向抽象编程的一个原则就是：尽量持有接口，而不是具体的实现类。


    }
}
