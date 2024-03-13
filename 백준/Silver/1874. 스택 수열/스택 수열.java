import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int cur = 1;
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());

            while(cur<=input){
                stack.push(cur);
                cur++;
                sb.append("+\n");
            }

            if (input == stack.peek()){
                stack.pop();
                sb.append("-\n");
            }
            else 
                flag = false;
        }

        if (flag)
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}