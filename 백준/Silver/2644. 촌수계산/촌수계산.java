import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, x, y, result = -1;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]) - 1;
        y = Integer.parseInt(input[1]) - 1;

        board = new int[n][n];
        visited = new boolean[n];
        int lines = Integer.parseInt(br.readLine());
        for(int i=0; i<lines; i++){
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]) - 1;
            int e = Integer.parseInt(line[1]) - 1;
            board[s][e] = board[e][s] = 1;
        }
        visited[x] = true;
        dfs(x, 0);
        System.out.println(result);
    }

    public static void dfs(int cur, int depth){
        if (cur == y){
            result = depth;
            return;
        }

        for(int i=0; i<n; i++){
            if (board[cur][i] == 1 && !visited[i]){
                visited[cur] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}