package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws java.io.IOException {

        InputStream source = null;
        OutputStream dest = null;
        try (Scanner sc = new Scanner(System.in);){
       //     Path path1 = Path.of(sc.nextLine());
       //     Path path2 = Path.of(sc.nextLine());
            source = Files.newInputStream(Paths.get(sc.nextLine()));
            dest = Files.newOutputStream(Paths.get(sc.nextLine()));
            byte[] array = new byte[2];
            while (source.available()>0){
                int count = source.read(array);
                if (count==2){
                    byte b = array[0];
                    array[0] = array[1];
                    array[1] = b;
                }
                dest.write(array,0,count);
            }
        }
        catch(Exception e){
            System.out.println("Error file name");
        }
        finally {
            if (source!=null){
                source.close();
            }
            if (dest!=null){
                dest.close();
            }
        }

    }
}

