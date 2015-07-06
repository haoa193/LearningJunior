package com.haoa193.tij.chapter17.exercises;

import java.util.*;

/**
 * Created by chenyong on 2015/6/17.
 */
public class MyTest {

    public static void main(String[] args) {

        System.out.println(getNum());
        System.out.println(getNum());
        System.out.println(getNum());
        System.out.println(getNum());



//        Date.from()


    }

    static int count=0;
    public static String getNum(){
        String[] srcStr = "1 2 3 4 5 6 7 8 9".split(" ");
        StringBuilder sb = new StringBuilder();
        for (int j=0;j < 6;count++,j++){
            int index= count % srcStr.length;
            sb.append(srcStr[index]);
            if (index==0){
                count=0;
            }
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }


    public boolean equals(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public void main_bak(){

        List<String> list = new ArrayList<String>();
        ListIterator listIterator = list.listIterator();


        SortedSet<String> ss = new TreeSet<String>();

        OutClass.InnerClass innerClass = new OutClass().new InnerClass();
//        Map.Entry


    }

}

class OutClass{
    class InnerClass{

    }
}


