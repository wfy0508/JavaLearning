package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/21 17:25
 * com.wfy.java.cExceptionHandling
 */

public class ThrowingException {
    public static void main(String[] args) {
        // 1. 异常传播
        // 当某个方法抛出的异常没有被捕获时，异常就会抛向上层调用方法，直到遇到try..catch被捕获为止
        // 抛出异常的解析，从下往上看
        // 1.1. main()调用process1()
        // 1.2. process1()调用process2()
        // 1.3. process2()调用Integer.parseInt(String);
        // 1.4. Integer.parseInt(String)调用Integer.parseInt(String, Int)
        // 1.5. 按照提示行号（(Integer.java:614)）查看Integer.java代码，可知如下异常被抛出
        /*
        if (s == null) {
            throw new NumberFormatException("null");
        }
         */
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.1 抛出异常--异常转换
        // 异常栈中只能看到IllegalArgumentException
        // 这说明新的异常丢失了原始异常信息，我们已经看不到原始异常NullPointerException的信息了。
        try {
            process5();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.2 转换异常之后，持有原有异常信息
        // 注意到Caused by: Xxx，说明捕获的IllegalArgumentException并不是造成问题的根源，
        // 根源在于NullPointerException，是在Main.process2()方法抛出的。
        // 在代码中获取原始异常可以使用Throwable.getCause()方法。如果返回null，说明已经是“根异常”了。
        try {
            process7();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void process1() {
        process2();
    }

    static void process2() {
        Integer.parseInt(null); //会抛出NumberFormatException
    }

    // 抛出异常
    // 创建某个异常的实例
    // 用throw语句抛出
    static void process3(String s) {
        if (s == null) {
            NullPointerException e = new NullPointerException();
            throw e;
        }
    }

    // 大部分都改成一行代码
    static void process4(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
    }

    // 如果一个方法捕获了某个异常后，又在catch子句中抛出新的异常，就相当于把抛出的异常类型“转换”了：
    // 本来的异常时NullPointerException，却抛出IllegalArgumentException
    static void process5() {
        try {
            process6();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    static void process6() {
        throw new NullPointerException();
    }

    // 为了能追踪到完整的异常栈，在构造异常的时候，把原始的Exception实例传进去，新的Exception就可以持有原始Exception信息。
    // 对上述代码改进如下：
    static void process7() {
        try {
            process8();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e); // 传入原有异常实例
        }
    }

    static void process8() {
        throw new NullPointerException();
    }

}
