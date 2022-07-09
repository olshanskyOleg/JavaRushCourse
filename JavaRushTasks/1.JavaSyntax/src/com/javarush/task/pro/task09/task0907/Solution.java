package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }
    private static int[] hexToIntArray(String hexNumber){
        int[] array = new int[hexNumber.length()];
        int i = hexNumber.length()-1;
        for (char s:hexNumber.toUpperCase().toCharArray()){
            switch (s) {
                case 'A' :array[i]=10;
                case 'B' :array[i]=11;
                case 'C' :array[i]=12;
                case 'D' :array[i]=13;
                case 'E' :array[i]=14;
                case 'F' :array[i]=15;
                default:array[i]=Character.getNumericValue(s);
            }
            i--;
        }
        return array;
    }

    private static char intToHexDigit(int intDigit){
        return Character.forDigit(intDigit,16);

    }
    public static String toHex(int decimalNumber) {
        String hexNumber="";
        while (decimalNumber>0){
            hexNumber = intToHexDigit(decimalNumber%16) +hexNumber;
            decimalNumber = (int) (decimalNumber/16);
        }
        return hexNumber;
    }

    public static int toDecimal(String hexNumber) {
        int decimalNum=0;
        if(hexNumber!=null) {
            int[] array = hexToIntArray(hexNumber);
            int power = 0;
            for (int i : array) {
                decimalNum = decimalNum + (int) (i * Math.pow(16, power));
                power++;
            }
        }
        return decimalNum;
    }
}
