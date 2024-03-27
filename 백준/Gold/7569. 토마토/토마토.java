import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, h;
    static int[][][] board;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        boolean check = true;
        board = new int[h][n][m];
        visited = new boolean[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                input = br.readLine().split(" ");
                for(int k=0; k<m; k++) {
                    board[i][j][k] = Integer.parseInt(input[k]);
                    if (board[i][j][k] == 0)
                        check = false;
                    else if (board[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        if (check)
            System.out.println(0);
        else
            System.out.println(bfs());
    }

    public static int bfs(){
        int count = 0;
        while(!q.isEmpty()){
            count++;
            checkTomato(q.size());
        }

        if (checkZero())
            return -1;
        else
            return count-1;
    }

    public static void checkTomato(int size){
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while(size-- > 0){
            int[] temp = q.poll();
            int z = temp[0];
            int x = temp[1];
            int y = temp[2];

            for(int i=0; i<6; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (0<=nx && nx<n && 0<=ny && ny<m && 0<=nz && nz<h && !visited[nz][nx][ny] && board[nz][nx][ny]==0){
                    board[nz][nx][ny] = 1;
                    visited[nz][nx][ny] = true;
                    q.add(new int[]{nz, nx, ny});
                }
            }
        }
    }

    public static boolean checkZero(){
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if (board[i][j][k] == 0)
                        return true;
                }
            }
        }
        return false;
    }
}