package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/16 10:39
*/

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author Summer
 */
public class StdIOTest {

    @Test
    public void test() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            ps = new PrintStream(fos);
            // 重新设置输出，而不会执行下面的println输出到控制台
            System.setOut(ps);

            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}
