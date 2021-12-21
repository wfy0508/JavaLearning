package Liaoxuefeng.eAnnotation;

/*
 * @Author wfy
 * @Date 2020/10/23 15:38
 * com.wfy.java.eAnnotation
 */

public class UseAnnotation {
    public static void main(String[] args) {
        // 注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”
        // 注释会被编译器直接忽略，注解则可以被编译器打包进入class文件，因此，注解是一种用作标注的“元数据”。
        // 从JVM的角度看，注解本身对代码逻辑没有任何影响，如何使用注解完全由工具决定。

        // Java注解可以分为3类：
        // 1. 编译器使用的注解(这类注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了。)
        // 1.1 @Override: 让编译器检查该方法是否正确地实现了覆写；
        // 1.2 @SuppressWarnings：告诉编译器忽略此处代码产生的警告。

        // 2. 是由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能。
        // 这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。这类注解只被一些底层库使用，一般我们不必自己处理。

        // 3. 是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。
        // 例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用
        // （这是Java代码读取该注解实现的功能，JVM并不会识别该注解）。
    }
}


// 定义一个注解时，还可以定义配置参数。配置参数可以包括：
// 1. 所有基本类型；
// 2. String；
// 3. 枚举类型；
// 4. 基本类型、String、Class以及枚举的数组。
// 因为配置参数必须是常量，所以，上述限制保证了注解在定义时就已经确定了每个参数的值。
// 注解的配置参数可以有默认值，缺少某个配置参数时将使用默认值。
// 此外，大部分注解会有一个名为value的配置参数，对此参数赋值，可以只写常量，相当于省略了value参数。
// 如果只写注解，相当于全部使用默认值。
// 举个栗子，对以下代码：
// @Check就是一个注解。
// 1. 第一个@Check(min=0, max=100, value=55)明确定义了三个参数，
// 2. 第二个@Check(value=99)只定义了一个value参数，它实际上和@Check(99)是完全一样的。
// 3. 最后一个@Check表示所有参数都使用默认值。
/*
class Hello {
    @Check(min = 0, max = 100, value = 55)
    public int n;

    @Check(value = 99)
    public int p;

    @Check(99) // @Check(value=99)
    public int x;

    @Check
    public int y;
}
 */
