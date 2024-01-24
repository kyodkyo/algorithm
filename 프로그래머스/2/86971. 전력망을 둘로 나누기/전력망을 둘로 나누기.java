import java.util.*;

class Solution{
    static int min = 100;
    static ArrayList<ArrayList<Integer>> list;

    public int solution(int n, int[][] wires) {
        list = new ArrayList<>();
        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<wires.length; i++){
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        for(int i=0; i<wires.length; i++){
            list.get(wires[i][0]).remove(Integer.valueOf(wires[i][1]));
            list.get(wires[i][1]).remove(Integer.valueOf(wires[i][0]));

            boolean[] visited = new boolean[n+1];
            int count = dfs(1, visited);
            min = Math.min(min, Math.abs(count - (n-count)));

            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        return min;
    }

    public static int dfs(int n, boolean[] visited){
        visited[n] = true;

        int count = 1;
        for(int v : list.get(n)){
            if (!visited[v])
                count += dfs(v, visited);
        }
        return count;
    }
}