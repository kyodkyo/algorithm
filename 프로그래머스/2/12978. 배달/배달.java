import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Node{
        int s, e, w;
        public Node(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<road.length; i++){
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
        }

        int[] visited = new int[N+1];
        for(int i=2; i<visited.length; i++)
            visited[i] = Integer.MAX_VALUE;

        return bfs(list, visited, K);
    }
    
    public static int bfs(ArrayList<ArrayList<Node>> list, int[] visited, int K){
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        q.addAll(list.get(1));

        while(!q.isEmpty()){
            Node n = q.poll();

            if (visited[n.e] >= visited[n.s] + n.w){
                visited[n.e] = visited[n.s] + n.w;
                q.addAll(list.get(n.e));
            }
        }

        for(int i=2; i<visited.length; i++)
            if (visited[i] <= K)
                count++;

        return count;
    }
}