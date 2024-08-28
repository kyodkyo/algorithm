import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Moving{
        int x, y, depth;

        public Moving(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        Moving robot = null, goal = null;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char c = board[i].charAt(j);
                
                if (c == 'R')
                    robot = new Moving(i, j, 0);
                if (c == 'G')
                    goal = new Moving(i, j, 0);
            }
        }
        
        return bfs(board, robot, goal);
    }
    
    public static int bfs(String[] board, Moving robot, Moving goal){
        Queue<Moving> q = new LinkedList<>();
        q.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.x][robot.y] = true;
        
        while(!q.isEmpty()){
            Moving cur = q.poll();
            
            if (cur.x == goal.x && cur.y == goal.y)
                return cur.depth;
            
            for(int i=0; i<4; i++){
                int nx = cur.x;
                int ny = cur.y;
                
                while(0<=nx && nx<n && 0<=ny && ny<m && board[nx].charAt(ny) != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (visited[nx][ny] || (cur.x == nx && cur.y == ny))
                    continue;
                visited[nx][ny] = true;
                q.add(new Moving(nx, ny, cur.depth + 1));
            }
        }
        return -1;
    }
}