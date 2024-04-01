import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int end = targets[0][1];
        for(int i=0; i<targets.length; i++){
            if (targets[i][0] >= end){
                end = targets[i][1];
                count++;
            }
        }
        return count;
    }
}