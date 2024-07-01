import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Town implements Comparable<Town>{
    int end;
    int cost;

    public Town(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Town t){
        return this.cost - t.cost;
    }
}

public class Main{
    static int n, m, x, cost[], rCost[];
    static List<Town>[] list, rList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);

        list = new ArrayList[n+1];
        rList = new ArrayList[n+1];
        cost = new int[n+1];
        rCost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(rCost, Integer.MAX_VALUE);

        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int t = Integer.parseInt(line[2]);

            list[a].add(new Town(b, t));
            rList[b].add(new Town(a, t));
        }

        dijkstra(list, cost);
        dijkstra(rList, rCost);

        int answer = 0;
        for(int i=1; i<n+1; i++)
            answer = Math.max(answer, cost[i] + rCost[i]);
        System.out.println(answer);
    }

    static void dijkstra(List<Town>[] towns, int[] dist){
        Queue<Town> q = new PriorityQueue<>();
        q.add(new Town(x, 0));
        dist[x] = 0;

        while(!q.isEmpty()){
            Town t = q.poll();

            for(Town next : towns[t.end]) {
                if (dist[next.end] > dist[t.end] + next.cost) {
                    dist[next.end] = dist[t.end] + next.cost;
                    q.add(new Town(next.end, dist[next.end]));
                }
            }
        }
    }
}