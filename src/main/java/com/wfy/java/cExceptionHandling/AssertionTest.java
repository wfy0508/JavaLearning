package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 10:59
 * com.wfy.java.cExceptionHandling
 */

public class AssertionTest {
    public static void main(String[] args) {
        double x = Math.abs(-123.56);
        // 默认情况，JVM关闭了断言指令，即遇到断言语句会自动忽略，不执行
        // 要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言。
        // 所以，上述程序必须在命令行下运行才有效果
        assert x < 0;
        System.out.println(x);
        // 还可以有选择地对特定地类启用断言，
        // 命令行参数是：-ea:com.itranswarp.sample.Main，表示只对com.itranswarp.sample.Main这个类启用断言。
        // 或者对特定地包启用断言，
        // 命令行参数是：-ea:com.itranswarp.sample...（注意结尾有3个.），表示对com.itranswarp.sample这个包启动断言。
        // 实际开发中，很少使用断言。更好的方法是编写单元测试，后续我们会讲解JUnit的使用。
    }
}
