package Liaoxuefeng.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 10:32
 * com.wfy.java.cExceptionHandling
 */

public class ThrowingException2 {
    public static void main(String[] args) throws Exception{
        // 在极少数的情况下，我们需要获知所有的异常。如何保存所有的异常信息？
        // 方法是先用origin变量保存原始异常，然后调用Throwable.addSuppressed()，
        // 把原始异常添加进来，最后在finally抛出
        /*
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }

         */
    }
}
