package LearningTest.InetAddressTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author summer
 * @title: InetAddressTest
 * @projectName AlgorithmLearning
 * @description: TODO
 * @date 12/5/21 16:03
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("39.117.118.230");
            InetAddress inet2 = InetAddress.getByName("www.github.com");
            System.out.println(inet1);
            System.out.println(inet2);
            // 获取本机ip地址
            System.out.println(InetAddress.getLocalHost().toString());
            System.out.println(InetAddress.getLoopbackAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
