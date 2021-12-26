package LearningTest.ThreadTest;

/**
 * 线程间安全
 *
 * @author summer
 * @title: TreadSafetyTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/26/21 17:09
 */
public class TreadSafetyTest {
    public static void main(String[] args) {
        // 线程间安全
        MyThread4 m = new MyThread4();
        Thread m1 = new Thread(m);
        Thread m2 = new Thread(m);
        Thread m3 = new Thread(m);
        m1.setName("窗口1");
        m1.start();
        m2.setName("窗口2");
        m2.start();
        m3.setName("窗口3");
        m3.start();

        // 使用同步方法实现进程安全
        MyThread6 mm1 = new MyThread6();
        Thread g1 = new Thread(mm1);
        Thread g2 = new Thread(mm1);
        Thread g3 = new Thread(mm1);
        g1.setName("Window1");
        g1.start();
        g2.setName("Window2");
        g2.start();
        g3.setName("Window3");
        g3.start();
    }
}

class MyThread4 implements Runnable {
    private static int tickets = 10;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            // synchronized(同步监视器)将操作共享对象的代码包起来
            // 要求多个线程共用同一把锁(obj)
            // 最简单的方式是使用this
            // synchronized (obj) {
            synchronized (this) {
                try {
                    Thread.sleep(10);
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

/**
 * 同步方法实现
 */

class MyThread6 implements Runnable {
    private static int gift = 10;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    /**
     * 声明为同步方法
     */
    private synchronized void show() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (gift > 0) {
            System.out.println(Thread.currentThread().getName() + "，编号：" + gift);
            gift--;
        }
    }
}