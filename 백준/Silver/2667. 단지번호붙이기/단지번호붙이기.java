import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main{
    static int n;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<n; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        int town = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (board[i][j]==1 && !visited[i][j]){
                    counts.add(bfs(i, j, town, board, visited));
                    town++;
                }
            }
        }
        Collections.sort(counts);

        System.out.println(town-2);
        for(int num : counts)
            System.out.println(num);
    }

    public static int bfs(int i, int j, int town, int[][] board, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        board[i][j] = town;

        int count = 1;
        while (!q.isEmpty()){
            int[] pos = q.poll();

            for(int k=0; k<4; k++){
                int nx = pos[0] + dx[k];
                int ny = pos[1] + dy[k];

                if (0<=nx && nx<n && 0<=ny && ny<n && board[nx][ny]==1 && !visited[nx][ny]){
                    count++;
                    board[nx][ny] = town;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}