package com.wfy.java.gCollections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 15:04
 */

public class usePriorityQueue {
    public static void main(String[] args) {
        // PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，
        // 对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
        // 要使用PriorityQueue，我们就必须给每个元素定义“优先级”。
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("pear");
        priorityQueue.offer("banana");
        priorityQueue.offer("apple");
        System.out.println(priorityQueue.poll()); // apple
        System.out.println(priorityQueue.poll()); // banana
        System.out.println(priorityQueue.poll()); // pear
        System.out.println(priorityQueue.poll()); // null
        System.out.println("-------------------------");

        // 输出结果是按照字母排序后的顺序，而不是入队列的顺序

        // 因此，放入PriorityQueue的元素，必须实现Comparable接口，
        // PriorityQueue会根据元素的排序顺序决定出队的优先级。
        // 如果我们要放入的元素并没有实现Comparable接口怎么办？
        // PriorityQueue允许我们提供一个Comparator对象来判断两个元素的顺序。
        // 我们以银行排队业务为例，实现一个PriorityQueue

        // 实现PriorityQueue的关键在于提供的UserComparator对象，它负责比较两个元素的大小（较小的在前）。
        // UserComparator总是把V开头的号码优先返回，只有在开头相同的时候，才比较号码大小。
        Queue<User> users = new PriorityQueue<>(new UserPriority());
        users.offer(new User("Bob", "A2"));
        users.offer(new User("Jack", "A1"));
        users.offer(new User("Lucy", "V1"));
        System.out.println(users.poll()); // Lucy  V1
        System.out.println(users.poll()); // Jack   A1
        System.out.println(users.poll()); // Bob    A2
        System.out.println(users.poll());
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return name + "\t" + number;
    }
}

class UserPriority implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            return u1.number.compareTo(u2.number);
        }
        // V开头的优先级最高
        if (u1.number.charAt(0) == 'V') {
            return -1;
        } else {
            return 1;
        }
    }

}