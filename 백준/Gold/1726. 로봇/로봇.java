import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static class Robot{
        int x, y, dir, count;

        public Robot(int x, int y, int dir, int count){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Robot> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        visited = new boolean[n][m][4];
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        input = br.readLine().split(" ");
        int sd = Integer.parseInt(input[2]) - 1;
        if (sd==1 || sd==2)
            sd = sd==1? 2 : 1;
        Robot sRobot = new Robot(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1, sd, 0);

        input = br.readLine().split(" ");
        int ed = Integer.parseInt(input[2]) - 1;
        if (ed==1 || ed==2)
            ed = ed==1? 2 : 1;
        Robot eRobot = new Robot(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1, ed, 0);

        q.add(sRobot);
        visited[sRobot.x][sRobot.y][sRobot.dir] = true;
        System.out.println(bfs(eRobot));
    }

    public static int bfs(Robot eRobot){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while(!q.isEmpty()){
            Robot cur = q.poll();

            if (cur.x==eRobot.x && cur.y==eRobot.y && cur.dir==eRobot.dir)
                return cur.count;

            for(int i=1; i<=3; i++){
                int nx = cur.x + (dx[cur.dir] * i);
                int ny = cur.y + (dy[cur.dir] * i);

                if (nx<0 || n<=nx || ny<0 || m<=ny || map[nx][ny]==1)
                    break;
                if (visited[nx][ny][cur.dir])
                    continue;

                visited[nx][ny][cur.dir] = true;
                q.add(new Robot(nx, ny, cur.dir, cur.count+1));
            }

            if (!visited[cur.x][cur.y][(cur.dir+3) % 4]){
                visited[cur.x][cur.y][(cur.dir+3) % 4] = true;
                q.add(new Robot(cur.x, cur.y, (cur.dir+3) % 4, cur.count+1));
            }

            if (!visited[cur.x][cur.y][(cur.dir+1) % 4]){
                visited[cur.x][cur.y][(cur.dir+1) % 4] = true;
                q.add(new Robot(cur.x, cur.y, (cur.dir+1) % 4, cur.count+1));
            }
        }
        return -1;
    }
}