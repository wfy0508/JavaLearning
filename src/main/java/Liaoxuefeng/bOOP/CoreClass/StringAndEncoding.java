package Liaoxuefeng.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 15:43
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringAndEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 1. String是一个引用类型，它本身也是一个类
        // Java编译器对String有特殊处理，即可以直接用"..."来表示一个字符串
        String s1 = "Hello";
        // 实际上字符串在String内部是通过一个char[]数组表示的
        String s2 = new String(new char[]{'H', 'e', 'l', 'l', 'o'});

        // 2. Java字符串的一个重要特点就是字符串不可变。
        // 这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的。
        System.out.println("--------------------------------2");
        String s = "hello";
        System.out.println(s); // 引用指向hello, 输出hello
        s = s.toUpperCase();
        System.out.println(s); // 引用发生变换, 指向HELLO, 输出HELLO

        // 3. 字符串比较
        // 两个字符串比较，必须总是使用equals()方法
        System.out.println("--------------------------------3");
        String s3 = "hello";
        String s4 = "hello";
        // Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池
        System.out.println(s3 == s4); // 指向同一个对象，返回true
        System.out.println(s3.equals(s4));// 字符串内容相等，返回true
        String s5 = "Hello".toLowerCase();
        System.out.println(s3 == s5); // 引用的不是同一个对象，返回false
        System.out.println(s3.equals(s5)); // 字符串内容相等，返回true
        System.out.println(s3.equalsIgnoreCase("HELLO")); // 忽略大小写

        // 4. 搜索字符串
        System.out.println("--------------------------------4");
        System.out.println("Hello".contains("ll")); // true
        System.out.println("Hello".lastIndexOf("l"));  // 3
        System.out.println("Hello".indexOf("o")); // 4
        System.out.println("Hello".startsWith("h")); // false
        System.out.println("Hello".endsWith("o")); // true

        // 5. 提取字符串
        System.out.println("--------------------------------5");
        System.out.println("Hello".substring(2)); // llo
        System.out.println("Hello".substring(2, 4)); // ll

        // 6. 去除首尾空白字符
        // 使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n
        // trim()并没有改变字符串的内容，而是返回了一个新字符串
        System.out.println("--------------------------------6");
        System.out.println("  \thello \t ".trim()); // hello

        // 7. 判断字符串是否为空和空白字符串
        System.out.println("--------------------------------7");
        System.out.println("".isEmpty()); // true
        System.out.println("    ".isBlank()); // true
        System.out.println("  \n".isBlank()); // true
        System.out.println("Hello ".isEmpty()); // false

        // 8. 替换子串
        System.out.println("--------------------------------8");
        System.out.println("Hello".replace("l", "w")); //hewwo
        System.out.println("A,, B; C, D".replaceAll("[,;\s]+", ",")); //A,B,C,D

        // 9. 分割字符串
        System.out.println("--------------------------------9");
        System.out.println(Arrays.toString("A,B,C,D".split(","))); // [A, B, C, D]

        // 10. 拼接字符串
        System.out.println("--------------------------------10");
        String[] arr = {"A", "B", "C"};
        String s6 = String.join("***", arr);
        System.out.println(s6); // A***B***C

        // 11. 格式化字符串
        // %s：显示字符串；
        // %d：显示整数；
        // %x：显示十六进制整数；
        // %f：显示浮点数。
        // 占位符还可以带格式，例如%.2f表示显示两位小数。
        // 如果你不确定用啥占位符，那就始终用%s，因为%s可以显示任何数据类型
        System.out.println("--------------------------------11");
        String s7 = "Hi %s, your score is %d!";
        System.out.println(s7.formatted("Alice", 99)); // Hi Alice, your score is 99!
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 66.6)); // Hi Bob, your score is 66.60!

        // 12. 类型转换
        System.out.println("--------------------------------12");
        int n1 = Integer.parseInt("123"); // String转换为Int
        int n2 = Integer.parseInt("ff", 16); // 将16转换为16进制， 输出255
        boolean b1 = Boolean.parseBoolean("true");
        boolean b2 = Boolean.parseBoolean("FALSE");
        // Integer有个getInteger(String)方法，
        // 它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer
        System.out.println(Integer.getInteger("java.version"));

        // 13. 转换为char[]
        System.out.println("--------------------------------13");
        char[] cs = "Hello".toCharArray();
        System.out.println(cs); // String -> char[]
        String s8 = new String(cs); // 没有直接传入char[], 而是复制了一份cs的数据
        System.out.println(s8); // char[] ->String
        // 如果修改了cs，并不会影响s8
        // 这是因为通过new String(char[])创建新的String实例时，它并不会直接引用传入的char[]数组，而是会复制一份，
        // 所以，修改外部的char[]数组不会影响String实例内部的char[]数组，因为这是两个不同的数组。
        // 从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。
        cs[0] = 'W';
        System.out.println(s8); // Hello

        // 14. 字符编码
        System.out.println("--------------------------------14");
        // Java中，char类型是两个字节的Unicode编码。如果我们要手动把字符串转换成其他编码，可以这样做
        byte[] bb1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] bb2 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        byte[] bb3 = "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] bb4 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        // 把已知编码的byte[]转换为String
        byte[] b = new byte[]{'h', 'e', 'l', 'l', 'o'};
        String s9 = new String(b, "GBK");
        String s10 = new String(b, StandardCharsets.UTF_8);
        // *******Java的String和char在内存中总是以Unicode编码表示*******
    }
}

