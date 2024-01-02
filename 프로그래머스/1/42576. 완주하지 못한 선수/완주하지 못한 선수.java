import java.util.Arrays;

class Solution {
    public String solution(String[] par, String[] com) {
        String answer = "";
        
        Arrays.sort(com);
        Arrays.sort(par);
        
        int j=0;
        for(int i=0; i<par.length; i++){
            if (j>=com.length || !par[i].equals(com[j]))
                return par[i];
            else
                j++;                
        }
        return answer;
    }
}