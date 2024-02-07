import java.util.*;


class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    static String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN");
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public static void dfs(int n, String curr, String path){
        if (n == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if (!visited[i] && curr.equals(tickets[i][0])){
                visited[i] = true;
                dfs(n+1, tickets[i][1], path+" "+tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}