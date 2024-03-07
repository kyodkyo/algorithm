import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[m][n];

        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (board[i][j]==1)
                    q.add(new int[]{i, j});
            }
        }
        bfs(q);
    }

    public static void bfs(Queue<int[]> q){
        int count = 0;
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            count = board[x][y];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0<=nx && nx<m && 0<=ny && ny<n && board[nx][ny]==0){
                    board[nx][ny] = board[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        checkTomato(count);
    }

    public static void checkTomato(int count){
        for(int[] row : board){
            for(int col : row){
                if (col == 0) {
                    count = 0;
                    break;
                }
            }
        }
        System.out.println(count-1);
    }
}