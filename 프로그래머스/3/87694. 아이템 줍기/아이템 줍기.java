import java.util.*;

class Solution {
    static int[][] board = new int[102][102];
    
    public int solution(int[][] rectangle, int sx, int sy, int ex, int ey) {
        for(int [] rec : rectangle){
            rec[0] *= 2; 
            rec[1] *= 2;
            rec[2] *= 2; 
            rec[3] *= 2;
            
            for(int i=rec[0]; i<=rec[2]; i++){
                for(int j=rec[1]; j<=rec[3]; j++){
                    if (board[i][j] == 1)
                        continue;
                    
                    board[i][j] = 1;
                    
                    if (i==rec[0] || i==rec[2] || j==rec[1] || j==rec[3])
                        board[i][j] = 2;
                }
            }
        }
        
        return bfs(sx*2, sy*2, ex*2, ey*2);
    }
    
    public static int bfs(int sx, int sy, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            int count = pos[2];
            
            if (x==ex && y==ey)
                return count/2;
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (!visited[nx][ny] && board[nx][ny]==2){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                }
            }
        }
        return 0;
    }
}