class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num=1, x=-1, y=0;
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if (i%3 == 0)
                    ++x;
                else if (i%3 == 1)
                    ++y;
                else if (i%3 == 2){
                    --x;
                    --y;
                }
                arr[x][y] = num++;
            }
        }
        
        int idx = 0;
        int[] answer = new int[n*(n+1)/2];
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++)
                answer[idx++] = arr[i][j];
        }
        
        return answer;
    }
}