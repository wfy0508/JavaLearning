package LearningTest.StringTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/7/20 14:04
*/

import org.junit.Test;

public class StringTest {

    @Test
    public void test1() {
        String str1 = "123";
        // String转换为基本类型、包装类，使用parseXxx(str)
        int num = Integer.parseInt(str1);
        System.out.println(num);
        // 基本类型、包装类转换为String，使用String.valueOf()
        String str2 = String.valueOf(num);
        System.out.println(str2);
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s4); // 比较堆内存中的地址 false
        System.out.println(s3.equals(s4));
    }


}
