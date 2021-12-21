package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/14 17:14
*/

import org.junit.Test;

import java.io.*;

/**
 * @author Summer
 * <p>
 * BufferedReader
 * BufferedWriter
 * FileReader
 * FileWriter
 */
public class BufferedReaderAndBufferedWriterTest {

    @Test
    public void test() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 1. 创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("test1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("test2.txt")));

            // 2.1 方式一：读取字符数据使用char数组
//            char[] charBuffer = new char[1024];
//            int len;
//            while ((len = br.read(charBuffer)) != -1) {
//                bw.write(charBuffer, 0, len);
//            }

            // 2.2 方式二：读取String
            String data;
            while ((data = br.readLine()) != null) {
                // data中不包含换行符，需手动添加一个换行符
                bw.write(data + "\n");
                // 或者创建一个新行
                // bw.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭资源
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
