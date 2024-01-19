class Solution {
    public int solution(int[][] sizes) {
        int row=0, col=0;
        
        for(int i=0; i<sizes.length; i++){
            row = Math.max(row, Math.max(sizes[i][0], sizes[i][1]));
            col = Math.max(col, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return row*col;
    }
}