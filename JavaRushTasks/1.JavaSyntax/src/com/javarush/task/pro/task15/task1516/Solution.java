package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";
  //  private static final String THIS_STR = "<введенная строка>";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            Path ourPath = Path.of(sc.nextLine());
            if (Files.isRegularFile(ourPath)){
                System.out.println(ourPath+THIS_IS_FILE);
            } else if (Files.isDirectory(ourPath)) {
                System.out.println(ourPath+THIS_IS_DIR);
            }
            else {
                break;
            }
        }
    }
}

