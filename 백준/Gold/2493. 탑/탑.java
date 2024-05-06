import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, tops[], dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tops = new int[n+1];
        dp = new int[n+1];

        String[] input = br.readLine().split(" ");
        for(int i=1; i<=n; i++)
            tops[i] = Integer.parseInt(input[i-1]);

        for(int i=2; i<=n; i++){
            if (tops[i-1] >= tops[i])
                dp[i] = i-1;
            else
                dp[i] = find(i-1, tops[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++)
            sb.append(dp[i] + " ");
        System.out.println(sb);
    }

    public static int find(int i, int cur){
        if (tops[dp[i]] >= cur || i <= 1)
            return dp[i];
        else
            return find(dp[i], cur);
    }
}