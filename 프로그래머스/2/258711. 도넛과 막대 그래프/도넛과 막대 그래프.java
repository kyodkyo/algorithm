import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int ver = 0;
        for(int i=0; i<edges.length; i++){
            ver = Math.max(ver, Math.max(edges[i][0], edges[i][1]));
        }
        
        int[] input = new int[ver+1];
        int[] output = new int[ver+1];
        for(int i=0; i<edges.length; i++){
            output[edges[i][0]]++;
            input[edges[i][1]]++;
        }
        
        return checkVer(ver, input, output);
    }
        
    public static int[] checkVer(int ver, int[] input, int[] output){
        int[] answer = new int[4];
        
        for(int i=1; i<=ver; i++){
            if (input[i]==0 && output[i] >= 2)
                answer[0] = i;
            else if (input[i] != 0 && output[i] == 0)
                answer[2]++;
            else if (input[i] >=2 && output[i] >= 2)
                answer[3]++;
            
        }
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}