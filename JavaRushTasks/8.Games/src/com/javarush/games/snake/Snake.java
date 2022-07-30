package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<GameObject>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y){
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x+1, y));
        snakeParts.add(new GameObject(x+2, y));
    }

    public void draw(Game game){
        //setssnakeParts.get(0)
        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE,HEAD_SIGN,isAlive?Color.BLACK:Color.RED,75);
        game.setCellValueEx(snakeParts.get(1).x, snakeParts.get(1).y,Color.NONE, BODY_SIGN,isAlive?Color.BLACK:Color.RED,75);
        game.setCellValueEx(snakeParts.get(2).x, snakeParts.get(2).y,Color.NONE, BODY_SIGN,isAlive?Color.BLACK:Color.RED,75);
    }

    public void setDirection(Direction directnew){
        /*boolean subx = (snakeParts.get(0).x-snakeParts.get(1).x)==0;
        boolean suby = (snakeParts.get(0).y-snakeParts.get(1).y)==0;
        if (subx&&(direction == Direction.LEFT||direction==Direction.RIGHT)){return;}
        if (suby&&(direction == Direction.DOWN||direction==Direction.UP)){return;}
        this.direction = direction;
        if ((direction.ordinal()-this.direction.ordinal())*(direction.ordinal()-this.direction.ordinal())!=4){this.direction = direction;}*/
        if ( ((direction==Direction.RIGHT) || (direction==Direction.LEFT)) && (snakeParts.get(0).x == snakeParts.get(1).x)  ) {
            return;
        }

        if ( (direction==Direction.DOWN || direction==Direction.UP) && (snakeParts.get(0).y == snakeParts.get(1).y) ) {
            return;
        }
        this.direction = directnew;
    }

    public void move(Apple apple){
        GameObject newHead = createNewHead();

        if (!checkCollision(newHead)&&newHead.x>=0&&newHead.y>=0&&newHead.x<SnakeGame.WIDTH&&newHead.y<SnakeGame.HEIGHT){
            snakeParts.add(0,newHead);
            if (newHead.x == apple.x&&newHead.y == apple.y){
                apple.isAlive = false;
            }
            else {
                removeTail();
            }
        }
        else {
            this.isAlive = false;
        }

    }

    public GameObject createNewHead(){
        switch (direction){
            case LEFT: return new GameObject(snakeParts.get(0).x-1,snakeParts.get(0).y);
            case RIGHT: return new GameObject(snakeParts.get(0).x+1,snakeParts.get(0).y);
            case DOWN: return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y+1);
            case UP: return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y-1);
        }
        return null;
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gameObject){
        return snakeParts.stream().anyMatch(o->o.x == gameObject.x&&o.y== gameObject.y);
    }

    public int getLength(){
        return snakeParts.size();
    }
}
