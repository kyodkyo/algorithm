import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, k, r;
    static boolean[][] visited;
    static ArrayList<Node>[][] roads;
    static int answer, cows[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        cows = new int[k][2];
        roads = new ArrayList[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                roads[i][j] = new ArrayList<>();
        }
        visited = new boolean[n][n];
        for(int i=0; i<r; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            int c = Integer.parseInt(line[2]) - 1;
            int d = Integer.parseInt(line[3]) - 1;
            roads[a][b].add(new Node(c, d));
            roads[c][d].add(new Node(a, b));
        }

        for(int i=0; i<k; i++){
            String[] line = br.readLine().split(" ");
            cows[i][0] = Integer.parseInt(line[0]) - 1;
            cows[i][1] = Integer.parseInt(line[1]) - 1;
        }

        for(int i=0; i<k; i++)
            bfs(cows[i][0], cows[i][1], i);
        System.out.println(answer);
    }

    public static void bfs(int x, int y, int index){
        visited = new boolean[n][n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                boolean flag = false;
                for(int j=0; j<roads[node.x][node.y].size(); j++){
                    Node tmp = roads[node.x][node.y].get(j);
                    if (nx == tmp.x && ny == tmp.y){
                        flag = true;
                        break;
                    }
                }

                if (flag || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
        for(int i=index; i<cows.length; i++)
            if (!visited[cows[i][0]][cows[i][1]])
                answer++;
    }
}