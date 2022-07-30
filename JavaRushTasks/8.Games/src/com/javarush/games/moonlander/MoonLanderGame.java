package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game{
    public final static int WIDTH =64;
    public final static int HEIGHT=64;

    private GameObject landscape;

    private Rocket rocket;

    private GameObject platform;

    private boolean isUpPressed;
    private boolean isRightPressed;
    private boolean isLeftPressed;

    @Override
    public void initialize(){
        setScreenSize(WIDTH,HEIGHT);
        showGrid(false);
        createGame();
    }

    private void createGameObjects(){
        rocket = new Rocket((double)WIDTH/2,0);
        landscape = new GameObject(0,25,ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23,HEIGHT-1,ShapeMatrix.PLATFORM);
    }

    private void createGame(){
        isLeftPressed = false;
        isUpPressed = false;
        isRightPressed = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x,y,Color.BLACK);
            }
        }
        rocket.draw(this);
        landscape.draw(this);


    }

    private void check(){
        if (rocket.isCollision(landscape)&&!rocket.isCollision(platform)){
            gameOver();

        } else if (rocket.isCollision(platform)&&rocket.isStopped()) {
            win();
        }
    }

    private void win(){

    }

    private void gameOver(){

    }

    @Override
    public void onTurn(int step){
        rocket.move(isUpPressed,isLeftPressed,isRightPressed);
        check();
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color){
        if (x>=0&&y>=0&&x<WIDTH&&y<HEIGHT){
            super.setCellColor(x,y,color);

        }
    }

    @Override
    public void onKeyPress(Key key){
        switch (key){
            case UP : {isUpPressed = true;break;}
            case LEFT: {isLeftPressed = true; isRightPressed = false; break;}
            case RIGHT: {isLeftPressed = false; isRightPressed = true; break;}
        }

    }

    @Override
    public void onKeyReleased(Key key){
        switch (key){
            case UP : {isUpPressed = false;break;}
            case LEFT:{isLeftPressed = false;break;}
            case RIGHT:{isRightPressed = false; break;}
        }

    }
}
