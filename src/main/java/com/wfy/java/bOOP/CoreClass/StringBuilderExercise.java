package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/19 16:23
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

public class StringBuilderExercise {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = builderInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee(name, position, salary) VALUES (?,?,?);";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String builderInsertSql(String table, String[] fields) {
        var sb = new StringBuilder();
        sb.append("INSERT INTO ")
                .append(table)
                .append("(");
        for (String field : fields) {
            sb.append(field);
            if (!field.equals("salary")) {
                sb.append(", ");
            }
        }
        sb.append(") VALUES (?,?,?);");
        return sb.toString();
    }
}
