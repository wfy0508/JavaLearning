package com.wfy.java.gCollections;

import java.util.*;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 10:58
 */

public class setExercise {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "hello"),
                new Message(3, "Nice to meet you!"),
                new Message(2, "hello")
        );

        List<Message> process = process(received);
        for (Message message : process) {
            System.out.println(message);
        }
    }

    static List<Message> process(List<Message> received) {
        TreeSet<Message> set = new TreeSet<>(new Comparator<Message>() {
            public int compare(Message m1, Message m2) {
                return m1.sequence - m2.sequence;
            }
        });

        set.addAll(received);

        return new ArrayList<>(set);
    }
}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public String toString() {
        return sequence + "\t" + text;
    }
}
