package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String binaryNum = "";
        while (decimalNumber>0){
            binaryNum = String.valueOf(decimalNumber%2)+binaryNum;
            decimalNumber = (int) decimalNumber/2;
        }
        return binaryNum;
    }

    public static int toDecimal(String binaryNumber) {
        int decimalNum = 0;
        if (binaryNumber!=null) {
            int power = 0;
            char[] array = binaryNumber.toCharArray();
            for (char s : array) {
                decimalNum = decimalNum + Character.getNumericValue(s) * (int) Math.pow(2, array.length-1-power);
                power++;
            }
        }
        return decimalNum;
    }
}
