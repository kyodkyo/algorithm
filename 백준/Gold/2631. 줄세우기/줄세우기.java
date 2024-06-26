import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] kids = new int[N];
        for(int i=0; i<N; i++)
            kids[i] = Integer.parseInt(br.readLine());

        int answer = 0;
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++){
                if (kids[j] < kids[i] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(N-answer);
    }
}