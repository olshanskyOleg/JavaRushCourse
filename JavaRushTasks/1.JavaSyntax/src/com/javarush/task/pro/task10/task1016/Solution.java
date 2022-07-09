package com.javarush.task.pro.task10.task1016;

/* 
Прогноз погоды
*/

public class Solution {

    public static void showWeather(City city) {
        System.out.println(String.format("В городе %1$s сегодня температура воздуха %2$d",city.getName(),city.getTemperature()));
    }

    public static void main(String[] args) {
        City city = new City("Дубай",40);
        showWeather(city);
    }
}
