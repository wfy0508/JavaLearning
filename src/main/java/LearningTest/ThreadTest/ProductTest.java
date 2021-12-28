package LearningTest.ThreadTest;

/**
 * 生产者消费者问题：生产者生产商品，店员出售商品，消费者购买商品。
 * 1. 当生产的产品超过店员持有的数量时（假设为20个），通知生产者停止生产；
 * 2. 当店员持有的产品为0时，通知消费者停止消费。
 *
 * @author summer
 * @title: ProducerConsumerTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/28/21 14:49
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer1 = new Consumer(clerk);
        Consumer consumer2 = new Consumer(clerk);
        producer.setName("生产者1");
        producer.start();
        consumer1.setName("消费者1");
        consumer1.start();
        consumer2.setName("消费者2");
        consumer2.start();
    }
}

/**
 * 店员类
 */
class Clerk {
    private int product = 0;

    public synchronized void productGoods() {
        if (product < 20) {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产编号为" + product + "的产品");
            // 生产完成后通知消费者来消费
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeGoods() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + "消费编号为" + product + "的产品");
            product--;
            // 唤醒被阻塞的进程
            notify();
        } else {
            try {
                //如果product为0则进入阻塞状态
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者类
 */
class Producer extends Thread {
    private int product;
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    /**
     * 生产产品
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产产品......");
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productGoods();
        }

    }
}

/**
 * 消费者类
 */
class Consumer extends Thread {
    private int product;
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    /**
     * 消费产品
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品......");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeGoods();
        }

    }
}