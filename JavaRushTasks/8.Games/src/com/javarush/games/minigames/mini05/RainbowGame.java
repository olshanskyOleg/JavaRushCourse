package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize(){
        ArrayList<Color> colorsSet = new ArrayList<>(Arrays.asList(Color.RED,Color.ORANGE,Color.YELLOW,
                Color.GREEN,Color.BLUE, Color.INDIGO,Color.VIOLET));
        setScreenSize(10, 7);
        for (int y = 0; y <7 ; y++) {
            for (int x = 0; x < 10; x++) {
                setCellColor(x,y,colorsSet.get(y));
            }
        }
    }
}
