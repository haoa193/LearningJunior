package com.haoa193.tij.chapter18.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chenyong on 2015/6/26.
 */
public class Echo {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while ((s = bufferedReader.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }


    }

}
