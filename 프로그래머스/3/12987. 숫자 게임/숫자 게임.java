import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int ia = 0;
        int ib = 0;
        while (true){
            if (ib == B.length)
                break;
            
            if (A[ia] < B[ib]){
                answer++;
                ia++;
                ib++;
            }
            else{
                ib++;
            }     
        }
        
        return answer;
    }
}