import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] height = new int[n+1];
        int[] count = new int[n+1];
        int[] near = new int[n+1];
        Arrays.fill(near, -100000);
        
        String[] input = br.readLine().split(" ");
        for(int i=1; i<=n; i++)
            height[i] = Integer.parseInt(input[i-1]);
        
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=n; i++){
            while (!stack.isEmpty() && height[stack.peek()] <= height[i])
                stack.pop();
            
            count[i] = stack.size();
            if (count[i] > 0)
                near[i] = stack.peek();
            stack.push(i);
        }
        
        stack = new Stack<>();
        for(int i=n; i>=0; i--){
            while (!stack.isEmpty() && height[stack.peek()] <= height[i])
                stack.pop();
            
            int s = stack.size();
            count[i] += s;
            if (s > 0 && stack.peek()-i < i-near[i])
                near[i] = stack.peek();
            stack.push(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++){
            sb.append(count[i]);
            if (count[i] > 0)
                sb.append(" ").append(near[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}