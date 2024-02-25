import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int height = 0;
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line[j]);
                height = Math.max(height, map[i][j]);
            }
        }

        int max = 0;
        for(int h=1; h<=height; h++){
            int town = 0;
            boolean[][] visited = new boolean[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (!visited[i][j] && map[i][j] >= h){
                        town++;
                        dfs(i, j, visited, h);
                    }
                }
            }
            max = Math.max(max, town);
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, boolean[][] visited, int height){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && map[nx][ny] >= height)
                dfs(nx, ny, visited, height);
        }
    }
}