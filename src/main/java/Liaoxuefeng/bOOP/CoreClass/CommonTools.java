package Liaoxuefeng.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/21 11:42
 * com.wfy.java.bOOP.CoreClass
 */

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class CommonTools {
    public static void main(String[] args) {
        // 1. Math
        System.out.println(Math.abs(-1100));
        System.out.println(Math.max(100, 99));
        System.out.println(Math.min(100, 99));
        System.out.println(Math.pow(2, 10));
        System.out.println(Math.sqrt(255));
        System.out.println(Math.exp(2));
        System.out.println(Math.log(4)); // 以2为底
        System.out.println(Math.log10(100));
        // 另外还有三角函数...

        // 2. Random
        // Random用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的。
        // 如果不给定种子，就使用系统当前时间戳作为种子，因此每次运行时，种子不同，得到的伪随机数序列就不同。
        System.out.println("----------------------------------------Random");
        Random r = new Random();
        System.out.println("nextInt:" + r.nextInt()); // 每次都不一样
        System.out.println("0-10 nextInt:" + r.nextInt(10)); // 生成一个[0, 10)之间的int
        System.out.println("nextLong:" + r.nextLong());
        System.out.println("nextFloat:" + r.nextFloat());
        System.out.println("nextDouble:" + r.nextDouble());
        // 如果给定一个种子，就会得到一个完全确定的随机序列
        Random r1 = new Random(1234);
        for (int i = 0; i <= 10; i++) {
            System.out.println("seed sequence " + i + ": " + r1.nextInt(100)); // 每次运行结果都一样
        }
        // 如果我们要生成一个区间在[MIN, MAX)的随机数，可以借助Math.random()实现
        double x = Math.random();
        double min = 10;
        double max = 100;
        double y = x * (max - min) + min;
        long n = (long) y;
        System.out.println("y:" + y);
        System.out.println("n: " + n);

        // 3. SecureRandom
        // 有伪随机数，就有真随机数。实际上真正的真随机数只能通过量子力学原理来获取，
        // 而我们想要的是一个不可预测的安全的随机数，SecureRandom就是用来创建安全的随机数的
        SecureRandom sr = new SecureRandom();
        System.out.println("SecureRandom: " + sr.nextInt(100));
        // SecureRandom无法指定种子，它使用RNG（random number generator）算法。
        // JDK的SecureRandom实际上有多种不同的底层实现，
        // 有的使用安全随机种子加上伪随机数算法来产生安全的随机数，
        // 有的使用真正的随机数生成器。实际使用的时候，可以优先获取高强度的安全随机数生成器，
        // 如果没有提供，再使用普通等级的安全随机数生成器：
        SecureRandom sr1 = null;
        try {
            sr1 = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr1 = new SecureRandom(); // 获取普通强度随机数生成器
        }
        byte[] buffer = new byte[16];
        sr1.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        // SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。
        // 这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。
        // 在密码学中，安全的随机数非常重要。如果使用不安全的伪随机数，所有加密体系都将被攻破。
        // 因此，时刻牢记必须使用SecureRandom来产生安全的随机数。
    }
}
