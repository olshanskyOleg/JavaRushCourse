package com.javarush.task.pro.task11.task1101;

/* 
Солнечная система — наш дом
*/

public class Solution {


    public static void main(String[] args) {

        System.out.println("Человечество живет в Солнечной системе.");
       // System.out.println("Ее возраст около 4568200000 лет.");
        System.out.println(String.format("Ее возраст около %1$d лет.",SolarSystem.age));
        System.out.println(String.format("В Солнечной системе %1$d известных планет.",SolarSystem.planetsCount));
        System.out.println(String.format("Как и большинство звездных систем, состоит из %1$d звезды.",SolarSystem.starsCount));
        System.out.println(String.format("Звезды по имени %1$s.",SolarSystem.starName));
        System.out.println(String.format("Расстояние к центру галактики составляет %1$d световых лет.",SolarSystem.galacticCenterDistance));
        System.out.println("Каждый обитатель Солнечной системы должен знать эту информацию!");

    }
}
