package com.wfy.java.aQuickStart.OOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 16:37
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        // 用分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事
        String[] names = {"Bob", "Jack", "Tom"};
        // 执行StringJoiner的连接符，前缀和后缀
        var sj = new StringJoiner(",", "Hello ", " !");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj);

        // 在不需要前缀和后缀的场景中，可以使用String.join，该方法内部使用StringJoiner来拼接字符串
        var s = String.join(" ,", names);
        System.out.println(s);
    }
}
