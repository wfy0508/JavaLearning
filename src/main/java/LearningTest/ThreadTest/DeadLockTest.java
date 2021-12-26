package LearningTest.ThreadTest;

/**
 * 演示线程的死锁问题
 *
 * @author summer
 * @title: DeadLockTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/26/21 22:08
 */
public class DeadLockTest {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (sb1) {
                    sb1.append("a");
                    sb2.append(1);
                    // sleep大大增加死锁的可能性
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb2) {
                        sb1.append("b");
                        sb2.append(2);
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sb2) {
                    sb1.append("c");
                    sb2.append(3);
                    // sleep大大增加死锁的可能性
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb1) {
                        sb1.append("d");
                        sb2.append(4);
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }).start();
    }
}
