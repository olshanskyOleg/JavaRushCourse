package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        int octalNum = 0;
        int power = 0;
        while (decimalNumber>0){
            octalNum = octalNum+decimalNumber%8*(int)Math.pow(10,power);
            decimalNumber = (int)(decimalNumber/8);
            power++;
        }
        return octalNum;
    }

    public static int toDecimal(int octalNumber) {
        int decimalNum = 0;
        int power = 0;
        while (octalNumber>0){
            decimalNum = decimalNum+octalNumber%10*(int)Math.pow(8,power);
            octalNumber = (int)(octalNumber/10);
            power++;
        }
        return decimalNum;
    }
}
