import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> minerals;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new char[r][c];

        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++)
                map[i][j] = line.charAt(j);
        }

        int throwCount = Integer.parseInt(br.readLine());
        String[] heights = br.readLine().split(" ");
        for(int i=0; i<throwCount; i++){
            int height = Integer.parseInt(heights[i]);
            removeMineral(i, height);
            visited = new boolean[r][c];
            floorMirs();
            if (floatingMirs())
                moveMirs();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++)
                sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void removeMineral(int ni, int height){
        height = r - height;

        if (ni % 2 == 0){
            for(int i=0; i<c; i++){
                if (map[height][i] == 'x'){
                    map[height][i] = '.';
                    break;
                }
            }
        }
        else {
            for(int i=c-1; i>=0; i--){
                if (map[height][i] == 'x'){
                    map[height][i] = '.';
                    break;
                }
            }
        }
    }
    public static void floorMirs(){
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<c; i++){
            if (map[r-1][i] == 'x' && !visited[r-1][i]){
                q.add(new int[]{r-1, i});
                visited[r-1][i] = true;
            }

            while(!q.isEmpty()){
                int[] tmp = q.poll();

                for(int t=0; t<4; t++){
                    int nx = tmp[0] + dx[t];
                    int ny = tmp[1] + dy[t];

                    if (isRange(nx, ny) && map[nx][ny]=='x' && !visited[nx][ny]){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y){
        return 0<=x && x<r && 0<=y && y<c;
    }

    public static boolean floatingMirs(){
        minerals = new ArrayList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (map[i][j] == 'x' && !visited[i][j]){
                    minerals.add(new int[]{i, j});
                    map[i][j] = '.';
                    visited[i][j] = true;
                }
            }
        }

        return minerals.size() > 0;
    }

    public static void moveMirs(){
        int minDrop = Integer.MAX_VALUE;

        for (int[] mineral : minerals) {
            int x = mineral[0];
            int y = mineral[1];
            int drop = 0;

            while (x + drop + 1 < r && map[x + drop + 1][y] == '.') {
                drop++;
            }
            minDrop = Math.min(minDrop, drop);
        }

        for (int[] mineral : minerals)
            map[mineral[0] + minDrop][mineral[1]] = 'x';
    }
}