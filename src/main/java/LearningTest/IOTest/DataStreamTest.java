package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/16 11:08
*/

import org.junit.Test;

import java.io.*;

/**
 * @author Summer
 */
public class DataStreamTest {

    @Test
    public void test() {
        // 使用DataOutputStream将数据写入文件
        DataOutputStream dos = null;
        try {
            //DataInputStream dis = new DataInputStream(System.in);
            dos = new DataOutputStream(new FileOutputStream("dataOutput.txt"));
            dos.writeUTF("Tom");
            // 每刷新一次就会写入到磁盘
            dos.flush();

            dos.write(23);
            dos.flush();

            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1() throws IOException {
        // 使用DataInputStream从文件读取数据
        // 将文件中存储的基本类型的变量和字符串读入到内存，保存到变量中
        // 注意：读出的顺序要和写入的顺序一致！！！
        DataInputStream dis = new DataInputStream(new FileInputStream("dataOutput.txt"));
        String name = dis.readUTF();
        int age = dis.read();
        boolean isMale = dis.readBoolean();
        System.out.println(name);
        System.out.println(age);
        System.out.println(isMale);

        dis.close();
    }
}
