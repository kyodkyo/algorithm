import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int k, m, n;
    static int[][] board;
    static boolean[][][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        board = new int[n][m];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        int[] dxCommon = {0, 1, -1, 0}, dyCommon = {1, 0, 0, -1};
        int[] dxSpecial = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dySpecial = {1, 2, 2, 1, -1, -2, -2, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0}); // x, y, horseMove, moveCount
        visited = new boolean[n][m][k+1];
        visited[0][0][0] = true;

        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int x=tmp[0], y=tmp[1], horse=tmp[2], moveCount=tmp[3];

            if (x==n-1 && y==m-1)
               return moveCount;

            for(int i=0; i<4; i++){
                int nx = x + dxCommon[i];
                int ny = y + dyCommon[i];

                if (isPossible(nx, ny, horse)){
                    q.add(new int[]{nx, ny, horse, moveCount+1});
                    visited[nx][ny][horse] = true;
                }
            }

            if (horse < k){
                for(int i=0; i<8; i++){
                    int nx = x + dxSpecial[i];
                    int ny = y + dySpecial[i];

                    if (isPossible(nx, ny, horse+1)){
                        q.add(new int[]{nx, ny, horse+1, moveCount+1});
                        visited[nx][ny][horse+1] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isPossible(int x, int y, int horse){
        return (0<=x && x<n && 0<=y && y<m && !visited[x][y][horse] && board[x][y]==0);
    }
}