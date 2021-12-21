package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/15 8:52
*/

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author Summer
 */
public class WordCountTest {

    @Test
    public void test() throws IOException {
        // 1. 创建一个Map，用于存储每个值和出现的次数
        HashMap<Character, Integer> map = new HashMap<>(16);
        FileReader fr = null;
        BufferedWriter bw = null;

        try {
            // 2. 创建一个读取流
            fr = new FileReader("test1.txt");
            int c = 0;
            // 3. 逐一读取每个字符，如果不存在就新增，存在就+1
            while ((c = fr.read()) != -1) {
                char ch = (char) c;
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            // 4. 创建Writer
            bw = new BufferedWriter(new FileWriter(new File("wordCount.txt")));

            // 5. 遍历map，将数据写入wordCount.txt
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();

            for (Map.Entry<Character, Integer> iter : entrySet) {
                switch (iter.getKey()) {
                    case ' ' :
                        bw.write("空格=" + iter.getValue());
                        break;
                    case '\t' :
                        bw.write("tab键=" + iter.getValue());
                        break;
                    case '\n' :
                        bw.write("换行符=" + iter.getValue());
                        break;
                    case '\r' :
                        bw.write("回车键=" + iter.getValue());
                        break;
                    default :
                        bw.write(iter.getKey() + "=" + iter.getValue());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    // 6. 关闭资源
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}