import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static Queue<int[]> q;
    static boolean[] visited;
    static ArrayList<int[]> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        while(cases-- > 0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            q = new LinkedList<>();
            q.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
            visited = new boolean[n];

            list = new ArrayList<>();
            for(int i=0; i<n; i++){
                input = br.readLine().split(" ");
                list.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
            }
            input = br.readLine().split(" ");
            int ex = Integer.parseInt(input[0]);
            int ey = Integer.parseInt(input[1]);

            sb.append(bfs(ex, ey, visited));
        }
        System.out.println(sb);
    }

    public static String bfs(int ex, int ey, boolean[] visited){
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            if (Math.abs(ex-tmp[0]) + Math.abs(ey-tmp[1]) <= 1000)
                return "happy\n";

            for(int i=0; i<list.size(); i++){
                int nx = list.get(i)[0];
                int ny = list.get(i)[1];

                if (!visited[i] && Math.abs(nx-tmp[0]) + Math.abs(ny-tmp[1]) <= 1000){
                    q.add(new int[]{nx, ny});
                    visited[i] = true;
                }
            }
        }
        return "sad\n";
    }
}