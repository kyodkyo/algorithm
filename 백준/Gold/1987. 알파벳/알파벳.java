import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, count=1;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashSet<Character> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new char[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++)
                board[i][j] = line.charAt(j);
        }
        dfs(0, 0);

        System.out.println(count);
    }

    public static void dfs(int x, int y){
        if (hashSet.contains(board[x][y])){
            count = Math.max(count, hashSet.size());
            return;
        }

        hashSet.add(board[x][y]);
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<n && 0<=ny && ny<m) {
                dfs(nx, ny);
            }
        }
        hashSet.remove(board[x][y]);
    }
}