package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Vasya", 4.2);
        grades.put("Petya", 4.5);
        grades.put("Kolya", 4.7);
        grades.put("Svitlana", 4.9);
        grades.put("Oleg", 4.1);
    }
}
