import java.util.*;

class Solution {
    static class Task{
        String name;
        int start;
        int taken;

        public Task(String name, int start, int taken){
            this.name = name;
            this.start = start;
            this.taken = taken;
        }
    }

    static ArrayList<Task> list = new ArrayList<>();
    static ArrayList<String> answer = new ArrayList<>();
    static Stack<Task> stack = new Stack<>();

    public String[] solution(String[][] plans) {
        int n = plans.length;

        for(int i=0; i<n; i++){
            String[] temp = plans[i][1].split(":");
            int mm = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            list.add(new Task(plans[i][0], mm, Integer.parseInt(plans[i][2])));
        }
        list.sort((o1, o2) -> o1.start - o2.start);

        checkOrder(n);

        return answer.toArray(new String[0]);
    }

    public static void checkOrder(int n){
        int i = 0;
        int cur = list.get(0).start;

        while (true){
            Task task = list.get(i);

            if (i==n-1){
                answer.add(task.name);
                while (!stack.isEmpty())
                    answer.add(stack.pop().name);

                break;
            }
            
            if (task.start + task.taken <= list.get(i+1).start) {
                answer.add(task.name);
                cur += task.taken;

                while (!stack.isEmpty()){
                    Task tmp = stack.pop();
                    
                    if (cur + tmp.taken <= list.get(i+1).start){
                        answer.add(tmp.name);
                        cur += tmp.taken;
                    }
                    else {
                        tmp.taken -= (list.get(i+1).start - cur);
                        cur = list.get(i+1).start;
                        stack.add(tmp);
                        break;
                    }
                }
            }
            else {
                task.taken -= (list.get(i+1).start - task.start);
                cur = list.get(i+1).start;
                stack.add(new Task(task.name, task.start, task.taken));
            }
            i++;
        }
    }
}
