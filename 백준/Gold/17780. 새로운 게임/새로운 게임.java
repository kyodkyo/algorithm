import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main{
    static final int WHITE = 0, RED = 1, BLUE = 2;
    static class Horse{
        int x, y, dir;

        public Horse(int r, int c, int dir){
            this.x = r;
            this.y = c;
            this.dir = dir;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] change = {1, 0, 3, 2};
    static int n, k, map[][];
    static Horse[] horses;
    static LinkedList<Integer>[][] player;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        map = new int[n][n];
        player = new LinkedList[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(line[j]);
                player[i][j] = new LinkedList<>();
            }
        }

        horses = new Horse[k+1];
        for(int i=1; i<=k; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            int dir = Integer.parseInt(line[2]) - 1;

            horses[i] = new Horse(x, y, dir);
            player[x][y].add(i);
        }

        System.out.println(game());
    }

    public static int game(){
        boolean flag = true;
        int count = 0;

        while(flag){
            count++;

            if (count > 1000)
                break;

            for(int i=1; i<=k; i++){
                Horse horse = horses[i];
                int x = horse.x;
                int y = horse.y;

                if (player[x][y].get(0) != i)
                    continue;

                int nx = x + dx[horse.dir];
                int ny = y + dy[horse.dir];

                if (nx<0 || n<=nx || ny<0 || n<=ny || map[nx][ny] == BLUE){
                    horse.dir = change[horse.dir];
                    nx = x + dx[horse.dir];
                    ny = y + dy[horse.dir];
                }

                if (nx<0 || n<=nx || ny<0 || n<=ny || map[nx][ny] == BLUE)
                    continue;
                else if (map[nx][ny] == RED){
                    for(int j=player[x][y].size()-1; j>=0; j--){
                        int tmp = player[x][y].get(j);
                        player[nx][ny].add(tmp);
                        horses[tmp].x = nx;
                        horses[tmp].y = ny;
                    }
                    player[x][y].clear();
                }
                else{
                    for(int j=0; j<player[x][y].size(); j++) {
                        int tmp = player[x][y].get(j);
                        player[nx][ny].add(tmp);
                        horses[tmp].x = nx;
                        horses[tmp].y = ny;
                    }
                    player[x][y].clear();
                }

                if (player[nx][ny].size() >= 4){
                    flag = false;
                    break;
                }

            }
        }
        return flag? -1 : count;
    }
}