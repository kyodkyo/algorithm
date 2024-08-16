import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int play = 0;
        
        m = replaceCode(m);
        for(String music : musicinfos){
            String[] tmp = music.split(",");
            
            int time = calcTime(tmp[0], tmp[1]);
            String code = replaceCode(tmp[3]);
            
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<time; i++)
                sb.append(code.charAt(i % code.length()));                
            code = sb.toString();
            
            if (time >= m.length() && code.contains(m)){
                if (time > play){
                    play = time;
                    answer = tmp[2];
                }
            }
        }
        
        return answer;
    }
    
    public static String replaceCode(String s){
        return s.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a")
            .replaceAll("B#", "b");
    }
    
    public static int calcTime(String s1, String s2){
        int start = Integer.parseInt(s1.split(":")[0]) * 60 + Integer.parseInt(s1.split(":")[1]);
        int end = Integer.parseInt(s2.split(":")[0]) * 60 + Integer.parseInt(s2.split(":")[1]);
        return end - start;
    }
}