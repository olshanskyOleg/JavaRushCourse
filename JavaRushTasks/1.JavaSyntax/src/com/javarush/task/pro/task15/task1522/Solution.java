package com.javarush.task.pro.task15.task1522;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        var stream = url.openStream();
        byte[] buffer = stream.readAllBytes();
        String s = new String(buffer);
        System.out.println(s);
    }
}