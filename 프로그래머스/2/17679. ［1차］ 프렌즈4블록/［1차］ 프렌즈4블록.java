class Solution {
    static char[][] blockMap;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        blockMap = new char[m][n];
        
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length(); col++)
                blockMap[row][col] = board[row].charAt(col);
        }
        
        while(true){
            boolean[][] isSame = new boolean[m][n];
            checkBlock(m, n, isSame);
            int count = countBlock(m, n, isSame);
            
            if (count==0)
                break;
            
            answer += count;
            dropBlock(m, n);
        }
        return answer;
    }
    
    public static void dropBlock(int m, int n){
        for (int row=m-1; row>=0; row--) {
            for (int col=0; col<n; col++) {
                if (blockMap[row][col] != '-') 
                    continue;
                
                if (blockMap[row][col] == '-') {
                    for (int k=row-1; k>=0; k--) { 
                        if (blockMap[k][col] != '-') {
                            blockMap[row][col] = blockMap[k][col];
                            blockMap[k][col] = '-';
                            break; 
                        }
                    }
                }
            }
        }
    }
    
    public static void checkBlock(int m, int n, boolean[][] isSame){
        for (int row=0; row<m-1; row++) {
            for (int col=0; col<n-1; col++) {
                char block = blockMap[row][col];
                
                if (blockMap[row+1][col]==block && blockMap[row][col+1]==block
                        && blockMap[row+1][col+1]==block) {
                    isSame[row+1][col] = true;
                    isSame[row][col+1] = true;
                    isSame[row+1][col+1] = true;
                    isSame[row][col] = true;
                }
            }
        }
    }
    
    public static int countBlock(int m, int n, boolean[][] isSame){
        int count = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (!isSame[i][j])
                    continue;
                
                if (blockMap[i][j] != '-'){
                    count++;
                    blockMap[i][j] = '-';
                }
            }
        }
        return count;
    }
}