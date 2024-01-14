import java.util.*;

class Solution {
    
    class Task implements Comparable<Task>{
        int start;
        int time;
        
        public Task(int start, int time){
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Task t){
            return this.time - t.time;
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Task> q = new PriorityQueue<>();
        int i = 0, sum = 0, cur = jobs[0][0];
        
        while(true){
            while(i < jobs.length && jobs[i][0] <= cur){
                q.add(new Task(jobs[i][0], jobs[i][1]));
                i++;
            }
            
            if (!q.isEmpty()){
                Task t = q.poll();
                sum += (cur - t.start + t.time);
                cur += t.time;
            }
            else if (i < jobs.length)
                cur = jobs[i][0];
                
            if (i>=jobs.length && q.isEmpty())
                break;
        }
        
        return sum/jobs.length;
    }
}