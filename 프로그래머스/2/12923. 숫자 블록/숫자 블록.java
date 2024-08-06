import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(long begin, long end) {
        int start = (int) begin;
        int last = (int) end;
        int[] answer = new int[last - start + 1];
        
        for(int i=start; i<=last; i++)
            answer[i-start] = getValue(i);
        
        return answer;
    }
    
    public static int getValue(int x){
        if (x==1)
            return 0;
        
        List<Integer> list = new ArrayList<>();
        for(int div=2; div<=Math.sqrt(x); div++){
            if (x%div == 0){
                list.add(div);
                
                if (x/div <= 10000000)
                    return x/div;
            }
        }
        
        if (!list.isEmpty())
            return list.get(list.size()-1);
        
        return 1;
    }
}