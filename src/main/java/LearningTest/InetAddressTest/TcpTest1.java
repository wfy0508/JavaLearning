package LearningTest.InetAddressTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author summer
 * @title: TcpTest1
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 12/11/21 22:01
 * 客户端给服务器发文件，服务器将文件保存在本地
 */
public class TcpTest1 {
    @Test
    public void client1() throws IOException {
        // 指定一个服务器ip和port
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        // 创建一个输出流
        OutputStream os = socket.getOutputStream();
        // 指定一个输出文件
        FileInputStream fis = new FileInputStream(new File("google.jpg"));
        byte[] buffer = new byte[1024];
        int len;

        // 将指定的输出文件写出去
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //关闭资源
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server1() throws IOException {
        // 从服务器指定端口获取数据
        ServerSocket ss = new ServerSocket(9090);
        // 接收数据
        Socket socket = ss.accept();
        // 创建一个获取输入流
        InputStream is = socket.getInputStream();
        // 指定输出的文件
        FileOutputStream fos = new FileOutputStream(new File("google_tcp.jpg"));
        byte[] buffer = new byte[1024];
        int len;

        // 将接收的数据写入到指定的文件
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 关闭资源
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
