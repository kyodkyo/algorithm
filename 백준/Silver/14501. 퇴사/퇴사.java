import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int[] times = new int[days];
        int[] prices = new int[days];

        for(int i=0; i<days; i++){
            String[] line = br.readLine().split(" ");
            times[i] = Integer.parseInt(line[0]);
            prices[i] = Integer.parseInt(line[1]);
        }

        int[] dp = new int[days + 1];
        for(int i=0; i<days; i++){
            if (i + times[i] <= days)
                dp[i+times[i]] = Math.max(dp[i+times[i]], dp[i] + prices[i]);
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[days]);
    }
}