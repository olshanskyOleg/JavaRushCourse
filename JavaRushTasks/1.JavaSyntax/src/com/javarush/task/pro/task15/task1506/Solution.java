package com.javarush.task.pro.task15.task1506;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws java.io.IOException {
        Scanner sc = new Scanner(System.in);
        Path path = Path.of(sc.nextLine());
        try{
            var listStr = Files.readAllLines(path);
            for(String s:listStr){
                String newStr = s.replaceAll("\\.","").replaceAll(",","").replaceAll(" ","");
                System.out.println(newStr);
            }
        }
        catch(Exception e){
            System.out.println("error");

        }
        finally {
            sc.close();
        }

    }
}

