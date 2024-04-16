import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int sum = picks[0] + picks[1] + picks[2];
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<minerals.length; i+=5){
            if (sum == 0)
                break;

            int[] pick = new int[3];
            for(int j=i; j<i+5; j++){
                if (j== minerals.length)
                    break;

                if (minerals[j].equals("diamond")){
                    pick[0] += 1;
                    pick[1] += 5;
                    pick[2] += 25;
                }
                else if (minerals[j].equals("iron")){
                    pick[0] += 1;
                    pick[1] += 1;
                    pick[2] += 5;
                }
                else {
                    pick[0] += 1;
                    pick[1] += 1;
                    pick[2] += 1;
                }
            }
            sum--;
            list.add(pick);
        }

        Collections.sort(list, (o1, o2) -> o2[2] - o1[2]);

        int answer = 0;
        for(int[] arr : list){
            if (picks[0] > 0) {
                answer += arr[0];
                picks[0]--;
            }
            else if (picks[1] > 0) {
                answer += arr[1];
                picks[1]--;
            }
            else {
                answer += arr[2];
                picks[2]--;
            }
        }
        return answer;
    }
}