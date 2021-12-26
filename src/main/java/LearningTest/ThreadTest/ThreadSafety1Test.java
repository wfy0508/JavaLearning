package LearningTest.ThreadTest;

/**
 * 进程间安全
 *
 * @author summer
 * @title: ThreadSafetyTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/26/21 17:48
 */
public class ThreadSafety1Test {
    public static void main(String[] args) {
        // 进程间安全
        MyThread5 m1 = new MyThread5();
        MyThread5 m2 = new MyThread5();
        MyThread5 m3 = new MyThread5();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.setName("窗口1");
        t1.start();
        t2.setName("窗口2");
        t2.start();
        t3.setName("窗口3");
        t3.start();
        System.out.println("------");
    }
}

/**
 * 同步代码块实现
 */
class MyThread5 implements Runnable {
    private static int tickets = 10;
    // 需要共享的锁是静态的
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            // synchronized(同步监视器)将操作共享对象的代码包起来
            // 要求多个线程共用同一把锁(obj)
            // 最简单的方式是使用当前的运行时类，不用再额外定义对象
            //synchronized (obj) {
            synchronized (MyThread5.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票，票号：" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
