package Liaoxuefeng.hIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 11:22
 */

public class outputStream {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\hadoop_test\\java_output.txt");
        outputStream.write(72);
        outputStream.write(101);
        outputStream.write(108);
        outputStream.write(108);
        outputStream.write(111);


        // 逐个写入太麻烦，可以一次写入
        outputStream.write(" World!".getBytes(StandardCharsets.UTF_8));

        // 关闭资源
        outputStream.close();

        // 使用try(resource)方式写入，不管是否发生异常，都会自动添加finally并调用close()
        try (OutputStream outputStream1 = new FileOutputStream("D:\\hadoop_test\\java_output.txt")) {
            outputStream1.write("try: Hello world!".getBytes(StandardCharsets.UTF_8));
        }

        // 和InputStream一样，OutputStream的write()方法也是阻塞的。

        // OutputStream实现类
        // 用FileOutputStream可以从文件获取输出流，这是OutputStream常用的一个实现类。
        // 此外，ByteArrayOutputStream可以在内存中模拟一个OutputStream
        byte[] data;
        try (ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream()) {
            outputStream2.write("Hello".getBytes(StandardCharsets.UTF_8));
            outputStream2.write(" world.".getBytes(StandardCharsets.UTF_8));
            data = outputStream2.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));

        // ByteArrayOutputStream实际上是把一个byte[]数组在内存中变成一个OutputStream，
        // 虽然实际应用不多，但测试的时候，可以用它来构造一个OutputStream。
        // 同时操作多个AutoCloseable资源时，在try(resource) { ... }语句中可以同时写出多个资源，用;隔开。
        // 例如，同时读写两个文件：
        try (InputStream inputStream3 = new FileInputStream("D:\\hadoop_test\\java_input.txt");
             OutputStream outputStream3 = new FileOutputStream("D:\\hadoop_test\\java_output.txt")) {
            inputStream3.transferTo(outputStream3);
        }


    }
}
