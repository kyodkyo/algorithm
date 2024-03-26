import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n];

            String[] input = br.readLine().split(" ");
            for(int i=0; i<n; i++)
                price[i] = Integer.parseInt(input[i]);

            long answer = 0;
            int maxMoney = price[n-1];
            for(int i=n-2; i>=0; i--){
                if (maxMoney < price[i])
                    maxMoney = price[i];
                else
                    answer += (maxMoney - price[i]);
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}