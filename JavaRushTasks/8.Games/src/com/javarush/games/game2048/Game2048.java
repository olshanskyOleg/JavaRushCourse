package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Game2048 extends Game {
    private static final int SIDE =4;
    private int[][]gameField = new int[SIDE][SIDE];

    private boolean isGameStopped = false;

    private int score;

    private void createGame(){
        score =0;
        setScore(score);
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void  drawScene(){
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber(){
        if (getMaxTileValue()==2048){
            win();
        }
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        int j = getRandomNumber(10);
        int num=0;
        num = j==9?4:2;
        if (gameField[y][x] == 0){
            gameField[y][x]=num;
        }
        else {
            createNewNumber();
        }
    }

    private Color getColorByValue(int value){
        HashMap<Integer,Color> colors = new HashMap<Integer,Color>();
        colors.put(0,Color.WHITE);
        colors.put(2,Color.BLUE);
        colors.put(4,Color.CORAL);
        colors.put(8,Color.BISQUE);
        colors.put(16,Color.ALICEBLUE);
        colors.put(32,Color.BEIGE);
        colors.put(64,Color.BLUEVIOLET);
        colors.put(128,Color.CHOCOLATE);
        colors.put(256,Color.AQUAMARINE);
        colors.put(512,Color.FIREBRICK);
        colors.put(1024,Color.GREEN);
        colors.put(2048,Color.HONEYDEW);
        return colors.get(value);
    }

    private void setCellColoredNumber(int x, int y, int value){

        Color color = getColorByValue(value);
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, color, str);
    }

    private boolean compressRow(int[] row){
        boolean wasChange = false;
        int currIndex = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i]!=0){
                if (currIndex!=i){
                    row[currIndex]=row[i];
                    row[i]=0;
                    wasChange = true;
                }
                currIndex++;
            }
        }
        return wasChange;
    }

    private boolean mergeRow(int[] row){
        boolean wasChange = false;
        for (int i = 0; i < row.length-1; i++) {
            if (row[i] == row[i+1]&&row[i]!=0){
                score = score+row[i]+row[i+1];
                row[i] = row[i]+row[i+1];
                row[i+1]=0;
                i++;
                wasChange = true;
                setScore(score);
            }
        }

        return wasChange;
    }

    private void moveLeft(){
        boolean newNumber = false;
        for (int i = 0; i <SIDE ; i++) {
            boolean b1 = compressRow(gameField[i]);
            boolean b2 = mergeRow(gameField[i]);
            boolean b3 = compressRow(gameField[i]);
            if (b1||b2||b3){
                newNumber = true;
            }
        }
        if (newNumber){createNewNumber();};
    }

    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
        int[][] tempArray = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            int rowNumber = SIDE - 1 - i;
            for (int j = 0; j < SIDE; j++) {
                tempArray[j][rowNumber]=gameField[i][j];
            }
        }
        gameField = tempArray;
    }

    private int getMaxTileValue(){
        return Arrays.stream(gameField).flatMapToInt(x->Arrays.stream(x)).sorted().max().getAsInt();
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU WIN!!!", Color.WHITE, 75);
    }

    private  void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER!!!", Color.WHITE, 75);
    }

    private boolean canUserMove(){
        boolean isCanMove = false;
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                if (gameField[x][y]==0){
                    isCanMove = true;
                    break;
                }
                if ((x>0&&gameField[x][y]==gameField[x-1][y])||(y>0&&gameField[x][y]==gameField[x][y-1])){
                    isCanMove = true;
                    break;
                }
            }
            if (isCanMove) break;
        }
        return isCanMove;
    }

    @Override
    public void onKeyPress(Key key){
        if (isGameStopped){
            if (key == Key.SPACE){
                isGameStopped = false;
                createGame();
                drawScene();
            }
            return;
        }
        if (canUserMove()){
            switch (key){

                case LEFT : {moveLeft();drawScene();break;}
                case RIGHT: {moveRight();drawScene();break;}
                case UP:{moveUp();drawScene();break;}
                case DOWN:{moveDown();drawScene();break;}
            }
        }
        else gameOver();
    }

    @Override
    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();

    }
}
