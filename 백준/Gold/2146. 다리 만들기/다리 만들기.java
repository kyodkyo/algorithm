import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, map[][], min=Integer.MAX_VALUE;
    static boolean[][] visited;
    static Queue<int[]> q;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        int group = 1;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (!visited[i][j] && map[i][j] != 0){
                    map[i][j] = group;
                    findIsland(i, j, group);
                    group++;
                }
            }
        }

        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (!visited[i][j] && map[i][j]!=0){
                    visited = new boolean[n][n];
                    makeBridge(i, j, map[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    public static void findIsland(int i, int j, int group){
        visited[i][j] = true;
        q = new LinkedList<>();
        q.add(new int[]{i, j});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (checkMap(nx, ny) && map[nx][ny]!=0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = group;
                }
            }
        }
    }


    public static void makeBridge(int i, int j, int island){
        visited[i][j] = true;
        q = new LinkedList<>();
        q.add(new int[]{i, j, 0});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int len = tmp[2];

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (checkMap(nx, ny) && map[nx][ny] != island){
                    if (map[nx][ny] == 0){
                        q.add(new int[]{nx, ny, len + 1});
                        visited[nx][ny] = true;
                    }
                    else{
                        min = Math.min(min, len);
                        return;
                    }
                }
            }
        }
    }
    public static boolean checkMap(int x, int y){
        if (0<=x && x<n && 0<=y && y<n && !visited[x][y])
            return true;
        return false;
    }
}