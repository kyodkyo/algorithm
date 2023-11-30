import java.util.LinkedList;
import java.util.Queue;



class Solution {
    
    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] visited;
    static int n;
    static int m;
    static int[] oilGroup;
    static int groupNum;

    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        visited = new int[n][m];
        oilGroup = new int[n * m + 1];
        groupNum = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && land[i][j] == 1) {
                    visited[i][j] = groupNum;
                    Queue<Position> q = new LinkedList<>();
                    q.add(new Position(i, j));
                    bfs(q, land);
                    q.clear();
                }
            }
        }

        return findMax(answer);
    }

    public static void bfs(Queue<Position> q, int[][] land) {
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 1;

        while (!q.isEmpty()) {
            Position position = q.poll();
            for (int i = 0; i < move.length; i++) {
                int x = position.x + move[i][0];
                int y = position.y + move[i][1];

                if ((0 <= x && x < n) && (0 <= y && y < m) && land[x][y] == 1 && visited[x][y] == 0) {
                    visited[x][y] = groupNum;
                    q.add(new Position(x, y));
                    count += 1;
                }
            }
        }
        oilGroup[groupNum] = count;
        groupNum++;
    }

    public static int findMax(int answer){
        for(int i=0; i<m; i++){
            int sum = 0;
            boolean[] check = new boolean[groupNum+1];
            for(int j=0; j<n; j++){
                if (!check[visited[j][i]]){
                    check[visited[j][i]] = true;
                    sum += oilGroup[visited[j][i]];
                }
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

}