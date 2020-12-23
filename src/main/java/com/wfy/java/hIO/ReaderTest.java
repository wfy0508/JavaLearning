package com.wfy.java.hIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 15:46
 */

public class ReaderTest {
    public static void main(String[] args) throws IOException {

        // 1. FileReader
        try (FileReader reader = new FileReader("D:\\hadoop_test\\java_input.txt", StandardCharsets.UTF_8)) {
            for (; ; ) {
                int n = reader.read(); // 一次性读取一个字符，并返回字符表示的int
                if (n != -1) {
                    System.out.println((char) n);
                } else {
                    break;
                }
            }
        }

        try (FileReader reader = new FileReader("D:\\hadoop_test\\java_input.txt", StandardCharsets.UTF_8)) {
            char[] buffer = new char[1000]; // 一次性读取若干字符
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }

        // CharArrayReader
        try (Reader reader = new CharArrayReader("Hello".toCharArray())) {
            char[] buffer = new char[10];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read: " + n + " chars.");
            }
        }

        // StringReader和CharArrayReader类似
        Reader reader = new StringReader("Hello");

        // InputStreamReader
        // Reader和InputStream有什么关系？
        // 除了特殊的CharArrayReader和StringReader，
        // 普通的Reader实际上是基于InputStream构造的，
        // 因为Reader需要从InputStream中读入字节流（byte），
        // 然后，根据编码设置，再转换为char就可以实现字符流。
        // 如果我们查看FileReader的源码，它在内部实际上持有一个FileInputStream。
        // 既然Reader本质上是一个基于InputStream的byte到char的转换器，
        // 那么，如果我们已经有一个InputStream，想把它转换为Reader，是完全可行的。
        // InputStreamReader就是这样一个转换器，它可以把任何InputStream转换为Reader。示例代码如下：
        // 持有InputStream
        FileInputStream inputStream = new FileInputStream("D:\\hadoop_test\\java_input.txt");
        // 变为Reader
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

    }
}
