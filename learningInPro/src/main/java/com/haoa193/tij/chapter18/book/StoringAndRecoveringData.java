package com.haoa193.tij.chapter18.book;

import java.io.*;

/**
 * Created by chenyong on 2015/6/26.
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {

        DataOutputStream out = new DataOutputStream(new FileOutputStream("data.text"));

        out.writeDouble(3.14159);
        out.writeUTF("That was a pi");
        out.writeDouble(1.41413);
        out.writeUTF("square root of 2");
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("data.text"));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());


    }


}
