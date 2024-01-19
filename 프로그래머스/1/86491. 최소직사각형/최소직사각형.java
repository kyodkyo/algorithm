class Solution {
    public int solution(int[][] sizes) {
        int row=0, col=0;
        
        for(int i=0; i<sizes.length; i++){
            if (sizes[i][0] < sizes[i][1]){
                row = Math.max(row, sizes[i][1]);
                col = Math.max(col, sizes[i][0]);
            } else {
                row = Math.max(row, sizes[i][0]);
                col = Math.max(col, sizes[i][1]);
            }
        }
        
        return row*col;
    }
}