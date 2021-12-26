package LearningTest.ThreadTest;

/**
 * 实现Runnable接口
 * 存在线程安全问题，可能出现重票或错票
 * 问题的原因：当某个线程操作共享数据（车票）时，在尚未完成时，另一个线程也进入开始操作车票
 * @author summer
 * @title: Thread2Test
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/26/21 13:41
 */
public class Thread2Test {
    public static void main(String[] args) {
        // 创建一个实例，实现三个线程共享一个tickets
        MyThread3 m = new MyThread3();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread3 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖票，票号: " + tickets);
                tickets--;
            } else {
                break;
            }
        }
    }
}