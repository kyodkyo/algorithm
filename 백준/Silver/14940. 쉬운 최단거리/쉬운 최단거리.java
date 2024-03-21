import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, board[][];
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    board[i][j] = 0;
                }
            }
        }
        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (!visited[i][j] && board[i][j]==1)
                    sb.append(-1 + " ");
                else
                    sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};


        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0) {
                int[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (checkBoard(nx, ny)) {
                        q.add(new int[]{nx, ny});
                        board[nx][ny] = board[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean checkBoard(int x, int y){
        if (0<=x && x<n && 0<=y && y<m && !visited[x][y] && board[x][y]==1)
            return true;
        return false;
    }
}