import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s.toLowerCase(), " ", true);
        
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            if (word.length() == 0)
                sb.append(" ");
            else
                sb.append(String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1));
        }
        return sb.toString();
    }
}