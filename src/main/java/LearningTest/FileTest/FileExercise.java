package LearningTest.FileTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/7 18:45
*/

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Summer
 */
public class FileExercise {

    @Test
    public void test() throws IOException {
        // 在hello.txt同目录下创建hello1.txt
        File file1 = new File("D:\\Learning\\Workspace\\FileTest\\parent\\son\\hello1.txt");
        File file2 = new File(file1.getParent(), "hello1.txt");
        boolean newFile = file2.createNewFile();
        System.out.println(newFile);
    }
}
