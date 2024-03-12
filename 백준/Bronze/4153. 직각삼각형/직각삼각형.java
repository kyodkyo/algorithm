import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        while(!input[0].equals("0")){
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a*a+b*b==c*c || a*a+c*c==b*b || c*c+b*b==a*a)
                sb.append("right\n");
            else
                sb.append("wrong\n");

            input = br.readLine().split(" ");
        }
        System.out.println(sb);
    }
}