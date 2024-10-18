import java.util.*;

class Solution {
    static ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();
        
        for(int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            list[v1].remove(Integer.valueOf(v2));
            list[v2].remove(Integer.valueOf(v1));
            
            int count = dfs(1, visited);
            int diff = Math.abs(count - (n - count));
            min = Math.min(min, diff);
            
            list[v1].add(v2);
            list[v2].add(v1);
        }
        
        return min;
    }
    
    public static int dfs(int start, boolean[] visited){
        int count = 1;
        visited[start] = true;
        
        for(int v : list[start]){
            if (!visited[v])
                count += dfs(v, visited);
        }
        
        return count;
    }
}