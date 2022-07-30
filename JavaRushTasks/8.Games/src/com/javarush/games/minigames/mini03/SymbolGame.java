package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {

    public void initialize(){
        setScreenSize(8, 3);
        String s ="JAVARUSH";
        int x=0;
        for (char i :s.toCharArray()) {
            setCellValueEx(x, 1, Color.ORANGE, Character.toString(i));
            x++;
        }

    }
}
