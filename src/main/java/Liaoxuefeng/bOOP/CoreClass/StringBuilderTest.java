package Liaoxuefeng.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 15:47
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

public class StringBuilderTest {
    public static void main(String[] args) {
        // Java编译器对String做了特殊处理，使得我们可以直接用+拼接字符串
        // 每次循环都会创建新的字符串对象，然后扔掉旧的字符串，这样绝大部分都是临时对象，不但浪费内存，还会影响GC效率
        String s = " ";
        for (int i = 0; i <= 10; i++) {
            s = s + "," + i;
        }

        // 为了实现高效拼接字符串，
        // Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，
        // 这样，往StringBuilder中新增字符时，不会创建新的临时对象
        var sb = new StringBuilder(1024);
        String s1 = " ";
        for (int i = 0; i < 10; i++) {
            sb.append(',');
            sb.append(i);
        }
        System.out.println(sb.toString()); // ,0,1,2,3,4,5,6,7,8,9

        // StringBuilder链式操作
        var sb1 = new StringBuilder(1024);
        sb1.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb1.toString()); // Hello, Mr Bob!

        // 累加器
        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());
    }
}

class Adder {
    private int sum = 0;

    // 每次调用完都返回自己，这样就不断调用自身
    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}
