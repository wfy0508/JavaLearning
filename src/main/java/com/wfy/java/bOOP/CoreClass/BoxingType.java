package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 16:53
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

public class BoxingType {
    public static void main(String[] args) {
        // 基本类型：byte，short，int，long，boolean，float，double，char
        // 引用类型：所有class和interface类型
        // 引用类型可以为空
        String s = null;
        // 基本类型不能为空
        // int n = null; // 编译出错

        // 想要把int基本类型变成一个引用类型，可以定义一个Integer类，它只包含一个实例字段int，
        // 这样，Integer类就可以视为int的包装类（Wrapper Class）
        class Integer1 {
            private int value;

            public Integer1(int value) {
                this.value = value;
            }

            public int intValue() {
                return this.value;
            }
        }

        // 定义好了Integer类，我们就可以把int和Integer互相转换
        Integer1 n1 = null;
        Integer1 n2 = new Integer1(99);
        int n3 = n2.intValue();

        // Java提供了很多包装类型，可以直接使用
        // boolean	java.lang.Boolean
        // byte	    java.lang.Byte
        // short	java.lang.Short
        // int	    java.lang.Integer
        // long	    java.lang.Long
        // float	java.lang.Float
        // double	java.lang.Double
        // char	    java.lang.Character

        int i = 100;
        // 通过new操作符创建Integer实例(不推荐使用,会有编译警告):
        Integer n4 = new Integer(i);
        // 通过静态方法valueOf(int)创建Integer实例:
        Integer n5 = Integer.valueOf(i);
        // 通过静态方法valueOf(String)创建Integer实例:
        Integer n6 = Integer.valueOf("100");
        System.out.println(n6.intValue());

        // 自动装箱
        // 注意：自动装箱和自动拆箱只发生在编译阶段，目的是为了少写代码。
        // 因为int和integer可以互换，所以Java编译器可以帮助我们自动在int和Integer之间转型
        Integer n7 = 100; // int -> Integer，称为自动装箱（Auto Boxing），编译器自动使用Integer.valueOf(int)
        int x1 = n7; // Integer -> int, 自动拆箱，编译器自动使用Integer.intValue()

        // 装箱和拆箱会影响代码的执行效率，因为编译后的class代码是严格区分基本类型和引用类型的。
        // 并且，自动拆箱执行时可能会报NullPointerException
        // Integer n8 = null;
        // int x2 = n8; // 编译器抛出java.lang.NullPointerException，因为基本类型int不能为null

        // 所有的包装类型都是不变类。
        // 对两个Integer实例进行比较要特别注意：绝对不能用==比较，因为Integer是引用类型，必须使用equals()比较
        Integer x = 127; // 自动变为Integer x = Integer.valueOf(127)
        Integer y = 127;
        Integer m = 99999;
        Integer n = 99999;
        System.out.println("x == y: " + (x==y)); // true
        System.out.println("m == n: " + (m==n)); // false
        // 为了节省内存，缓存优化，Integer.valueOf()对于较小的数，始终返回相同的实例，因此，==比较“恰好”为true
        System.out.println("x.equals(y): " + x.equals(y)); // true
        System.out.println("m.equals(n): " + m.equals(n)); // true

        // 因为Integer.valueOf()可能始终返回同一个Integer实例，因此，在我们自己创建Integer的时候，以下两种方法
        Integer n9 = new Integer(100); // 总是创建一个新的实例
        Integer n10 = Integer.valueOf(100); // 内部优化交给Integer的实现者去做

        // 我们把能创建“新”对象的静态方法称为<<静态工厂方法>>。
        // Integer.valueOf()就是静态工厂方法，它尽可能地返回缓存的实例以节省内存。
        // 创建新对象时，优先选用静态工厂方法而不是new操作符。

        // 进制转换
        // 下面方法的输出都是String，在计算机内存中，只用二进制表示，不存在十进制或十六进制的表示方法。
        // int n = 100在内存中总是以4字节的二进制表示
        System.out.println(Integer.toString(100)); // "100",表示为10进制
        System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
        System.out.println(Integer.toHexString(100)); // "64",表示为16进制
        System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
        System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制

        // Java的包装类型还定义了一些有用的静态变量
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int sizeOfLong = Long.SIZE;
        int bytesOfLong = Long.BYTES;

        // 所有的整数和浮点数的包装类型都继承自Number
        // 向上转型为Number:
        Number num = new Integer(999);
        // 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int n11 = num.intValue();
        long ln = num.longValue();
        float f1 = num.floatValue();
        double d = num.doubleValue();
    }
}
