package Liaoxuefeng.hIO;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 10:34
 */

public class inputStream {
    public static void main(String[] args) throws IOException {
        // try(resource)语法
        try (InputStream inputStream = new FileInputStream("D:\\hadoop_test\\input\\little1.txt")) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println(n);
            }
        }
        // 实际上，编译器并不会特别地为InputStream加上自动关闭。
        // 编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，
        // 如果实现了，就自动加上finally语句并调用close()方法。
        // InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。

        // 在读取流的时候，一次读取一个字节并不是最高效的方法。
        // 很多流支持一次性读取多个字节到缓冲区，对于文件和网络流来说，利用缓冲区一次性读取多个字节效率往往要高很多。
        // InputStream提供了两个重载方法来支持读取多个字节：
        // 1. int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
        // 2. int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
        try (InputStream inputStream = new FileInputStream("D:\\hadoop_test\\input\\little1.txt")) {
            byte[] buffer = new byte[1000];
            int n;
            while ((n = inputStream.read(buffer)) != -1) {
                System.out.println("read " + n + " bytes");
            }
        }

        // 阻塞：必须要等read执行完后，才能执行下一行代码

        // 用FileInputStream可以从文件获取输入流，这是InputStream常用的一个实现类。
        // 此外，ByteArrayInputStream可以在内存中模拟一个InputStream
        byte[] data = {23, 56, 3, 23, 2, 34, 56, 45, 44};
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println((char)n);
            }
        }

        // 从文件中读取所有字节，并转换成char然后拼成一个字符串
        String s;
        try (InputStream inputStream = new FileInputStream("D:\\hadoop_test\\input\\little1.txt")) {
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            while ((n = inputStream.read()) != -1) {
                stringBuilder.append((char)n);
            }
            s = stringBuilder.toString();
        }
        System.out.println(s);

    }
}