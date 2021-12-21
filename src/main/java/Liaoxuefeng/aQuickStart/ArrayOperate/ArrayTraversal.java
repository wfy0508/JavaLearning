package Liaoxuefeng.aQuickStart.ArrayOperate;
/*
 * @Author wfy
 * @Date 2020/10/10 10:29
 * com.wfy.java.aQuickStart.ArrayOperate
 */

import java.util.Arrays;

public class ArrayTraversal {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        for (int j : array) {
            System.out.println(j);
        }

        //打印数组内容：Arrays.toString()
        System.out.println(Arrays.toString(array));

    }
}
