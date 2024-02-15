import java.util.*;

class Solution {
    public static ArrayList<Integer>[] list;
    public static int[] visited;
    public static int depth = 0;
    
    public int solution(int n, int[][] edge) {
        visited = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) 
            list[i] = new ArrayList<>();
        
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        int answer = 0;
        bfs(1, 1);
        
        for(int i=1; i<=n; i++){
            if(depth == visited[i]) 
                answer+=1;
        }
        
        return answer;
    }
    
    private void bfs(int start, int count){
        Queue<Integer> q = new LinkedList();
        q.add(start);
        q.add(count);
        visited[start] = count;
        
        while(!q.isEmpty()){
            int node = q.poll();
            int n = q.poll();
            
            if(depth < n) 
                depth = n;
            
            for(int i=0; i<list[node].size(); i++){
                int next = list[node].get(i);
                
                if(visited[next] != 0) 
                    continue;
                visited[next] = n+1;
                q.add(next);
                q.add(n+1);
            }
        }
    }
}