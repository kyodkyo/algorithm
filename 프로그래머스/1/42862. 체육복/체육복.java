import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(lost);
        
        for(int num : reserve)
            q.add(num);
        
        for(int i=0; i<lost.length; i++){
            if (q.contains(lost[i])){
                q.remove(lost[i]);
                lost[i] = -1;
                answer++;
            }
        }
        
        for(int i=0; i<lost.length; i++){
            if (q.contains(lost[i]-1)){
                q.remove(lost[i]-1);
                answer++;
            }
            else if (q.contains(lost[i]+1)){
                q.remove(lost[i]+1);
                answer++;
            }
        }
        return answer;
    }
}