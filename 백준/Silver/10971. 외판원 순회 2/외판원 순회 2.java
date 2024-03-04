import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, start, res = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        for (int i = 0; i < n; i++) {
            start = i;
            visited = new boolean[n];
            visited[i] = true;
            dfs(0, i, 0);
        }
        System.out.println(res);
    }

    public static void dfs(int depth, int prev, int money) {
        if (depth == n-1) {
            if (board[prev][start] != 0) {
                money += board[prev][start];
                res = Math.min(res, money);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && board[prev][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, i, money + board[prev][i]);
                visited[i] = false;
            }
        }
    }
}