package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/14 16:17
*/

import org.junit.Test;

import java.io.*;

/**
 * @author Summer
 * <p>
 * 缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 */
public class BufferedStreamTest {

    /**
     * 复制一个非文本文件
     */
    @Test
    public void test() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File("google.jpg");
            File destFile = new File("google2.jpg");
            // 2. 造流
            // 2.1 读取和写入流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 读取和写入操作
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            // 先关外层，再关内层
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 外层关闭的同时，内层流也会自动关闭，所以可以省略内层流的关闭操作
            //fos.close();
            //fis.close();
        }
    }

    /**
     * 实现文件复制的方法
     */
    public void copyFileWithBuffered(String srcPath, String desPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(desPath);
            // 2. 造流
            // 2.1 读取和写入流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 读取和写入操作
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            // 先关外层，再关内层
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 外层关闭的同时，内层流也会自动关闭，所以可以省略内层流的关闭操作
            //fos.close();
            //fis.close();
        }
    }

    /**
     * 字节流和缓冲流复制文件速度对比
     */
    @Test
    public void test1() throws IOException {
        // 1. 执行输入输出文件
        String srcPath = "D:\\Learning\\Workspace\\AlgorithmLearning\\google.jpg";
        String destPath = "D:\\Learning\\Workspace\\AlgorithmLearning\\google1.jpg";
        String destPath1 = "D:\\Learning\\Workspace\\AlgorithmLearning\\google2.jpg";

        // 字节流复制 23778
        long byteStart = System.currentTimeMillis();
        FileReaderWriterTest byteStreamTest = new FileReaderWriterTest();
        byteStreamTest.copyFile(srcPath, destPath);
        long byteEnd = System.currentTimeMillis();
        System.out.println("字符流复制花费时间：" + (byteEnd - byteStart));

        // 缓冲流复制 286
        long bufferedStart = System.currentTimeMillis();
        copyFileWithBuffered(srcPath, destPath1);
        long bufferedEnd = System.currentTimeMillis();
        System.out.println("缓冲流复制花费时间：" + (bufferedEnd - bufferedStart));

    }
}
