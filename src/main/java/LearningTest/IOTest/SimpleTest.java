package LearningTest.IOTest;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author summer
 * @title: SimpleTest
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 11/5/21 09:57
 */
public class SimpleTest {
    @Test
    public void test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // 1. 创建文件输入流：
            // InputStreamReader将一个字节的输入流转换为字符的输入流
            FileInputStream fis = new FileInputStream("hello1.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            // 2. 创建文件输出流
            // OutputStreamWriter将一个字符输出流转换为字节输出流
            FileOutputStream fos = new FileOutputStream("Hello.txt");
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            char[] charBuffer = new char[5];
            int len;

            // 3. 读取并写入文件中
            while ((len = isr.read(charBuffer)) != -1) {
                osw.write(charBuffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
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
