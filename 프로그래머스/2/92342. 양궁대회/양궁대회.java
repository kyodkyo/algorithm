import java.util.*;

class Solution {
    static int N, maxMinus;
    static int[] arr;
    static int[] answer = {-1};
    public int[] solution(int n, int[] info) {
        N = n;
        maxMinus = -1;
        arr = new int[11];
        dfs(info, 0, 0);

        return answer;
    }
    
    private static void dfs(int[] apeach, int idx, int cnt) {
        if(idx == 11) { 
            if(cnt == N) {
                int apScore = 0, liScore = 0;
                for(int i = 0; i<11; i++) {
                    if(apeach[i] == 0 && arr[i] == 0) 
                        continue;
                    if(apeach[i]>=arr[i]) 
                        apScore += 10-i;
                    else 
                        liScore += 10-i;
                }
                
                if(liScore>apScore) {
                    if(liScore-apScore > maxMinus) {
                        maxMinus = liScore-apScore;
                        answer = arr.clone();
                    }
                    
                    else if(liScore-apScore == maxMinus) {
                        for(int i = 10; i>=0; i--) {
                            if(answer[i]<arr[i]) {
                                answer = arr.clone();
                                return;
                            }
                            else if(answer[i]>arr[i]) 
                                return;
                        }
                    }
                }
            }
            return;
        }
        
        if(apeach[idx] == 0) 
            dfs(apeach, idx+1, cnt);
        
        if(cnt+1+apeach[idx] <= N) { 
            arr[idx] = apeach[idx]+1;
            dfs(apeach, idx+1, cnt+1+apeach[idx]);
            arr[idx] = 0;
        }
        
        if(apeach[idx] != 0) {
            for(int i = 0; i<=apeach[idx]; i++) {
                arr[idx] = i;
                dfs(apeach, idx+1, cnt+i);
                arr[idx] = 0;
            }
        }
        
    }
}
