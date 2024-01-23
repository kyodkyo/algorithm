import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static int[][] board, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                visited[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y){
        if (x == n-1 && y == m-1)
            return 1;

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        if(visited[x][y] != -1)
            return visited[x][y];
        else {
            visited[x][y] = 0;
            for(int i=0; i<4; i++){
                int currX = x + dx[i];
                int currY = y + dy[i];

                if (!checkBoard(currX, currY))
                    continue;

                if (board[x][y] > board[currX][currY]){
                    visited[x][y] += dfs(currX, currY);
                }
            }
        }
        return visited[x][y];
    }

    public static boolean checkBoard(int x, int y){
        if (0<=x && x<n && 0<=y && y<m)
            return true;
        return false;
    }
}

