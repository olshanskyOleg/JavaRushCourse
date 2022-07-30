package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;

    private Snake snake;

    private int  turnDelay;

    private Apple apple;

    private boolean isGameStopped;

    private static final int GOAL = 28;

    private int score;

    @Override
    public  void  initialize(){
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void createGame(){
        isGameStopped = false;
        score = 0;
        setScore(score);
        snake = new Snake((int)WIDTH/2,(int) HEIGHT/2);
        createNewApple();
        drawScene();
        this.turnDelay = 300;
        setTurnTimer(this.turnDelay);
        // Apple apple = new Apple(7,7);
        //apple.draw(this);
    }
    private void drawScene(){
        for (int y=0;y<WIDTH;y++){
            for (int x=0;x<HEIGHT;x++){
                setCellValueEx(x, y, Color.GREY, "");
            }
        }
        snake.draw(this);
        apple.draw(this);

    }

    private void createNewApple(){
        apple = new Apple(getRandomNumber(WIDTH),getRandomNumber(HEIGHT));
        while (snake.checkCollision(apple)){
            apple = new Apple(getRandomNumber(WIDTH),getRandomNumber(HEIGHT));
        }
    }

    private void gameOver(){
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.BLACK, "Game over!", Color.WHITE, 75);
    }

    private void win(){
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.BLACK, "YOU WIN!!!", Color.WHITE, 75);
    }


    @Override
    public void onTurn(int t){
        snake.move(apple);
        if (apple.isAlive==false){
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (!snake.isAlive){
            gameOver();
        }
        if (snake.getLength()>GOAL){
            win();
        }
        this.drawScene();
    }
    @Override
    public void onKeyPress(Key key){

        switch (key){
            case LEFT : {this.snake.setDirection(Direction.LEFT); break;}
            case RIGHT : {this.snake.setDirection(Direction.RIGHT);break;}
            case UP : {this.snake.setDirection(Direction.UP);break;}
            case DOWN : {this.snake.setDirection(Direction.DOWN);break;}
            case SPACE: {if (isGameStopped){ createGame();}break;}
        }
    }
}
