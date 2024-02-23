import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int result;
    static boolean[] visited;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        board = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            board[a][b] = 1;
            board[b][a] = 1;
        }

        result = 0;
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if (!visited[i]){
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    public static void dfs(int i){
        visited[i] = true;

        for(int k=0; k<board.length; k++){
            if (board[i][k] == 1 && !visited[k]){
                dfs(k);
            }
        }
    }
}