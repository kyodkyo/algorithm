import java.util.*;

class Solution {
    static int sum = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                dfs(maps, visited, i, j);
                
                if (sum > 0){
                    list.add(sum);
                    sum = 0;
                }
            }
        }
        if (list.size() == 0)
            return new int[]{-1};
        
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public static void dfs(String[] maps, boolean[][] visited, int x, int y){
        if (!visited[x][y] && maps[x].charAt(y) != 'X'){
            visited[x][y] = true;
            sum += maps[x].charAt(y) - '0';
        }
        else
            return;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length())
                dfs(maps, visited, nx, ny);
        }
    }
    
}