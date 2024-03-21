import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, board[][];
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        visited = new boolean[n][m];

        int k = Integer.parseInt(input[2]);
        for(int i=0; i<k; i++){
            String[] line = br.readLine().split(" ");
            int startX = Integer.parseInt(line[1]);
            int startY = Integer.parseInt(line[0]);
            int endX = Integer.parseInt(line[3]);
            int endY = Integer.parseInt(line[2]);

            for(int x=startX; x<endX; x++){
                for(int y=startY; y<endY; y++)
                    board[x][y] = 1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (!visited[i][j] && board[i][j]==0) {
                    visited[i][j] = true;
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() + "\n");
        for(int n : list)
            sb.append(n + " ");
        System.out.println(sb);
    }

    public static int bfs(int x, int y){
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            count++;

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(checkBoard(nx, ny)){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return count;
    }

    public static boolean checkBoard(int x, int y){
        if (0<=x && x<n && 0<=y && y<m && board[x][y]==0 && !visited[x][y])
            return true;
        return false;
    }
}