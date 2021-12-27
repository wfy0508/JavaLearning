package LearningTest.ThreadTest;

/**
 * 银行两个客户存钱，每次存1000，每次存完后打印余额
 *
 * @author summer
 * @title: BankDepositTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/27/21 16:15
 */
public class BankDepositTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        c1.setName("账户1");
        c1.start();
        c2.setName("账户2");
        c2.start();

    }
}

/**
 * 定义一个账户类
 */
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 定义一个存钱方法
     */
    public synchronized void deposit(double amt) throws InterruptedException {
        if (amt > 0) {
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存款成功，余额为：" + balance);
        }
    }
}

/**
 * 定义一个客户类，并继承Thread类
 */
class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                acct.deposit(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}