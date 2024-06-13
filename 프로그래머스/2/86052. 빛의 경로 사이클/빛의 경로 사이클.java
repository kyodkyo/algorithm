import java.util.*;

class Solution {
    static int x , y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][][] visited;
    
    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();    
        x = grid.length;
        y = grid[0].length();
        visited = new boolean[x][y][4];
        
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                for(int d=0; d<4; d++){
                    if (!visited[i][j][d])
                        answer.add(move(grid, i, j, d));
                }
            }
        }
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
    
    public static int move(String[] grid, int i, int j, int d){
        int count = 0;
        
        while(true){
            if (visited[i][j][d])
                break;
            
            count++;
            visited[i][j][d] = true;
            
            if (grid[i].charAt(j) == 'L')
                d = (d + 3) % 4;
            else if (grid[i].charAt(j) == 'R')
                d = (d + 1) % 4;
            
            i = (i + dx[d] + x) % x;
            j = (j + dy[d] + y) % y;
        }
        
        return count;
    }
}