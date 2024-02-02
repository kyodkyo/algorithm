import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        for(String s :  operations){
            String[] temp = s.split(" ");

            if (temp[0].equals("I")){
                minQ.add(Integer.parseInt(temp[1]));
                maxQ.add(Integer.parseInt(temp[1]));
            }
            else if (!minQ.isEmpty() && temp[0].equals("D")) {
                if (temp[1].equals("1")){
                    minQ.remove(maxQ.poll());
                } else {
                    maxQ.remove(minQ.poll());
                }
            }
        }

        int[] answer = new int[2];
        if (minQ.size() > 0){
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
}
