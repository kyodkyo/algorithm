import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, L, R, map[][];
    static boolean flag, visited[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        map = new int[n][n];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        System.out.println(moveWorld());
    }

    public static int moveWorld(){
        int result = 0;
        while (true) {
            flag = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j])
                        bfs(i, j);
                }
            }

            if (!flag)
                return result;
            result++;
        }
    }

    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        q.add(new int[]{i, j});
        list.add(new int[]{i, j});
        visited[i][j] = true;
        
        int sum = map[i][j];
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if (0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny]){
                    int diff = Math.abs(map[tmp[0]][tmp[1]] - map[nx][ny]);
                    if (L<=diff && diff<=R){
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                        q.add(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                    }
                }
            }
        }

        for(int[] pair : list)
            map[pair[0]][pair[1]] = sum / list.size();

        if(list.size() > 1)
            flag = true;
    }
}