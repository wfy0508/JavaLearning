package Liaoxuefeng.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 10:47
 * com.wfy.java.cExceptionHandling
 */

public class NPE {
    public static void main(String[] args) {
        // NullPointerException即空指针异常，俗称NPE。
        // 如果一个对象为null，调用其方法或访问其字段就会产生NullPointerException，这个异常通常是由JVM抛出的
        // 指针这个概念实际上源自C语言，Java语言中并无指针。
        // 我们定义的变量实际上是引用，Null Pointer更确切地说是Null Reference，不过两者区别不大。
        String s = null;
        //System.out.println(s.toUpperCase());

        // 如果遇到NullPointerException，我们应该如何处理？
        // 首先，必须明确，NullPointerException是一种代码逻辑错误，
        // 遇到NullPointerException，遵循原则是早暴露，早修复，严禁使用catch来隐藏这种编码错误
    }
}

// 好的编码习惯可以极大地降低NullPointerException的产生
class Person {
    // 1. 用空字符串""而不是默认的null可避免很多NullPointerException，
    // 编写业务逻辑时，用空字符串""表示未填写比null安全得多。
    private String name = "";

    // 2. 返回空字符串""、空数组而不是null
    public String[] readLinesFromFile(String file) {
        if (getFileSize(file) == 0) {
            return new String[0];
        }
        return new String[1];
    }

    private int getFileSize(String file) {
        return file.length();
    }

    // 这样可以使得调用方无需检查结果是否为null。
    //如果调用方一定要根据null判断，比如返回null表示文件不存在，那么考虑返回Optional<T>：
    /*
      public Optional<String> readFromFile(String file) {
        if (!fileExist(file)) {
            return Optional.empty();
        }
        ...
      }
     */
}
