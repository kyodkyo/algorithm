class Solution {
    public int solution(int n, int[][] results) {
        int[][] map = new int[n][n];
        
        for(int i=0; i<results.length; i++){
            int win = results[i][0]-1;
            int lose = results[i][1]-1;
            map[win][lose] = 1;
            map[lose][win] = -1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if (map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                        map[j][i] = -1;
                    }
                    if (map[i][k] == -1 && map[k][j] == -1){
                        map[i][j] = -1;
                        map[j][i] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int[] row : map){
            int count = 0;
            for(int res : row){
                if (res != 0)
                    count++;
            }
            if (count == n-1)
                answer++;
        }
        return answer;
    }
}