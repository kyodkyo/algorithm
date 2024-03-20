import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int n, m, groupNum;
    static int[][] groups;
    static int[] oilCount;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        groups = new int[n][m];
        oilCount = new int[n * m];

        groupNum = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (groups[i][j]==0 && land[i][j]==1){
                    groups[i][j] = groupNum;
                    oilCount[groupNum] = bfs(i, j, land);
                    groupNum++;
                }
            }
        }
        return findMax();
    }
    
    public static int bfs(int x, int y, int[][] land){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        int count = 1;
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if (checkLand(nx, ny, land)){
                    groups[nx][ny] = groupNum;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean checkLand(int x, int y, int[][] land){
        if (0<=x && x<n && 0<=y && y<m && groups[x][y]==0 && land[x][y]==1)
            return true;
        return false;
    }

    public static int findMax(){
        int max = 0;

        for(int j=0; j<m; j++){
            int sum = 0;
            boolean[] visited = new boolean[groupNum];
            for(int i=0; i<n; i++){
                if (!visited[groups[i][j]]){
                    visited[groups[i][j]] = true;
                    sum += oilCount[groups[i][j]];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}