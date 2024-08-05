import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for(int i=0; i< book_time.length; i++){
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));

            end += 10;
            if (end % 100 >= 60)
                end += 40;

            times[i][0] = start;
            times[i][1] = end;
        }
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for(int[] time : times){
            if (q.isEmpty())
                q.add(time);
            else {
                int[] tmp = q.peek();

                if (time[0] >= tmp[1])
                    q.poll();
                q.add(time);
            }
        }
        return q.size();
    }
}