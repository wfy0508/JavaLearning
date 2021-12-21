package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/15 10:17
*/

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Summer
 */
public class WordCount1Test {

    @Test
    public void wordCountTest() {
        // 1. 创建一个Map用于存放统计值
        HashMap<Character, Integer> map = new HashMap<>(16);
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 2. 创建一个文件读取流
            br = new BufferedReader(new FileReader(new File("test1.txt")));
            // 3. 遍历文件，读取每一个字符，并存入Map中
            // 定义一个整形变量，用于存放读取的值
            int c = 0;
            while ((c = br.read()) != -1) {
                char ch = (char) c;
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            // 5. 遍历Map，处理特殊字符并写入输出流
            bw = new BufferedWriter(new FileWriter(new File("wordCount1.txt")));
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行符=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车键=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {// 6. 关闭资源
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
