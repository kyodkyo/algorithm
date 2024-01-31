import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> (o1[1] - o2[1]));
        
        int count = 1;
        int curr = routes[0][1];
        for(int[] out : routes){
            if (curr < out[0]){
                curr = out[1];
                count++;
            }
        }
        return count;
    }
}
