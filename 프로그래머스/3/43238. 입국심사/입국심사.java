import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0;
        long right = (long)times[times.length-1] * n;
        long ans = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long count = 0; 
            
            for (int time : times) 
                count += (mid / time);

            if (count < n) 
                left = mid + 1;
            else { 
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
        }
        return ans;
    }
}