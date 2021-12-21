package LearningTest.FileTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/3 18:00
*/

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Summer
 */
public class FileTest {

    @Test
    public void test() throws IOException {
        // 相对路径
        File file1 = new File("jdbc.properties");
        System.out.println(file1);

        // 绝对路径
        File file2 = new File("D:\\Learning\\Workspace\\AlgorithmLearning\\jdbc.properties");
        System.out.println(file2);

        // 创建文件夹
        File file3 = new File("D:\\Learning\\Workspace\\FileTest");
        boolean mkdir = file3.mkdir();
        System.out.println(mkdir);

        // 如果父文件夹不存在，在一同创建
        File file4 = new File("D:\\Learning\\Workspace\\FileTest\\parent\\son");
        boolean mkdirp = file4.mkdirs();
        System.out.println(mkdirp);

        // 创建文件
        File file5 = new File("D:\\Learning\\Workspace\\FileTest\\parent\\son\\test.txt");
        boolean newFile = file5.createNewFile();
        System.out.println(newFile);

        // 更改文件名称
        boolean b = file5.renameTo(new File("test1.txt"));
        System.out.println(b);

        // 判断是否文件
        System.out.println("是否文件: " + file5.isFile());
        // 判断是否文件夹
        System.out.println("是否文件夹: " + file5.isDirectory());
        // 判断文件是否隐藏
        System.out.println("是否隐藏: " + file5.isHidden());
        // 获取文件名
        System.out.println("获取文件名: " + file5.getName());
        // 删除文件
        System.out.println("删除文件: " + file5.delete());

        File file6 = new File("D:\\Learning\\Workspace\\FileTest\\parent\\son\\hello1.txt");
        File file7 = new File("D:\\Learning\\Workspace\\FileTest\\parent\\son\\world.txt");
        boolean newFile1 = file6.createNewFile();
        boolean newFile2 = file7.createNewFile();
        String parent = file6.getParent();
        File parDir = new File(parent);
        // 列出文件夹下面所有文件（包含隐层文件）
        File[] files = parDir.listFiles();
        for(File file: files){
            System.out.println(file);
        }
    }
}
