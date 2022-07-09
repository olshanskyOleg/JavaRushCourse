package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Iphone))
            return false;

        Iphone iphone = (Iphone) obj;

        boolean isEqual =(this.model ==null ? iphone.model==null : this.model.equals(iphone.model))&&(this.color == null ? iphone.color == null: this.color.equals(iphone.color))&&this.price==iphone.price;
        return isEqual;
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);
        boolean b = iphone1.equals(iphone2);
        System.out.println(iphone1.equals(iphone2));
    }

}
