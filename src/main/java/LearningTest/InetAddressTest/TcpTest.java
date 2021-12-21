package LearningTest.InetAddressTest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author summer
 * @title: TcpTest
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 12/5/21 19:30
 */
public class TcpTest {

    /**
     * 客户端
     */
    @Test
    public void client1() {
        OutputStream os = null;
        Socket socket = null;
        try {
            // 指定服务器的地址
            InetAddress inet1 = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet1, 59999);

            os = socket.getOutputStream();
            os.write("哈喽，我是客户端！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 服务器
     */
    @Test
    public void server1() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1. 创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(59999);
            // 2. 调用accept()方法，表示接收客户端的socket
            socket = ss.accept();
            // 3. 获取输入流
            is = socket.getInputStream();
            // 4. 读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            // 5. 将数据输出到控制台
            System.out.println(baos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress().toString() + "发送的数据！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
