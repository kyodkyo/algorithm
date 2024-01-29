import java.util.*;

class Solution {
    public String solution(String num, int k) {
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        int end = num.length() - (num.length() - k);

        while(end < num.length()){
            int max = start;
            for(int i=start; i<=end; i++){
                if (num.charAt(i) > num.charAt(max))
                    max = i;
            }
            sb.append(num.charAt(max));
            
            start = max+1;
            end += 1;
        }
        
        return sb.toString();
    }
}