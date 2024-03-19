import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static char[][] map;
    static Queue<int[]> move = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new char[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S')
                    move.add(new int[]{i, j});
                if (map[i][j] == '*')
                    water.add(new int[]{i, j});
            }
        }

        int result = bfs();
        System.out.println(result != -1? result : "KAKTUS");
    }

    public static int bfs(){
        int time = 0;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {-1, 0, 0, 1};

        while (!move.isEmpty()) {
            int size = water.size();
            while (size-- > 0) {
                int[] tmp = water.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = tmp[0] + dx[i];
                    int ny = tmp[1] + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        water.add(new int[]{nx, ny});
                    }
                }
            }

            time++;
            size = move.size();
            while (size-- > 0) {
                int[] tmp = move.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = tmp[0] + dx[i];
                    int ny = tmp[1] + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (map[nx][ny] == 'D')
                            return time;
                        else if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            move.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

}