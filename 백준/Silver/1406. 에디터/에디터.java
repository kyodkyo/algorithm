import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        for(String s : br.readLine().split(""))
            left.push(s);

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            if (input[0].equals("P"))
                left.push(input[1]);
            else if (input[0].equals("L") && !left.isEmpty())
                right.push(left.pop());
            else if (input[0].equals("D") && !right.isEmpty())
                left.push(right.pop());
            else if (input[0].equals("B") && !left.isEmpty())
                left.pop();
        }

        while(!left.isEmpty())
            right.push(left.pop());

        while(!right.isEmpty())
            sb.append(right.pop());
        System.out.println(sb);
    }
}