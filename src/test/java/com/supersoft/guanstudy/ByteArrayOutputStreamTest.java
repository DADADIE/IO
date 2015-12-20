package com.supersoft.guanstudy;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;

/**
 * User:hacker
 * Date:2015/12/20
 * Time:17:12
 * Description:This class is created to 学习ByteArrayOutputStream的使用
 * 输入输出流的说法都是基于内存的角度命名的
 */
public class ByteArrayOutputStreamTest {
    private static ByteArrayOutputStream byteArrayOutputStream;
    private static ByteArrayInputStream byteArrayInputStream;
    private static DataOutputStream dataOutputStream;
    private static DataInputStream dataInputStream;
    private static int a;
    private static int b;
    private static int c;

    @BeforeClass
    public static void prepareResources(){
        a = 1;
        b = 2;
        c = 3;
    }

    @Test
    public void testByteArrayStream(){
        //ByteArrayOutputStream可以捕获内存缓冲区的数据，转换成字节数组
        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(a);
        byteArrayOutputStream.write(b);
        byteArrayOutputStream.write(c);
        byte[] buf = byteArrayOutputStream.toByteArray();//获取内存缓冲中的数据
        for(int i=0;i<=buf.length;i++){
            System.out.println(buf);
        }
        //ByteArrayInputStream可以将字节数组转化为输入流
        byteArrayInputStream = new ByteArrayInputStream(buf);
        while((b=byteArrayInputStream.read())!=-1){
            System.out.println(b);
        }
    }
    @Test
    public void testDataStream() throws IOException {
        //DataOutputStream&DataInputStream联合使用
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        String name = "guan";
        int age = 25;
        dataOutputStream.writeUTF(name);
        dataOutputStream.writeInt(age);
        byte[] buf = byteArrayOutputStream.toByteArray();
        byteArrayInputStream = new ByteArrayInputStream(buf);
        dataInputStream = new DataInputStream(byteArrayInputStream);
        String nameOut = dataInputStream.readUTF();
        int ageOut = dataInputStream.readInt();
        System.out.println(nameOut);
        System.out.println(ageOut);
    }
    @AfterClass
    public static void cleanResources() throws IOException {
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
    }
}
