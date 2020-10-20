package com.wfy.java.bOOP.CoreClass;

/*
 * @Author wfy
 * @Date 2020/10/20 16:42
 * com.wfy.java.bOOP.CoreClass
 */

public class RecordClass {
    public static void main(String[] args) {
        Point1 point1 = new Point1(123, 456);
        System.out.println(point1.x());
        System.out.println(point1.y());
        System.out.println(point1);

        // 添加静态方法后，就可以写出更加简洁的代码
        var z = Point1.of();
        var p = Point1.of(123, 456);
    }
}


// 以往我们定义不变类
// 为了保证不变类的比较，还需要正确覆写equals()和hashCode()方法，这样才能在集合类中正常使用。
final class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
}

// 从java14开始，引入了新的Record类，像如下定义：
// 编译器默认按照record声明的变量顺序自动创建一个构造方法，并在方法内为变量赋值，
// 如果要自定义代码检查，就需要修改构造方法的逻辑
record Point1(int x, int y) {
    public Point1 {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
    }

    // 注意到方法public Point {...}被称为 Compact Constructor，
    // 它的目的是让我们编写检查逻辑，编译器最终生成的构造方法如下：
    /*
      public final class Point extends Record {
        public Point(int x, int y) {
            // 这是我们编写的Compact Constructor:
            if (x < 0 || y < 0) {
                throw new IllegalArgumentE  xception();
            }
            // 这是编译器继续生成的赋值代码:
            this.x = x;
            this.y = y;
        }
      ...
      }
     */
    // 作为record的Point仍然可以添加静态方法。一种常用的静态方法是of()方法，用来创建Point
    public static Point1 of() {
        return new Point1(0, 0);
    }

    public static Point1 of(int x, int y) {
        return new Point1(x, y);
    }
}

// 把上述代码改写为class，相当于如下代码
// 除了用final修饰class以及每个字段外，编译器还自动为我们创建了构造方法，和字段名同名的方法，
// 以及覆写toString()、equals()和hashCode()方法。
// 换句话说，使用record关键字，可以一行写出一个不变类。
// 和enum类似，我们自己不能直接从Record派生，只能通过record关键字由编译器实现继承。

/*
public final class Point extends Record {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public String toString() {
        return String.format("Point[x=%s, y=%s]", x, y);
    }

    public boolean equals(Object o) {
        ...
    }
    public int hashCode() {
        ...
    }
}
 */