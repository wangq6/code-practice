package com.leetcode.java.algorithm;

public class GameOfLife {
    private int[][] board2D;
    private int[] board1D;
    private int size1D;
    private int m;
    private int n;
    private final static int LIVE = 2;
    private final static int DEAD = 3;

    public int[][] getBoard2D() {
        return board2D;
    }

    public int[] getBoard1D() {
        return board1D;
    }

    public void setBoard2D(int[][] board2D) {
        this.board2D = board2D;
        this.m = board2D.length;
        this.n = board2D[0].length;
    }

    public void setBoard1D(int[] board1D) {
        this.board1D = board1D;
        this.size1D = board1D.length;
    }

    public void nextGeneration1D() {
        for (int i = 0; i < size1D; i++) {
            int liveCount = (board1D[(i + size1D - 1) % size1D] % 2) + (board1D[(i + size1D + 1) % size1D] % 2);
            if (liveCount == 1) { // change status
                if (board1D[i] == 0) {
                    board1D[i] = LIVE; // 0 <- 1
                } else {
                    board1D[i] = DEAD; // 1 <- 0
                }
            }
        }

        for (int i = 0; i < size1D; i++) {
            if (board1D[i] == LIVE) {
                board1D[i] = 1;
            }
            if (board1D[i] == DEAD) {
                board1D[i] = 0;
            }
            
        }
    }

    public void nextGeneration2D() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = neighborAlive2D(i, j);
                if (board2D[i][j] == 0 || board2D[i][j] == 2) {
                    if (count == 3) {
                        board2D[i][j] = LIVE;
                    }
                } else {
                    if (count < 2 || count > 3) {
                        board2D[i][j] = DEAD;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board2D[i][j] == LIVE) {
                    board2D[i][j] = 1;
                }
                if (board2D[i][j] == DEAD) {
                    board2D[i][j] = 0;
                }
            }
        }
    }

    private int neighborAlive2D(int i, int j) {
        int count = 0;
        int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 };
        int[] dy = { 1, -1, 0, 1, -1, 0, 1, -1 };
        for (int k = 0; k < 8; k++) {
            int new_i = i + dx[k];
            int new_j = j + dy[k];
            if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n) {
                count += board2D[new_i][new_j] % 2;
            }
        }
        return count;
    }
}
