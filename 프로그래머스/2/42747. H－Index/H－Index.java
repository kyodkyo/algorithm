import java.util.*;

class Solution {
    public int solution(int[] citas) {
        Arrays.sort(citas);
        
        for(int h=citas.length; h>0; h--){
            int up = 0;
            for(int i=0; i<citas.length; i++){
                if (citas[i] >= h)
                    up++;
            }
            
            if (up >= h)
                return h;
        }        
        return 0;
    }
}