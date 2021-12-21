package Liaoxuefeng.hIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 14:26
 */

public class FilterStyle {
    public static void main(String[] args) throws Exception {
        // 当我们需要给一个“基础”InputStream附加各种功能时，我们先确定这个能提供数据源的InputStream，
        // 因为我们需要的数据总得来自某个地方，例如，FileInputStream，数据来源自文件：
        InputStream fileInputStream = new FileInputStream("D:\\hadoop_test\\java_input.gz");
        // 紧接着希望添加缓冲功能来提高读取的效率，因此使用BufferedInputStream来包装这个InputStream
        InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // 假设该文件已经被gzip压缩了，希望直接读取，因此使用InputStream来引用它，就可以正常读取
        InputStream gzipInputStream = new GZIPInputStream(bufferedInputStream);

        // 无论我们包装多少次，得到的对象始终是InputStream，我们直接用InputStream来引用它，就可以正常读取：
        // 这种通过一个“基础”组件再叠加各种“附加”功能组件的模式，称之为Filter模式（或者装饰器模式：Decorator）。
        // 它可以让我们通过少量的类来实现各种功能的组合

        // 编写FilterInputStream
        byte[] data = "Hello, world!".getBytes(StandardCharsets.UTF_8);
        try (CountInputStream countInputStream = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = countInputStream.read()) != -1) {
                System.out.println((char) n);
            }
            System.out.println("Total read: " + countInputStream.getBytes() + " bytes.");
        }
    }
}

// 统计输入文件的字节数
class CountInputStream extends FilterInputStream {
    private int count = 0;

    CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytes() {
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count++;
        }
        return n;
    }

    @Override
    public int read(byte[] b, int offset, int len) throws IOException {
        int n = in.read(b, offset, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}