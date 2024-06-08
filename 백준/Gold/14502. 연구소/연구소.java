import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
    static int[][] map;
    static int n, m, max = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth){
        if (depth == 3){
            checkVirus();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void checkVirus(){
        int[][] virusMap = new int[n][m];
        for(int i=0; i<n; i++)
            virusMap[i] = map[i].clone();

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (virusMap[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int[] vi = q.poll();

            for(int i=0; i<4; i++){
                int nx = vi[0] + dx[i];
                int ny = vi[1] + dy[i];

                if (0<=nx && nx<n && 0<=ny && ny<m && virusMap[nx][ny] == 0){
                    virusMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        countSafe(virusMap);
    }

    public static void countSafe(int[][] virusMap){
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (virusMap[i][j] == 0)
                    count++;
            }
        }
        max = Math.max(max, count);
    }
}