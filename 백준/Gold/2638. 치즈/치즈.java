import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, board[][];
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            count++;
            visited = new boolean[n][m];
            checkAir(0, 0);
            q = melting(q);
        }
        System.out.println(count);
    }

    public static void checkAir(int x, int y){
        board[x][y] = -1;
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<n && 0<=ny && ny<m && !visited[nx][ny] && board[nx][ny] != 1)
                checkAir(nx, ny);
        }
    }

    public static Queue<int[]> melting(Queue<int[]> q){
        Queue<int[]> cheese = new LinkedList<>();

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            int air = 0;
            for(int t=0; t<4; t++){
                int nx = tmp[0] + dx[t];
                int ny = tmp[1] + dy[t];

                if (board[nx][ny] == -1)
                    air++;
            }
            if (air >= 2)
                board[tmp[0]][tmp[1]] = 0;
            else
                cheese.add(new int[]{tmp[0], tmp[1]});
        }
        return cheese;
    }
}