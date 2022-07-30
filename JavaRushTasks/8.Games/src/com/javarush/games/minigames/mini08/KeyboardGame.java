package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;
import com.sun.javafx.css.StyleCacheEntry;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }
    @Override
    public void onKeyPress(Key key){
        for (int i = 0; i < 3; i++) {
            switch (key){
                case LEFT:{setCellColor(0,i,Color.GREEN);break;}
                case RIGHT:{setCellColor(2,i,Color.GREEN);break;}
                case UP:{setCellColor(i,0,Color.GREEN);break;}
                case DOWN:{setCellColor(i,2,Color.GREEN);break;}
            }
        }

    }

    @Override
    public void onKeyReleased(Key key){
        for (int i = 0; i < 3; i++) {
            switch (key){
                case LEFT:{setCellColor(0,i,Color.WHITE);break;}
                case RIGHT:{setCellColor(2,i,Color.WHITE);break;}
                case UP:{setCellColor(i,0,Color.WHITE);break;}
                case DOWN:{setCellColor(i,2,Color.WHITE);break;}
            }
        }
    }

    //напишите тут ваш код
}
