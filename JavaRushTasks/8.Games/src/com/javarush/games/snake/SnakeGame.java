package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    @Override
    public  void  initialize(){
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void createGame(){
        drawScene();
        Apple apple = new Apple(7,7);
        apple.draw(this);
    }
    private void drawScene(){
        for (int y=0;y<WIDTH;y++){
            for (int x=0;x<HEIGHT;x++){
                setCellColor(x,y,Color.GREY);
            }
        }

    }
}
