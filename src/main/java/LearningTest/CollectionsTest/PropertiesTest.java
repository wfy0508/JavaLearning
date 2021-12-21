package LearningTest.CollectionsTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Summer
 */
public class PropertiesTest {
    @Test
    public void test() throws IOException {
        Properties props = new Properties();
        FileInputStream inputStream = new FileInputStream("jdbc.properties");
        // 加载流对应的文件
        props.load(inputStream);

        String name = props.getProperty("name");
        String password = props.getProperty("password");
        System.out.println("name=" + name + ", password=" + password);


    }

}
