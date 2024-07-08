import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0, idx = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<=order.length; i++){
            stack.push(i);

            while (!stack.isEmpty()){
                if (stack.peek() != order[idx])
                    break;
                stack.pop();
                idx++;
                answer++;
            }
        }
        return answer;
    }
}