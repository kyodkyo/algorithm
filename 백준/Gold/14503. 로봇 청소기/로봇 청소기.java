import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, m, x, y, dir, count = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        dir = Integer.parseInt(input[2]);

        board = new int[n][m];
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++)
                board[i][j] = Integer.parseInt(input[j]);
        }

        System.out.println(cleaning());
    }

    public static int cleaning(){
        int count = 0;
        
        while(true){
            if (board[x][y]==0){
                board[x][y] = 2;
                count++;
            }

            //4방향 청소 안된 빈칸 확인
            boolean isClean = false;
            for(int i=0; i<4; i++){
                int gx = x + dx[i];
                int gy = y + dy[i];

                if (0<=gx && gx<n && 0<=gy && gy<m && board[gx][gy]==0){
                    isClean = true;
                    break;
                }
            }

            if (isClean){
                dir = (dir + 3) % 4;
                int bx = x + dx[dir];
                int by = y + dy[dir];

                if (0<=bx && bx<n && 0<=by && by<m && board[bx][by]==0) {
                    x = bx;
                    y = by;
                }
            }
            else{
                int nx = x + dx[(dir + 2) % 4];
                int ny = y + dy[(dir + 2) % 4];

                if (0<=nx && nx<n && 0<=ny && ny<m){
                    if (board[nx][ny] != 1){
                        x = nx;
                        y = ny;
                    }
                    else
                        break;
                }
            }
        }
        return count;
    }
}