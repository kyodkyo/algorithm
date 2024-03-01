import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int m, n;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);

            board = new int[m][n];
            visited = new boolean[m][n];
            for(int i=0; i<k; i++){
                String[] line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                board[x][y] = 1;
            }

            int count = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if (board[i][j]==1 && !visited[i][j]){
                        count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isPossible(nx, ny))
                dfs(nx, ny);
        }
    }

    public static boolean isPossible(int x, int y){
        if (0<=x && x<m && 0<=y && y<n && board[x][y]==1 && !visited[x][y])
            return true;
        return false;
    }
}