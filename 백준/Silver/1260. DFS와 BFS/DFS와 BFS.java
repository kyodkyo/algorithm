import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        board = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);
            board[n1][n2] = 1;
            board[n2][n1] = 1;
        }

        boolean[] visited = new boolean[n+1];
        dfs(start, visited);
        sb.append("\n");
        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int node, boolean[] visited){
        visited[node] = true;
        sb.append(node + " ");

        for(int i=1; i<=n; i++){
            if (board[node][i]==1 && !visited[i])
                dfs(i, visited);
        }
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int start = q.poll();
            sb.append(start + " ");

            for(int i=1; i<=n; i++){
                if (board[start][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}