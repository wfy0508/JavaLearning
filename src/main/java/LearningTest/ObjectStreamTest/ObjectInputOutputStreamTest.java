package LearningTest.ObjectStreamTest;

import org.junit.Test;

import java.io.*;

/**
 * @author yanlingwang
 * @PROJECT_NAME: LearningTest.ObjectStreamTest
 * @USER: Summer
 * @Create Time: 2021/9/25 18:08
 * 序列化：ObjectOutPutStream
 * 反序列化：ObjectInputStream
 * 两个都不能修饰static和transient两种类型
 */

public class ObjectInputOutputStreamTest {

    @Test
    public void test() {
        ObjectOutputStream oos = null;
        try {
            // 1. 创建序列化流
            oos = new ObjectOutputStream(new FileOutputStream("object.bat"));
            // 2. 写入Object数据
            oos.writeObject("Java入门教程");
            // 3. 将数据刷新到磁盘
            oos.flush();

            // 写入一个Person对象
            oos.writeObject(new Person("张伟", 20));
            oos.flush();

            // 使用另一个构造器写入一个新的Person对象
            oos.writeObject(new Person("张三", 33, new Account(5000.0)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Test
    public void test1() {
        ObjectInputStream ois = null;
        try {
            // 1. 创建反序列化流
            ois = new ObjectInputStream(new FileInputStream("object.bat"));
            // 2. 读取数据
            Object data = ois.readObject();
            String str = (String) data;
            // 打印输出读入的数据
            System.out.println(str);

            // 读取一个Person对象
            Person person = (Person) ois.readObject();
            System.out.println(person);

            // 读取另外一个对象
            Person person1 = (Person) ois.readObject();
            System.out.println(person1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭资源
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/**
 * 创建一个Person类，用于测试序列化和反序列化
 * 要想自定义的类可序列化，需要实现序列化的接口Serializable
 */
class Person implements Serializable {

    /**
     * 实现序列化接口，需要定义一个全局常量
     */
    public static final long serialVersionUID = 47656744200L;

    private String name;
    private int age;
    private Account acct;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", acct=" + acct +
                '}';
    }
}

class Account implements Serializable{
    private double balance;

    public static final long serialVersionUID = 237946127342L;

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}