package org.example.etc;

import java.util.Scanner;

/**
 * 문제
 * n * n크기의 직사각형의 가운데에서 시작하여 오른쪽, 위, 왼쪽, 아래 순서로
 * 더 이상 채울 곳이 없을 때까지 회전하며 숫자를 채운다.
 * <p>
 * Ex) 3 * 3
 * 5 4 3
 * 6 1 2
 * 7 8 9
 */
public class SnailProblem {

    static int n;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};

        int x = n / 2, y = n / 2, dir = 0, moveCount = 1, num = 1;

        while (checkBoard(x, y)) {
            for (int i = 0; i < moveCount; i++) {
                board[x][y] = num++;
                x += dx[dir];
                y += dy[dir];

                if (!checkBoard(x, y))
                    break;
            }
            dir = (dir + 1) % 4;
            if (dir == 0 || dir == 2)
                moveCount++;
        }

        printBoard();
    }

    public static boolean checkBoard(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n)
            return true;
        else
            return false;
    }

    public static void printBoard() {
        for (int[] row : board) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }

}
