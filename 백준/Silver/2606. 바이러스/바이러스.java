import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, k, count;
    static int[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int i=0; i<k; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            board[x][y] = board[y][x] = 1;
        }

        visited = new boolean[n];
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int cur){
        visited[cur] = true;

        for(int i=0; i<n; i++){
            if (!visited[i] && board[cur][i]==1){
                count++;
                dfs(i);
            }
        }
    }
}