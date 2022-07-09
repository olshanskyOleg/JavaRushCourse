package com.javarush.task.pro.task08.task0817;

/* 
Инкременты
*/

public class Solution {

    public static void main(String[] args) {
        int a = 3;
//        int c = 3;
//        int d = 3;
//        System.out.println(c--*c++);
        //System.out.println(--d*d++);
//        int e = (--d*d++);
//        System.out.println(e);
//        System.out.println(d++ + e);
        int b = ++a + (a-- * ++a);

        System.out.println(b);
    }
}