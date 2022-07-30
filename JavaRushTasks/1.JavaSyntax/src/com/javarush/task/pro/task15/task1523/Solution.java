package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        OutputStream stream = connection.getOutputStream();
        stream.write(1);
        InputStream input = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        while (br.ready()){
            System.out.println(br.readLine());
        }
    }
}

