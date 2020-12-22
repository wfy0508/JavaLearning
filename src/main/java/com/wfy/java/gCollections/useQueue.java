package com.wfy.java.gCollections;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 14:46
 */

public class useQueue {
    public static void main(String[] args) {
        // 在Java的标准库中，队列接口Queue定义了以下几个方法：
        // 1. int size()：获取队列长度；
        // 2. boolean add(E)/boolean offer(E)：添加元素到队尾；
        // 3. E remove()/E poll()：获取队首元素并从队列中删除；
        // 3. E element()/E peek()：获取队首元素但并不从队列中删除。
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.add("hello")); // 如果超出队列长度会抛出异常
        System.out.println(queue.offer("world"));
        System.out.println(queue.offer("java")); // 如果超出队列长度，不会报错而是会返回false
        System.out.println(queue.remove("hello"));
        System.out.println(queue.peek()); // 取出队首元素world，但不删除
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll()); // 队列已经没有元素，使用poll不会报错，但是会返回null，所以不要在队列尾部添加null
        // System.out.println(queue.remove()); // 使用remove就会抛出异常 NoSuchElementException

        // LinkedList即实现了List接口，又实现了Queue接口，
        // 如果我们把它当作List，就获取List的引用，
        List<String> list = new LinkedList<>();

        // 如果我们把它当作Queue，就获取Queue的引用
        Queue<String> queue1 = new LinkedList<>();


    }
}
