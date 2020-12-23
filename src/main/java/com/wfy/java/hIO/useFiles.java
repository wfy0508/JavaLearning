package com.wfy.java.hIO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 17:11
 */

public class useFiles {
    public static void main(String[] args) throws IOException {
        // 虽然Files和Paths是java.nio包里面的类，但他俩封装了很多读写文件的简单方法，
        // 例如，我们要把一个文件的全部内容读取为一个byte[]，可以这么写
        byte[] bytes = Files.readAllBytes(Paths.get("D:\\hadoop_test\\java_input.txt"));

        // 如果是文本文件，可以将文件的全部内容读取为String
        String string = Files.readString(Paths.get("D:\\hadoop_test\\java_input.txt"));
        // 指定编码
        String string1 = Files.readString(Paths.get("D:\\hadoop_test\\java_input.txt"), StandardCharsets.UTF_8);
        // 按行读取并返回每行内容:
        List<String> lines = Files.readAllLines(Paths.get("D:\\hadoop_test\\java_input.txt"));

        // 写入文件也很方便
        Files.write(Paths.get("D:\\hadoop_test\\java_output.txt"), bytes);
        // 指定编码
        Files.writeString(Paths.get("D:\\hadoop_test\\java_output.txt"), "Hello, world!", StandardCharsets.UTF_8);
        // 按照行写入文本
        Files.write(Paths.get("D:\\hadoop_test\\java_output.txt"), lines);

        // 此外，Files工具类还有copy()、delete()、exists()、move()等快捷方法操作文件和目录。
        // 最后需要特别注意的是，Files提供的读写方法，受内存限制，只能读写小文件，例如配置文件等，
        // 不可一次读入几个G的大文件。读写大型文件仍然要使用文件流，每次只读写一部分文件内容。

    }
}
