package Liaoxuefeng.aQuickStart.ProcessControl;
/*
 * @Author wfy
 * @Date 2020/10/9 16:56
 * com.wfy.java.aQuickStart.ProcessControl
 */

public class breakAndContinueDemo01 {
    public static void main(String[] args) {
        for (int j = 1; j <= 10; j++) {
            System.out.println(j + " ");
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    break; //直接跳出内圈for循环
                    //continue; //终止内圈for循环的当前一次的循环，后面会继续内圈for循环
                }
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }
}
