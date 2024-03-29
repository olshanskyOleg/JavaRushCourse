package com.javarush.task.pro.task14.task1411;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

/* 
Распаковка исключений
*/

public class Solution {

    public static final String FAILED_TO_READ = "Не удалось прочесть файл.";
    public static final String FAILED_TO_WRITE = "Не удалось записать в файл.";

    public static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        try {
            fileManager.copyFile("book.txt", "book_final_copy.txt");
            fileManager.copyFile("book_final_copy.txt", "book_last_copy.txt");
        }
        catch (RuntimeException e){
            Throwable exc = e.getCause();
            if (exc instanceof FileNotFoundException){
                System.out.println("Не удалось прочесть файл.");
            }
            else if (exc instanceof FileSystemException) {
                System.out.println("Не удалось записать в файл.");
            }
        }
        //напишите тут ваш код
    }
}
