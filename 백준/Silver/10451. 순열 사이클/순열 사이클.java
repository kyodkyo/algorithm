import java.io.*;
import java.util.*;

public class Main{
    static int[] map;
    static boolean[] visited;
    static int cycle;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());
            map = new int[t+1];
            cycle = 0;
            
            st = new StringTokenizer(br.readLine());
            
            for(int j=1; j<=t; j++)
                map[j] = Integer.parseInt(st.nextToken());
                    
            visited = new boolean[t+1];
            for(int k=1; k<=t; k++){
                if (!visited[k]){
                    cycle++;
                    dfs(k);
                }
            }
            System.out.println(cycle);
        }
    }
    
    public static void dfs(int pos){
        visited[pos] = true;
        
        int next = map[pos];
        if (!visited[next])
            dfs(map[pos]);
    }
}