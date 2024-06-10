import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int r, c;
    static char[][] board;
    static int[][] fTime, jTime;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> fQueue = new LinkedList<>();
    static Queue<int[]> jQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        board = new char[r][c];
        fTime = new int[r][c];
        jTime = new int[r][c];
        for(int i=0; i<r; i++){
            String line = br.readLine();
            for(int j=0; j<c; j++) {
                board[i][j] = line.charAt(j);
                fTime[i][j] = -1;
                jTime[i][j] = -1;

                if (board[i][j] == 'J') {
                    jQueue.add(new int[]{i, j});
                    jTime[i][j] = 0;
                }

                if (board[i][j] == 'F') {
                    fQueue.add(new int[]{i, j});
                    fTime[i][j] = 0;
                }
            }
        }

        fireBFS();
        int time = jBFS();
        System.out.println(time==-1? "IMPOSSIBLE" : time);
    }

    public static void fireBFS(){
        while(!fQueue.isEmpty()){
            int[] tmp = fQueue.poll();

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx<0 || nx>=r || ny<0 || ny>=c)
                    continue;
                if (fTime[nx][ny]>=0 || board[nx][ny]=='#')
                    continue;
                fTime[nx][ny] = fTime[tmp[0]][tmp[1]] + 1;
                fQueue.add(new int[]{nx, ny});
            }
        }
    }

    public static int jBFS(){
        while(!jQueue.isEmpty()){
            int[] tmp = jQueue.poll();

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (nx<0 || nx>=r || ny<0 || ny>=c)
                    return jTime[tmp[0]][tmp[1]] + 1;

                if (jTime[nx][ny]>=0 || board[nx][ny]=='#')
                    continue;
                if (fTime[nx][ny]!=-1 && fTime[nx][ny] <= jTime[tmp[0]][tmp[1]] + 1)
                    continue;

                jTime[nx][ny] = jTime[tmp[0]][tmp[1]] + 1;
                jQueue.add(new int[]{nx, ny});
            }
        }
        return -1;
    }
}