import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static String op[] = {" ", "+", "-"};
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            dfs(1, "1"); 
            sb.append("\n");
        }  
        
        System.out.println(sb);    
	}
    
    public static void dfs(int depth, String s){
        if (depth == n){
            isZero(s);
            return;
        }
        
        for (int i=0; i<3; i++)
            dfs(depth+1, s + op[i] + Integer.toString(depth+1));

    }
    
    public static void isZero(String str){
        String s = str.replaceAll(" ", "");
        StringTokenizer st = new StringTokenizer(s, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            
            if (tmp.equals("+"))
                sum += Integer.parseInt(st.nextToken());
            else if (tmp.equals("-"))
                sum -= Integer.parseInt(st.nextToken());
        }
        
        if (sum == 0)
            sb.append(str + "\n");
    }
}
