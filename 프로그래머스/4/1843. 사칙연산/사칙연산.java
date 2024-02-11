class Solution {
    static int[] num;
    static char[] op;
    static int n;
    
    public int solution(String arr[]) {
        n = arr.length/2;
        num = new int[n+1];
        op = new char[n];
        
        int idx1 = 0;
        int idx2 = 0;
        for(String s : arr){
            if (s.equals("+") || s.equals("-"))
                op[idx1++] = s.charAt(0);
            else
                num[idx2++] = Integer.parseInt(s);
        }
        return findMax();
    }
    
    public static int findMax(){
        int[][][] dp = new int[n+1][n+1][2];
        
        for(int i=0; i<n+1; i++)
            dp[i][i][0] = dp[i][i][1] = num[i];
        
        for(int len=1; len<n+1; len++){
            for(int start=0; start<n+1; start++){
                if (start + len >= n+1)
                    break;
                
                int end = start + len;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                for(int i=start; i<end; i++){
                    if (op[i] == '+'){
                        max = Math.max(max, dp[start][i][1] + dp[i+1][end][1]);
                        min = Math.min(min, dp[start][i][0] + dp[i+1][end][0]);
                    }
                    else{
                        max = Math.max(max, dp[start][i][1] - dp[i+1][end][0]);
                        min = Math.min(min, dp[start][i][0] - dp[i+1][end][1]);
                    }
                }
                
                dp[start][end][0] = min;
                dp[start][end][1] = max;
            }
        }
        return dp[0][n][1];
    }
}
