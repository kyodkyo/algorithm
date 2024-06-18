import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m, cities[];
    static ArrayList<ArrayList<Integer>> bridges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        bridges = new ArrayList<>();
        for(int i=0; i<=n; i++)
            bridges.add(new ArrayList<>());

        for(int i=1; i<=n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                if (i==j || line[j-1].equals("1"))
                    bridges.get(i).add(j);
            }
        }

        cities = new int[m];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<m; i++)
            cities[i] = Integer.parseInt(line[i]);

        boolean plan = true;
        for(int i=0; i<m-1; i++){
            if (!isValidPlan(cities[i], cities[i+1])){
                plan = false;
                break;
            }
        }
        System.out.println(plan==true? "YES" : "NO");
    }

    public static boolean isValidPlan(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0; i<bridges.get(cur).size(); i++){
                int next = bridges.get(cur).get(i);

                if (next == end)
                    return true;
                if (!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return false;
    }
}