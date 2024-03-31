import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, year = 0, board[][];
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++)
                board[i][j] = Integer.parseInt(input[j]);
        }

        int group = 0;
        while(!isAllMelt()){
            group = checkBoard();
            if (group >= 2)
                break;
            year++;
            melting();
        }

        if (group == 1)
            System.out.println(0);
        else
            System.out.println(year);
    }

    public static boolean isAllMelt(){
        for(int[] row : board){
            for(int n : row){
                if (n != 0)
                    return false;
            }
        }
        return true;
    }
    public static int checkBoard(){
        visited = new boolean[n][m];
        q = new LinkedList<>();

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (!visited[i][j] && board[i][j] != 0){
                    count++;
                    if (count >= 2)
                        return count;
                    bfs(i, j);
                }
            }
        }
        return count;
    }

    public static void bfs(int x, int y){
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (0<=nx && nx<n && 0<=ny && ny<m && !visited[nx][ny] && board[nx][ny]!=0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    public static void melting(){
        boolean[][] meltVisit = new boolean[n][m];
        Queue<int[]> meltQ = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    meltQ.add(new int[]{i, j});
                    meltVisit[i][j] = true;
                }
            }
        }

        while(!meltQ.isEmpty()){
            int[] t = meltQ.poll();

            int nx, ny, count = 0;
            for(int k=0; k<4; k++){
                nx = t[0] + dx[k];
                ny = t[1] + dy[k];

                if (0<=nx && nx<n && 0<=ny && ny<m && !meltVisit[nx][ny] && board[nx][ny] == 0)
                    count++;
            }
            board[t[0]][t[1]] = board[t[0]][t[1]]-count < 0? 0 : board[t[0]][t[1]]-count;
        }
    }
}
