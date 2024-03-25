import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, board[][];
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] destroy, nonDestroy;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][m];
        for(int i=0; i<n; i++){
            input = br.readLine().split("");
            for(int j=0; j<m; j++)
                board[i][j] = Integer.parseInt(input[j]);
        }

        destroy = new boolean[n][m];
        nonDestroy = new boolean[n][m];
        nonDestroy[0][0] = true;
        q.add(new int[]{0, 0, 1, 0}); // x, y, distance, wall O/1

        System.out.println(bfs());
    }

    public static int bfs(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            int x = tmp[0], y = tmp[1];
            int distance = tmp[2], wall = tmp[3];

            if (x==n-1 && y==m-1)
                return distance;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || n<=nx || ny<0 || m<=ny)
                    continue;

                if(wall == 1){
                    if (board[nx][ny]==0 && !destroy[nx][ny]){
                        destroy[nx][ny] = true;
                        q.add(new int[]{nx, ny, distance+1, 1});
                    }
                }
                else{
                    if (board[nx][ny]==1){
                        destroy[nx][ny] = true;
                        q.add(new int[]{nx, ny, distance+1, 1});
                    }
                    else if(!nonDestroy[nx][ny]){
                        nonDestroy[nx][ny] = true;
                        q.add(new int[]{nx, ny, distance+1, 0});
                    }
                }
            }
        }
        return -1;
    }
}