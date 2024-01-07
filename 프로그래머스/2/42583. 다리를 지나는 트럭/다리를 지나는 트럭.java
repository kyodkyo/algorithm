import java.util.*;

class Solution {
    public int solution(int length, int weights, int[] trucks) {
        Queue<Integer> q = new LinkedList<>();
        
        int i=0, time=0, currWeight=0, currLength=0;
        
        while(true){
            time++;
            
            if (q.isEmpty()){
                q.add(trucks[i]);
                currWeight += trucks[i];
                currLength++;
                i++;
            }
            else {
                if (currLength == length){
                    currWeight -= q.poll();
                    currLength--;
                }
                
                if (i==trucks.length || currWeight + trucks[i] > weights){
                    q.add(0);
                    currLength++;
                } 
                else {
                    q.add(trucks[i]);
                    currWeight += trucks[i];
                    currLength++;
                    i++;
                }
            }
            
            if (i==trucks.length && currWeight==0)
                break;
        }
        
        return time;
    }
}