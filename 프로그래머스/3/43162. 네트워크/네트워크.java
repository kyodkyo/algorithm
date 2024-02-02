class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int count = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if (!visited[i]){
                count++;
                dfs(i, n, computers);
            }
        }
        return count;
    }
    
    public static void dfs(int i, int n, int[][] computers){
        visited[i] = true;
        
        for(int j=0; j<n; j++){
            if (computers[i][j] == 1 && !visited[j])
                dfs(j, n, computers);
        }
    }
}

/**
 *  < BFS 풀이 >
 *
 * class Solution {
 *     static boolean[] visited;
 *     static Queue<Integer> q = new LinkedList<>();
 *
 *     public int solution(int n, int[][] computers) {
 *         visited = new boolean[n];
 *
 *         int answer = 0;
 *         for(int i=0; i<n; i++){
 *             if (!visited[i]){
 *                 answer++;
 *                 bfs(i, n, computers);
 *             }
 *         }
 *
 *         return answer;
 *     }
 *
 *     public static void bfs(int i, int n, int[][] computers){
 *         q.offer(i);
 *         visited[i] = true;
 *
 *         while(!q.isEmpty()){
 *             int com = q.poll();
 *
 *             for(int j=0; j<n; j++){
 *                 if (computers[com][j]==1 && !visited[j]){
 *                     q.offer(j);
 *                     visited[j] = true;
 *                 }
 *             }
 *         }
 *     }
 * }
 *
 */