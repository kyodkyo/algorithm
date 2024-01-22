class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for(int i=3; i<=total/2; i++){
            if(total%i==0){ 
                int j = total/i;
                if ((i+j)*2 - 4 == brown)
                    return new int[]{Math.max(i, j), Math.min(i, j)};
            }
        }
        return new int[2];
    }
}