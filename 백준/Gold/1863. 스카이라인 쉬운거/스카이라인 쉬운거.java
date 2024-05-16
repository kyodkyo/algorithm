import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            list.add(Integer.parseInt(line[1]));
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int count = 0;
        for(int i=0; i<n; i++){
            int h = list.get(i);
            while (!stack.isEmpty() && stack.peek() > h){
                stack.pop();
                count++;
            }

            if (!stack.isEmpty() && stack.peek() == h)
                continue;

            stack.push(h);
        }

        while (!stack.isEmpty()){
            if (stack.peek() > 0)
                count++;
            stack.pop();
        }
        
        System.out.println(count);
    }

}