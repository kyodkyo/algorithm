import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i=0; i<days.length; i++){
            int temp = 100 - progresses[i];
            days[i] = temp%speeds[i]==0 ? temp/speeds[i] : temp/speeds[i] + 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        
        int prev = days[0];
        for(int i=1; i<days.length; i++){
            if (days[i] <= prev)
                count++;
            else{
                queue.add(count);
                count = 1;
                prev = days[i];
            }
        }
        queue.add(count);

        return queue.stream().mapToInt(i->i).toArray();
    }
}