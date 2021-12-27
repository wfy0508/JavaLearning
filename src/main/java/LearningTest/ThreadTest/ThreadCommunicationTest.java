package LearningTest.ThreadTest;

/**
 * 线程间通信
 * notify()：一旦执行此方法，被wait()阻塞的线程就会被唤醒，如果有多个被阻塞，就唤醒优先级较高的那个
 * notifyAll()：一旦执行此方法，所有被wait()阻塞的线程就会被唤醒
 * wait()：一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * <p>
 * 1. 以上三个方法必须在同步方法或同步代码块中使用！！！
 * 2. 三个方法的调用者必须是同步方法或同步代码块中的同一个同步监视器
 * 3. 三个方法定义在Object中，因为同步监视器可以是任何一个对象，也就保证任何一个对象都有这三个方法
 *
 * sleep()和wait()的异同：
 * 1. 相同点：一旦执行都可以使线程进入阻塞状态
 * 2. 不同点：两个方法声明的位置不同，Thread类中声明sleep()，Object类中声明wait()
 *           调用的要求不同：sleep()可以在任何需要的场景下使用，wait()必须在同步代码块或者同步方法中使用
 *           关于是否释放同步监视器，sleep不会释放，wait()被唤醒后就释放
 * @author summer
 * @title: ThreadCommunicationTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/27/21 17:19
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程1");
        t1.start();
        t2.setName("线程2");
        t2.start();
    }
}


class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // 唤醒wait()被阻塞的线程
                this.notify();
                if (number <= 20) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    try {
                        // 使得调用如下wait()方法的线程进入阻塞状态
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}