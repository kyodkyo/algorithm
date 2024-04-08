import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int x, y, time, use;

        public Node(int x, int y, int time, int use) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.use = use;
        }
    }
    static int n, m, board[][], min;
    static boolean visited[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.valueOf(input[0]);
        m = Integer.valueOf(input[1]);
        min = Integer.MAX_VALUE;

        board = new int[n][n];
        visited = new boolean[2][n][n];

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                board[i][j] = Integer.parseInt(input[j]);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int count = 0;
                
                if (board[i][j]==0) {
                    if ((i-1>=0 && board[i-1][j]==0) || (i+1<n && board[i+1][j]==0))
                        count++;
                    if ((j-1>=0 && board[i][j-1]==0) || (j+1<n && board[i][j+1]==0))
                        count++;
                }
                
                if (count == 2)
                    board[i][j] = -1;
            }
        }

        bfs();
        System.out.println(min);
    }

    static void bfs() {
        int dx[] = { -1, 1, 0, 0 };
        int dy[] = { 0, 0, -1, 1 };
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visited[1][0][0] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.x == n-1 && cur.y == n-1) {
                min = Math.min(min, cur.time);
                return;
            }
            
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ntime = cur.time + 1;
                
                if (nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny]==-1)
                    continue;
                
                if (board[nx][ny] == 0) {
                    if (ntime % m != 0)
                        q.add(new Node(cur.x, cur.y, cur.time + 1, cur.use));
                        
                    else if (cur.use>0 && board[cur.x][cur.y] == 1 && !visited[0][nx][ny]) {
                        visited[0][nx][ny] = true;
                        q.add(new Node(nx, ny, ntime, 0));
                    }
                } 
                else if (board[nx][ny] == 1 && !visited[cur.use][nx][ny]) {
                    visited[cur.use][nx][ny] = true;
                    q.add(new Node(nx, ny, ntime, cur.use));
                } 
                else if (board[nx][ny] >= 2) {
                    if (ntime % board[nx][ny] != 0)
                        q.add(new Node(cur.x, cur.y, ntime, cur.use));
                    else if (board[cur.x][cur.y] == 1 && !visited[cur.use][nx][ny]) {
                        visited[cur.use][nx][ny] = true;
                        q.add(new Node(nx, ny, ntime, cur.use));
                    }
                }
            }
        }
    }
}
