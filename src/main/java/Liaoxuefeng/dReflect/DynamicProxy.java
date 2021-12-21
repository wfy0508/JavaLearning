package Liaoxuefeng.dReflect;

/*
 * @Author wfy
 * @Date 2020/10/23 14:58
 * com.wfy.java.dReflect
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) throws Throwable {
        // 所有的interface类型的变量总是通过向上转型并指向某个实例
        CharSequence cs = new StringBuilder();
        // Java标准库也提供一种动态代理机制，可以再运行期间动态创建某个interface的实例
        // 常规方法创建实例
        Hello hello = new HelloWorld();
        hello.morning("Tom");

        // 动态创建interface实例
        // 1. 定义一个InvocationHandler实例，它负责实现接口的方法调用；
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        // 2. 通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
        // 2.1 使用的ClassLoader，通常就是接口类的ClassLoader；
        // 2.2 需要实现的接口数组，至少需要传入一个接口进去；
        // 2.3 用来处理接口方法调用的InvocationHandler实例。
        Hello hello1 = (Hello) Proxy.newProxyInstance( //将返回的Object强制转型为接口。
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler
        );
        hello1.morning("Bob");
        // 动态代理实际上是JDK在运行期动态创建class字节码并加载的过程
    }
}

// 编写接口
interface Hello {
    void morning(String name) throws Throwable;
}

// 实现接口
class HelloWorld implements Hello {
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }
}

// 把上面的动态创建代码代为静态实现类，大概像这样
class HelloDynamicProxy implements Hello {
    InvocationHandler handler;

    public HelloDynamicProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void morning(String name) throws Throwable {
        handler.invoke(
                this,
                Hello.class.getMethod("morning", String.class),
                new Object[]{name}
        );
    }
}