package Liaoxuefeng.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 9:49
 * com.wfy.java.cExceptionHandling
 */

public class ThrowingException1 {
    public static void main(String[] args) throws Exception {
        // 3. 异常屏蔽
        // 如果在finally中也抛出异常，原来捕获的异常还会不会抛出？
        // 会发现结果中只有finally抛出的异常，原来捕获的异常被“屏蔽”了
        // 没有被抛出的异常称为“被屏蔽”的异常（Suppressed Exception）。
        /*
        System.out.println("---------------------------------3");
        try {
            Integer.parseInt("abc");
        } catch (Exception e) {
            System.out.println("catched");
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
            throw new IllegalArgumentException();
        }

         */
    }
}
