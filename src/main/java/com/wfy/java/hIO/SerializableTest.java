package com.wfy.java.hIO;

import java.io.*;
import java.util.Arrays;

/**
 * @Description
 * @Package com.wfy.java.hIO
 * @Author wfy
 * @Version V1.0.0
 * @Date 2020/12/23 15:01
 */

public class SerializableTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            output.writeInt(12345);
            output.writeUTF("hello, world");
            output.writeDouble(123.456);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(buffer.toByteArray());
        try(ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream)){
            int i = objectInputStream.readInt();
            String j = objectInputStream.readUTF();
            Double k = objectInputStream.readDouble();
            System.out.println(i);
            System.out.println(j);
            System.out.println(k);

        }

    }
}
