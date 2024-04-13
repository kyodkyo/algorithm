import java.util.*;

class Solution {
    static class Subject{
        String name;
        int start;
        int taken;

        public Subject(String name, int start, int taken){
            this.name = name;
            this.start = start;
            this.taken = taken;
        }
    }

    public String[] solution(String[][] plans) {
        int n = plans.length;
        ArrayList<Subject> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] temp = plans[i][1].split(":");
            int mm = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            list.add(new Subject(plans[i][0], mm, Integer.parseInt(plans[i][2])));
        }
        list.sort((o1, o2) -> o1.start - o2.start);
        ArrayList<String> answer = new ArrayList<>();
        Stack<Subject> stack = new Stack<>();

        int i = 0;
        int cur = list.get(0).start;

        while (true){
            if (i==n-1){
                answer.add(list.get(i).name);
                while (!stack.isEmpty())
                        answer.add(stack.pop().name);

                break;
            }
            else if (list.get(i).start + list.get(i).taken < list.get(i+1).start) {
                answer.add(list.get(i).name);
                cur += list.get(i).taken;

                while (!stack.isEmpty()){
                    Subject tmp = stack.pop();
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

                i++;
            }
            else if (list.get(i).start + list.get(i).taken == list.get(i+1).start){
                answer.add(list.get(i).name);
                cur = list.get(i+1).start;
                i++;
            }
            else{
                list.get(i).taken -= (list.get(i+1).start - list.get(i).start);
                cur = list.get(i+1).start;
                stack.add(new Subject(list.get(i).name, list.get(i).start, list.get(i).taken));
                i++;
            }
        }

        return answer.toArray(new String[0]);
    }
}