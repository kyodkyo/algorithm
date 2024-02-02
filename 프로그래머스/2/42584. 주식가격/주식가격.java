import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        int cur = 0;
        
        while(true){
            int count = 0;
            for(int i=cur+1; i<prices.length; i++){
                count++;
                if (prices[i] < prices[cur])
                    break;
            }
            q.add(count);
            cur++;
            
            if (cur == prices.length)
                break;
        }
        
        return q.stream().mapToInt(i->i).toArray();
    }
}