package Liaoxuefeng.hIO;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 10:19
 */

public class FileObjectExercise {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\hadoop_test");
        String tree = "";
        listDir(file.getCanonicalFile(), tree);
    }

    static void listDir(File dir, String t) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(t + file.getName());
                if (file.isDirectory()) {
                    listDir(file, t+"\t");
                }
            }
        }
    }
}
