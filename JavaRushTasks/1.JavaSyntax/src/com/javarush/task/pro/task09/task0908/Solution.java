package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    private static int[] hexToIntArray(String hexNumber){
        if (!hexNumber.equals(hexNumber.toLowerCase())){
            return new  int[0];
        }
        int[] intArray = new int[hexNumber.length()];
        int i = hexNumber.length() - 1;
        for (char s:hexNumber.toCharArray()){

            if(Character.getNumericValue(s)>15||Character.getNumericValue(s)<0){
                return new  int[0]; }
            else {intArray[i]=Character.getNumericValue(s);};
            i--;
        }
        return intArray;
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null){
            return "";
        }
        int decimalNum=0;
        int i = binaryNumber.length()-1;
        for (char s : binaryNumber.toCharArray()){
            if (s!='0'&&s!='1'){
                return "";}
            else{
                decimalNum = decimalNum+(int)(Character.getNumericValue(s)*Math.pow(2,i));
            }
            i--;

        }
        String hexNum="";
        while (decimalNum>0){
            hexNum = Character.forDigit(decimalNum%16,16)+hexNum;
            decimalNum = (int)(decimalNum/16);
        }
        return hexNum;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null){
            return "";
        }
        long decimalNum = 0L;
        int[] digitArray = hexToIntArray(hexNumber);
        int power =0;
        for (int i:digitArray){
            decimalNum = decimalNum+(long)(i*Math.pow(16,power));
            power++;
        }
        String binaryNum = "";
        if(digitArray.length>0&&decimalNum==0){
            return "0";
        }
        while (decimalNum>0){
            binaryNum = Character.forDigit((int)(decimalNum%2),2)+binaryNum;
            decimalNum = (long) (decimalNum/2);
        }
        return binaryNum;
    }
}
