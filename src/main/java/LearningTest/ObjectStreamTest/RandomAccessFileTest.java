package LearningTest.ObjectStreamTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Summer
 * @PROJECT_NAME: LearningTest.ObjectStreamTest
 * @USER: Summer
 * @Create Time: 2021/9/25 19:51
 * <p>
 * RandomAccessFile 随机读写文件
 * RandomAccessFile 直接继承于java.lang.Object，实现了DataInput和DataOutput接口
 * 即可以做输入流，也可以做输出流
 */
public class RandomAccessFileTest {

    @Test
    public void test() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            // 1. 创建输入流，mode为r：以只读方式打开文件
            //"r"   Open for reading only
            //"rw"  Open for reading and writing
            //"rws" Open for reading and writing
            //"rwd" Open for reading and writing
            raf1 = new RandomAccessFile(new File("google.jpg"), "r");
            // 2. 创建输出流，mode为rw
            raf2 = new RandomAccessFile(new File("google1.jpg"), "rw");

            byte[] bytes = new byte[5];
            int len;

            // 3. 读取并写入数据
            while ((len = raf1.read(bytes)) != -1) {
                raf2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
