package LearningTest.ThreadTest.Exercice;

/**
 * 创建两个子线程，并分别执行
 *
 * @author summer
 * @title: ThreadDemo
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/25/21 21:20
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.setName("线程1");
        // myThread1.setPriority(10);
        myThread1.start();
        myThread2.setName("线程2");
        myThread2.start();

        // 创建一个匿名Thread子类，即用即丢弃
        /*
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();
        */

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority() + ": " + i);
            }
            if (i == 10) {
                try {
                    // myThread1.join()将myThread1线程插入到主线程中执行
                    myThread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("myThread1是否存活: " + myThread1.isAlive());
    }
}


class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority() + ": " + i);
            }
            if (i % 10 == 0) {
                // yield方法会交出CPU使用权
                Thread.yield();
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}