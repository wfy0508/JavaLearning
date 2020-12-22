package com.wfy.java.gCollections;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Description
 * @Package com.wfy.java.gCollections
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/22 10:30
 */

public class useProperties {
    public static void main(String[] args) throws IOException {
        // Properties设计的目的是存储String类型的key－value，
        // 但Properties实际上是从Hashtable派生的，
        // 它的设计实际上是有问题的，但是为了保持兼容性，现在已经没法修改了。
        // 除了getProperty()和setProperty()方法外，
        // 还有从Hashtable继承下来的get()和put()方法，
        // 这些方法的参数签名是Object，在使用Properties的时候，
        // 不要去调用这些从Hashtable继承下来的方法。

        // 用Properties读取配置文件，一共有三步：
        // 1. 创建Properties实例；
        // 2. 调用load()读取文件；
        // 3. 调用getProperty()获取配置。
        String setting = """
                # test
                course=java
                last_open_date=2019-08-27T12:35:01""";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(setting.getBytes(StandardCharsets.UTF_8));
        Properties properties = new Properties();
        properties.load(inputStream);

        System.out.println(setting);
        System.out.println("course: " + properties.getProperty("course"));
        System.out.println("lat_open_date: " + properties.getProperty("last_open_date"));
        System.out.println("last_open_file: " + properties.getProperty("lase_open_date"));
        System.out.println("auto_save: " + properties.getProperty("auto_save", "60"));

        // 可以把默认配置文件放到classpath中，然后，根据机器的环境编写另一个配置文件，覆盖某些默认的配置。
    }
}
