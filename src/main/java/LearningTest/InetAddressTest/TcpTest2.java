package LearningTest.InetAddressTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author summer
 * @title: TcpTest2
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 12/11/21 22:36
 * 客户端给服务端发送图片，服务端保存到本地，并返回信息给客户端
 */
public class TcpTest2 {

    @Test
    public void client2() throws IOException {
        // 指定接收的服务器ip和port
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
        // 创建一个输出流
        OutputStream os = socket.getOutputStream();
        // 指定读取的文件
        FileInputStream fis = new FileInputStream(new File("google.jpg"));
        // 读取文件并写出文件信息
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        // ！！！由于发送操作为阻塞IO流，发送完成后需关闭输出！！！
        //fis.read: This method blocks until some input is available.
        socket.shutdownOutput();

        // 接收来自服务器的回复
        InputStream is1 = socket.getInputStream();
        // 创建一个接收流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 读取并写入到baos中
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len = is1.read(buffer1)) != -1) {
            baos.write(buffer1, 0, len);
        }
        // 打印输出到控制台
        System.out.println(baos.toString());

        // 关闭资源
        baos.close();
        is1.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server2() throws IOException {
        // 指定接收端口
        ServerSocket ss = new ServerSocket(9999);
        // 指定为接收
        Socket socket = ss.accept();
        // 设定一个读取流
        InputStream is = socket.getInputStream();
        // 设定保存文件名
        FileOutputStream fos = new FileOutputStream(new File("google_tcp1.jpg"));
        // 读取并写入指定的文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        // 接收完成
        System.out.println("Image received!");

        // 给客户端发送反馈，创建一个输出流
        OutputStream os1 = socket.getOutputStream();
        os1.write("Image received completed, Thank you!".getBytes(StandardCharsets.UTF_8));

        // 关闭资源
        os1.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
