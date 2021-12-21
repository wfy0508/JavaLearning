package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/15 11:22
*/

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Summer
 * 处理流之二：转换流的使用
 * 1 字符流：
 * 1.1. InputStreamReader 将一个字节的输入流转换为字符的输入流
 * 1.2. OutputStreamWriter 将一个字符的输出流转换为字节的输出流
 * 2 作用：提供字节流到字符流的转换
 * 3 解码：字节、字节数组 --> 字符、字符串
 * 4 编码：字符、字符串 --> 字节、字节数组
 */
public class TransferStreamTest {
    @Test
    public void test() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("hello1.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            FileOutputStream fos = new FileOutputStream("hello2.txt");
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            char[] charBuffer = new char[5];
            int len;
            while ((len = isr.read(charBuffer)) != -1) {
                osw.write(charBuffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
