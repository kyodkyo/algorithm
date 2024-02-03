import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        q.add(new int[]{0, 0});
        bfs(maps);
        
        return maps[n-1][m-1] > 1? maps[n-1][m-1] : -1;
    }
    
    public static void bfs(int[][] maps){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!q.isEmpty()){
            int[] pos = q.poll(); 
            
            for(int i=0; i<4; i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                
                if (0<=nx && nx<n && 0<=ny && ny<m && maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[pos[0]][pos[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}