import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static class Ball{
        int redX, redY, blueX, blueY, count;

        public Ball(int redX, int redY, int blueX, int blueY, int count){
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }
    static int n, m;
    static char[][] board;
    static Queue<Ball> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new char[n][m];

        Ball ball = new Ball(0, 0, 0, 0, 0);
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R'){
                    ball.redX = i;
                    ball.redY = j;
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B'){
                    ball.blueX = i;
                    ball.blueY = j;
                    board[i][j] = '.';
                }
            }
        }
        q.add(ball);

        System.out.println(moveBoard());
    }

    static int rx, ry, bx, by;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static int moveBoard(){
        while (!q.isEmpty()){
            Ball tmp = q.poll();

            if (tmp.count >= 10)
                continue;

            for(int i=0; i<4; i++){
                rx = tmp.redX;
                ry = tmp.redY;
                bx = tmp.blueX;
                by = tmp.blueY;

                boolean redHole = moveRed(i);
                boolean blueHole = moveBlue(i);

                if (blueHole)
                    continue;

                if (redHole)
                    return tmp.count + 1;

                if (rx==bx && ry==by)
                    moveSameLine(i, tmp);

                q.add(new Ball(rx, ry, bx, by, tmp.count+1));
            }
        }
        return -1;
    }

    public static boolean moveRed(int i){
        boolean redHole = false;

        while (true){
            int nrx = rx + dx[i];
            int nry = ry + dy[i];

            if (board[nrx][nry] == '#')
                break;

            if (board[nrx][nry] == 'O'){
                redHole = true;
                break;
            }

            rx = nrx;
            ry = nry;
        }
        return redHole;
    }

    public static boolean moveBlue(int i){
        boolean blueHole = false;

        while(true){
            int nbx = bx + dx[i];
            int nby = by + dy[i];

            if (board[nbx][nby] == '#')
                break;

            if (board[nbx][nby] == 'O'){
                blueHole = true;
                break;
            }

            bx = nbx;
            by = nby;
        }
        return blueHole;
    }

    public static void moveSameLine(int i, Ball tmp){
        if (i==0){
            if (tmp.redY < tmp.blueY)
                ry--;
            else
                by--;
        }
        else if (i==1){
            if (tmp.redX < tmp.blueX)
                rx--;
            else
                bx--;
        }
        else if (i==2){
            if (tmp.redY < tmp.blueY)
                by++;
            else
                ry++;
        }
        else {
            if (tmp.redX < tmp.blueX)
                bx++;
            else
                rx++;
        }
    }
}