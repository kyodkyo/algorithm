import java.util.*;

class Solution {
    static int[] answer = new int[2];
    static boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        answer[0] = 0;
        answer[1] = 0;
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (!visited[i][j] && picture[i][j] > 0) {
                    bfs(i, j, m, n, picture);
                    answer[0]++;
                }
            }
        }
        return answer;
    }
    
    public static void bfs(int x, int y, int m, int n, int[][] picture){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = picture[cur[0]][cur[1]];

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (0<=nx && nx<m && 0<=ny && ny<n && !visited[nx][ny] && picture[nx][ny]==num){
                    visited[nx][ny] = true;
                    count++;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        answer[1] = Math.max(answer[1], count);
    }
}