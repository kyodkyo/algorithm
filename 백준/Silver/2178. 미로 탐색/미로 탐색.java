import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<m; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        bfs();
        System.out.println(board[n-1][m-1]);
    }

    public static void bfs(){
        visited = new boolean[n][m];
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (checkBoard(nx, ny)) {
                    q.add(new int[]{nx, ny});
                    board[nx][ny] += board[x][y];
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static boolean checkBoard(int x, int y){
        if (0<=x && x<n && 0<=y && y<m && !visited[x][y] && board[x][y]==1)
            return true;
        return false;
    }
}