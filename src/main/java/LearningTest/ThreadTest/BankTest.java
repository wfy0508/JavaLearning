package LearningTest.ThreadTest;

/**
 * 使用线程安全解决懒汉问题
 *
 * @author summer
 * @title: BankTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/26/21 21:44
 */
public class BankTest {
    public static void main(String[] args) {
        System.out.println("");
    }
}

class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    public static Bank getInstance() {
        // 方式一：性能较差
//        synchronized (Bank.class) {if (instance == null) {
//                instance = new Bank();
//            }
//        }
//        return instance;
        // 方式二：提高性能，只有为null时，才进入同步进程
        if (instance == null) {
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;
    }
}