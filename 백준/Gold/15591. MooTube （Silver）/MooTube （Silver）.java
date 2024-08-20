import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        List<int[]>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            adj[i] = new ArrayList<>();

        for(int i=1; i<n; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int r = Integer.parseInt(line[2]);

            adj[a].add(new int[]{b, r});
            adj[b].add(new int[]{a, r});
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++){
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            boolean[] visited = new boolean[n+1];
            visited[v] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            int answer = 0;
            while (!queue.isEmpty()){
                int cur = queue.poll();

                for(int[] tmp : adj[cur]){
                    if (!visited[tmp[0]] && tmp[1]>=k){
                        queue.add(tmp[0]);
                        visited[tmp[0]] = true;
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}