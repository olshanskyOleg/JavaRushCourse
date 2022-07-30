package com.javarush.task.pro.task16.task1608;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Просто день недели
*/

public class Solution {

    static LocalDate birthDate = LocalDate.of(2020, 3, 12);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(LocalDate date) {
        //напишите тут ваш код
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));
       // Calendar calendar = new GregorianCalendar(date.getYear(),date.getMonth().getValue()-1,date.getDayOfMonth());
      //  calendar.getDisplayName(calendar.get(Calendar.DAY_OF_WEEK),Calendar.LONG_STANDALONE, new Locale("ru","RU")) return ;
    }
}
