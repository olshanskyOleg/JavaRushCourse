package com.javarush.task.pro.task15.task1511;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Пишем символы в файл
*/

public class Solution {
    public static void main(String[] args) {
        char[] chars = args[0].toCharArray();
        try (InputStream stream = System.in;
             Scanner scanner = new Scanner(stream);
             var writer = Files.newBufferedWriter(Paths.get(scanner.nextLine()));) {
             //var writer = Files.newBufferedWriter(Paths.get(scanner.nextLine()));
            writer.write(chars,0,chars.length);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}


