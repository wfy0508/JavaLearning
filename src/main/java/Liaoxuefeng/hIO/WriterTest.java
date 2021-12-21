package Liaoxuefeng.hIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 16:58
 */

public class WriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        // Writer是所有字符输出流的超类，它提供的方法主要有：
        // 1. 写入一个字符（0~65535）：void write(int c)；
        // 2. 写入字符数组的所有字符：void write(char[] c)；
        // 3. 写入String表示的所有字符：void write(String s)。

        // FileWriter
        try (Writer writer = new FileWriter("D:\\hadoop_test\\java_output.txt", StandardCharsets.UTF_8)) {
            writer.write("H\n");
            writer.write("Hello\n".toCharArray());
            writer.write("Hello\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CharArrayWriter
        // CharArrayWriter可以在内存中创建一个Writer，
        // 它的作用实际上是构造一个缓冲区，可以写入char，最后得到写入的char[]数组，
        // 这和ByteArrayOutputStream非常类似：
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(65);
            writer.write(66);
            writer.write(67);
            char[] data = writer.toCharArray();
        }

        // StringWriter 和CharArrayWriter类似

        // 除了CharArrayWriter和StringWriter外，
        // 普通的Writer实际上是基于OutputStream构造的，
        // 它接收char，然后在内部自动转换成一个或多个byte，并写入OutputStream。
        // 因此，OutputStreamWriter就是一个将任意的OutputStream转换为Writer的转换器：
        //try (Writer writer = new OutputStreamWriter(new FileOutputStream("readme.txt"), StandardCharsets.UTF_8)) {}
    }
}
