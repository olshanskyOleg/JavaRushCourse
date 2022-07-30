package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        try {
            var s = Files.readAllLines(Paths.get(sc.nextLine()));
            for (int i = 0; i < s.size(); i++) {
                if (i%2==0) {
                    System.out.println(s.get(i));
                }
            }

        }
        finally {
            sc.close();
        }
    }
}

