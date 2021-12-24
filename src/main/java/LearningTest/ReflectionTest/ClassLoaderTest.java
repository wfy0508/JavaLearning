package LearningTest.ReflectionTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author summer
 * @title: ClassLoaderTest
 * @projectName JavaLearning
 * @description: TODO
 * @date 12/23/21 12:27
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        // 对于自定义类，使用系统类加载器
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);

        // 通过getParent获取扩展类加载器
        ClassLoader loader1 = loader.getParent();
        System.out.println(loader1);

        // 无法获取引导类加载器
        // 引导类加载器主要获取核心类，无法获取自定义类
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);

        // String是引导类加载器加载的
        ClassLoader loader3 = String.class.getClassLoader();
        System.out.println(loader3);
    }

    @Test
    public void test2() throws IOException {
        Properties props = new Properties();
        // 读取配置文件方式1
        // 默认配置文件识别为，在当前工程下
        FileInputStream fis = new FileInputStream("jdbc.properties");
        props.load(fis);

        String username = props.getProperty("username");
        String password = props.getProperty("password");
        System.out.println("username: " + username + ", password: " + password);
    }

    @Test
    public void test3() throws IOException {
        Properties props = new Properties();
        // 读取配置文件方式2，使用ClassLoader
        // 默认配置文件识别为，在当前module src路径下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        props.load(is);

        String username = props.getProperty("username");
        String password = props.getProperty("password");
        System.out.println("username: " + username + ", password: " + password);
    }
}
