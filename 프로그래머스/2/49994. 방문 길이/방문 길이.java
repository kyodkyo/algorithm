import java.util.*;

class Solution {
    public int solution(String dirs) {
        int cx = 0, cy = 0;
        HashSet<String> hashSet = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            int nx = cx;
            int ny = cy;
            String s = "";
            
            if (dirs.charAt(i) == 'U'){
                ny++;
                s += cx + "," + cy + "->" + nx + "," + ny;
            } else if (dirs.charAt(i) == 'D'){
                ny--;
                s += nx + "," + ny + "->" + cx + "," + cy;
            } else if (dirs.charAt(i) == 'R'){
                nx++;
                s += cx + "," + cy + "->" + nx + "," + ny;
            } else {
                nx--;
                s += nx + "," + ny + "->" + cx + "," + cy;
            } 
            
            if (nx < -5 || ny < -5 || nx > 5 || ny > 5)
                continue;
            hashSet.add(s);
            
            cx = nx;
            cy = ny;
        }
        
        return hashSet.size();
    }
}