package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\\uD83D\\uDCA3";

    private static final String FLAG = "\uD83D\uDEA9";

    private int countFlags;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y){
        openTile(x,y);
    }

    private void openTile(int x, int y){
        if (gameField[y][x].isMine){
            setCellValue(x,y,MINE);
        }
        else if (gameField[y][x].countMineNeighbors!=0){
                setCellNumber(x,y,gameField[y][x].countMineNeighbors);
            }
        else {
      /*      for (GameObject currentObj:getNeighbors(gameField[y][x])){
                if (!currentObj.isOpen){
                    openTile(currentObj.x,currentObj.y);
                }
            }*/
            setCellValue(x,y,"");
        }

        gameField[y][x].isOpen=true;
        setCellColor(x,y,Color.GREY);

    }
    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void countMineNeighbors(){
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                if (!gameField[y][x].isMine){
                    List<GameObject> n = getNeighbors(gameField[y][x]);
                    for (GameObject k:n){
                        if (k.isMine){
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }

        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
}