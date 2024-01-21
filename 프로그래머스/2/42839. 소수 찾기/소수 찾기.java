import java.util.*;

class Solution {
    
    static String s;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        s = numbers;
        visited = new boolean[s.length()];
        dfs(0, "");
        
        int answer = 0;
        for(int n : set){
            if (isPrime(n))
                answer++;
        }
            
        return answer;
    }
    
    public static void dfs(int i, String str){
        if (i == s.length())
            return;
        
        for(int j=0; j<s.length(); j++){
            if (visited[j])
                continue;
            visited[j] = true;
            set.add(Integer.valueOf(str + s.charAt(j)));
            dfs(i+1, str + s.charAt(j));
            visited[j] = false;
        }
    }
    
    public static boolean isPrime(int num){
        if (num < 2)
            return false;
        
        for(int i=2; i<=(int) Math.sqrt(num); i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }
}