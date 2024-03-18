import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int max = 0;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                checkRec1(0, board[i][j], i, j);
                visited[i][j] = false;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                checkRec2(i, j);
            }
        }
        System.out.println(max);
    }

    public static void checkRec1(int depth, int sum, int x, int y) {
        if (depth == 3) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (checkBoard(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                checkRec1(depth + 1, sum + board[nx][ny], nx, ny);
                visited[nx][ny] = false;
            }
        }
    }

    public static void checkRec2(int x, int y){
        for(int i=0; i<4; i++){
            boolean check = true;
            int sum = 0;

            for(int j=0; j<4; j++){
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];

                if (checkBoard(nx, ny))
                    sum += board[nx][ny];
                else{
                    check = false;
                    break;
                }
            }

            if (check)
                max = Math.max(max, sum);
        }
    }
    public static boolean checkBoard(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m)
            return true;
        return false;
    }
}