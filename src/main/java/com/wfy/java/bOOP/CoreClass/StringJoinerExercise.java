package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 16:45
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

import java.util.StringJoiner;

public class StringJoinerExercise {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildSelectSql(String table, String[] fields) {
        var sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        return sj.toString();
    }
}
