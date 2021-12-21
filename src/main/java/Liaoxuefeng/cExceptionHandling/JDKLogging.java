package Liaoxuefeng.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 11:37
 * com.wfy.java.cExceptionHandling
 */

import java.util.logging.Logger;

public class JDKLogging {
    public static void main(String[] args) {
        //使用Java标准库内置的Logging有以下局限：
        //Logging系统在JVM启动时读取配置文件并完成初始化，一旦开始运行main()方法，就无法修改配置；
        //配置不太方便，需要在JVM启动时传递参数-Djava.util.logging.config.file=<config-file-name>。
        //因此，Java标准库内置的Logging使用并不是非常广泛。
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
        // 输出：自动打印了时间、调用类、调用方法等很多有用的信息
        /*
          10月 22, 2020 11:42:11 上午 com.wfy.java.cExceptionHandling.JDKLogging main
          信息: start process...
          10月 22, 2020 11:42:11 上午 com.wfy.java.cExceptionHandling.JDKLogging main
          警告: memory is running out...
          10月 22, 2020 11:42:11 上午 com.wfy.java.cExceptionHandling.JDKLogging main
          严重: process will be terminated...
        */
        // logger.fine("ignored.")没有运行，因为默认的日志级别是INFO
        // JDK的Logging设计有7个日志级别，从眼中到普通
        /*
        SEVERE
        WARNING
        INFO
        CONFIG
        FINE
        FINER
        FINEST
         */
        // INFO级别以下的日志，不会被打印出来。使用日志级别的好处在于，调整级别，就可以屏蔽掉很多调试相关的日志输出。
    }
}
