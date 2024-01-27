import java.util.*;

class Solution {
    public int solution(String name) {
        int len = name.length();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            char c = name.charAt(i);
            list.add(Math.min(c-'A', 'Z'-c+1));
        }
        
        int move = len-1;
        for(int i=0; i<len; i++){
            int j = i+1;
            
            while(j<len && list.get(j)==0)
                j++;
            move = Math.min(move, Math.min(2*i + len - j, 2*(len-j) + i));
        }
        
        return list.stream().mapToInt(i->i).sum() + move;
    }
}