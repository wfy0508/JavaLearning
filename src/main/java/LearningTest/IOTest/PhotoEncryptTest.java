package LearningTest.IOTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/9/14 18:39
*/

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Summer
 */
public class PhotoEncryptTest {
    @Test
    public void encryptTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("google.jpg"));
            fos = new FileOutputStream(new File("googleEncrypt.jpg"));

            byte[] byteData = new byte[5];
            int len;
            while ((len = fis.read(byteData)) != -1) {
                for (int i = 0; i < len; i++) {
                    // 异或5, 用于加密
                    byteData[i] = (byte) (byteData[i] ^ 5);
                }
                fos.write(byteData, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void decryptTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("googleEncrypt.jpg"));
            fos = new FileOutputStream(new File("google3.jpg"));

            byte[] byteData = new byte[5];
            int len;
            while ((len = fis.read(byteData)) != -1) {
                for (int i = 0; i < len; i++) {
                    // 异或5, 用于解密
                    byteData[i] = (byte) (byteData[i] ^ 5);
                }
                fos.write(byteData, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
