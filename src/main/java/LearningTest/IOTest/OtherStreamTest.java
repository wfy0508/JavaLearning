package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/15 17:23
*/

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * @author Summer
 * <p>
 * 1. 标准的输入输出流
 * 1.1 System.in: 标准的输入流，默认从键盘输入
 * System.out: 标准的输出流，默认输出到控制台
 * 1.2 System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出
 *
 * 2 练习：
 * 当从标准输入中输入"exit"或"e"时，程序退出
 *  方法一：使用Scanner实现，调用exit()返回一个字符串
 *  方法二：使用System.in实现，System.in --> 转换流 --> 处理流BufferedReader的readLine()方法
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        InputStreamReader irs = null;
        BufferedReader br = null;
        try {
            irs = new InputStreamReader(System.in);
            br = new BufferedReader(irs);
            System.out.println("请输入字符串：");
            while (true) {
                String line = br.readLine();
                if ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
                    System.out.println("程序结束！");
                    break;
                }
                String upperCase = line.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (irs != null) {
                try {
                    irs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
