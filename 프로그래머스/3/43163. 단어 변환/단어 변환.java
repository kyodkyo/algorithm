class Solution {
    static int n, answer=0;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words){
        n = begin.length();
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);        
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, int count){
        if (begin.equals(target)){
            answer = count;
            return;
        }
        
        for(int i=0; i<words.length; i++){
            if (!visited[i] && checkDiff(begin, words[i]) == n-1){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }
    
    public static int checkDiff(String s1, String s2){
        int count = 0;
        
        for(int i=0; i<n; i++){
            if (s1.charAt(i) == s2.charAt(i))
                count++;
        }
        
        return count;
    }
}