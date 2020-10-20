package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/20 10:09
 * com.wfy.java.aQuickStart.OOP.CoreClass
 */

public class EnumClass {
    public static void main(String[] args) {
        // 使用常量可以这样
        int day = 99;
        if (day == Weekday.SUN || day == Weekday.SAT) {
            System.out.println("Sleep");
        }

        String color = null;
        if (Color.RED.equals(color)) {
            System.out.println("The color is RED");
        }

        // 无论是int常量还是String常量，使用这些常量来表示一组枚举值的时候，
        // 有一个严重的问题就是，编译器无法检查每个值的合理性。
        /*
        if (weekday == 6 || weekday == 7) {
            if (tasks == Weekday.MON) {
                // TODO:
            }
        }
         */
        // 注意到Weekday定义的常量范围是0~6，并不包含7，编译器无法检查不在枚举中的int值
        // 定义的常量仍可与其他变量比较，但其用途并非是枚举星期值。

        // 使用枚举类
        // 1. 枚举类带有类型信息，Weekday1.SUN类型是Weekday1，如果用int day = 1与weekday比较就会报错
        // 2. 不同枚举类型不能比较，因为类型不符
        Weekday1 weekday1 = Weekday1.SUN;
        if (weekday1 == Weekday1.SAT || weekday1 == Weekday1.SUN) {
            System.out.println("Sleep at home");
        } else {
            System.out.println("Work at home!");
        }

        // enum的比较
        // 使用enum定义的枚举类型是一种引用类，前面讲的引用类型的比较，要始终使用equals()方法
        // 但是enum类型可以例外，这是因为enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较
        /*
        if (day == Weekday.FRI) { // ok!
        }
        if (day.equals(Weekday.SUN)) { // ok, but more code!
        }
         */

        // 通过enum定义的枚举类，和其他的class有什么区别？
        // 答案是没有任何区别。enum定义的类型就是class，只不过它有以下几个特点：
        // 1. 定义的enum类型总是继承自java.lang.Enum，且无法被继承；
        // 2. 只能定义出enum的实例，而无法通过new操作符创建enum的实例；
        // 3. 定义的每个实例都是引用类型的唯一实例；
        // 4. 可以将enum类型用于switch语句。

        // 因为enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法：
        String s = Weekday1.SUN.name(); // 返回常量名 "SUN"
        int n = Weekday1.SUN.ordinal(); // 返回定义常量的顺序 0(与列中定义的顺序一致)

        // 定义枚举类是，给枚举值添加一个顺序字段
        Weekday2 day1 = Weekday2.SUN;
        if (day1.dayValue == 0 || day1.dayValue == 6) {
            System.out.println("Today is " + day1 + " Sleep at home!");
        } else {
            System.out.println("Today is " + day1 + " Work at office!");
        }
    }
}

// 在Java中，可以使用static final定义常量，如定义周一到周日，可以使用7个不同的int来表示
class Weekday {
    public static final int SUN = 0;
    public static final int MON = 1;
    public static final int TUE = 2;
    public static final int WED = 3;
    public static final int THU = 4;
    public static final int FRI = 5;
    public static final int SAT = 6;
}

class Color {
    public static final String RED = "r";
    public static final String GREEN = "g";
    public static final String BLUE = "b";
}

// 为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，
// 我们可以使用enum来定义枚举类
enum Weekday1 {
    SUN, MON, TUE, WED, THU, FRI, SAT;

}

// 可以定义private的构造方法，并且，给每个枚举常量添加字段
// 默认情况下，对枚举常量调用toString()会返回和name()一样的字符串。但是，toString()可以被覆写，而name()则不行。
enum Weekday2 {
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六"),
    SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday2(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}