package Liaoxuefeng.hIO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 9:40
 */

public class FileObject {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\hadoop_test\\input\\little1.txt");
        System.out.println(file);
        // File对象有3种形式表示的路径，
        // 一种是getPath()，返回构造方法传入的路径，
        // 一种是getAbsolutePath()，返回绝对路径，
        // 一种是getCanonicalPath，它和绝对路径类似，但是返回的是规范路径。
        File file1 = new File("..");
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalPath());
        System.out.println(File.separator); // 系统分隔符

        // File对象既可以表示文件，也可以表示目录。
        // 特别要注意的是，构造一个File对象，即使传入的文件或目录不存在，代码也不会出错，
        // 因为构造一个File对象，并不会导致任何磁盘操作。
        // 只有当我们调用File对象的某些方法的时候，才真正进行磁盘操作。
        System.out.println(file1.isFile()); // false
        System.out.println(file1.isDirectory()); // true
        System.out.println(file1.canRead()); // true
        System.out.println(file1.canWrite()); // true

        // 有些时候，程序需要读写一些临时文件，
        // File对象提供了createTempFile()来创建一个临时文件，
        // 以及deleteOnExit()在JVM退出时自动删除该文件。
        File tempFile = File.createTempFile("tmp-", ".txt");
        tempFile.deleteOnExit(); // JVM退出时删除
        System.out.println(tempFile.isFile());
        System.out.println(tempFile.getAbsolutePath());

        // 当File对象表示一个目录时，可以使用list()和listFiles()列出目录下的文件和子目录名。
        // listFiles()提供了一系列重载方法，可以过滤不想要的文件和目录：
        File file2 = new File("C:\\Windows");
        File[] files = file2.listFiles();
        printFiles(files);
        File[] listFiles = file2.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe");
            }
        });
        printFiles(listFiles);

        // 和文件操作类似，File对象如果表示一个目录，可以通过以下方法创建和删除目录：
        // 1. boolean mkdir()：创建当前File对象表示的目录；
        // 2. boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
        // 3. boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。

        // Java标准库还提供了一个Path对象，它位于java.nio.file包。Path对象和File对象类似，但操作更加简单：
        Path path = Paths.get(".", "project", "study");
        System.out.println(path);
        Path path1 = path.toAbsolutePath();
        System.out.println(path1);
        Path path2 = path1.normalize(); // 转换为规范路径
        File file3 = path2.toFile(); // 转换为file对象
        System.out.println(file3);
        for (Path path3 : Paths.get("..").toAbsolutePath()) {
            System.out.println(path3);
        }
    }

    static void printFiles(File[] files) {
        System.out.println("----------------");
        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
        }
        System.out.println("----------------");
    }
}
