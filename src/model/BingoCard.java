package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BingoCard {
    private int[][] grid = new int[5][5];

    public BingoCard() {
        super();
        createCard();
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        return "BingoCard{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }

    // fill card with random cards
    private void createCard() {
        for (int column = 0; column < grid.length; column++) {
            Stack<Integer> temp = new Stack<>();

            for (int i = column * 15 + 1; i <= (column + 1) * 15; i++)
                temp.add(i);

            Collections.shuffle(temp);

            for (int row = 0; row < grid[column].length; row++) {
                grid[row][column] = temp.pop();
            }
        }
        grid[2][2] = 0;
    }

    // check if this card has a bingo
    public boolean checkBingo() {
        // check rows
        for (int[] ints : grid) {
            int count = 0;
            for (int anInt : ints)
                if (anInt == 0)
                    count++;

            if (count == 5)
                return true;
        }

        // check columns
        for (int col = 0; col < grid.length; col++) {
            int count = 0;
            for (int r = 0; r < grid[col].length; r++)
                if (grid[r][col] == 0)
                    count++;

            if (count == 5)
                return true;
        }

        // check diagonal top left to bottom right
        int count = 0;
        for (int index = 0; index < grid.length; index++) {
            if (grid[index][index] == 0)
                count++;

            if (count == 5)
                return true;
        }

        // check diagonal bottom left to top right
        count = 0;

        for (int index = grid.length - 1; index >= 0; index--) {
            if (grid[index][grid.length - 1 - index] == 0)
                count++;

            if (count == 5)
                return true;
        }

        return false;
    }

}
