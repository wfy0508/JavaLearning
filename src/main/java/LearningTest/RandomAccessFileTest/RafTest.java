package LearningTest.RandomAccessFileTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author summer
 * @title: RAFTest
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 11/21/21 19:01
 */
public class RafTest {
    @Test
    public void test1() {
        // 1. 创建随机读取和写入流
        RandomAccessFile rar = null;
        RandomAccessFile raw = null;
        try {
            rar = new RandomAccessFile(new File("hello1.txt"), "r");
            raw = new RandomAccessFile(new File("hello2.txt"), "rw");

            byte[] charArray = new byte[1024];
            int len;
            // 2. 读取和写入数据
            while ((len = rar.read(charArray)) != -1) {
                raw.write(charArray, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭流
            if (rar != null) {
                try {
                    rar.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raw != null) {
                try {
                    raw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile rar = new RandomAccessFile(new File("hello1.txt"), "rw");
        // 将指针移动到3的位置开始操作
        rar.seek(3);
        // 写入操作为：有数据则替换原有数据为目标数据，无数据则写入新的元素
        rar.write("xyz".getBytes(StandardCharsets.UTF_8));
        rar.close();
    }

    /**
     * 使用RandomAccessFile实现插入数据
     */
    @Test
    public void test3() throws IOException {
        // 1. 创建一个随机读取流
        RandomAccessFile rar = new RandomAccessFile(new File("hello1.txt"), "rw");

        // 2. 设置初始读取位置
        rar.seek(3);

        // 3. 先将位置3以后的内容放入StringBuilder中
        StringBuilder sb = new StringBuilder((int) new File("hello1.txt").length());
        byte[] buffer = new byte[1024];
        int len;
        while ((len = rar.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));
        }

        // 4. 调回指针，先插入新的内容
        rar.seek(3);
        rar.write("xxx".getBytes(StandardCharsets.UTF_8));
        // 5. 在插入原来3位置以后的数据
        rar.write(sb.toString().getBytes(StandardCharsets.UTF_8));

        // 6. 关闭流
        rar.close();
    }
}
