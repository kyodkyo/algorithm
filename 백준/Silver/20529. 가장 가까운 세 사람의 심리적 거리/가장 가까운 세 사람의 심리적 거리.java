import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n;
    static String[] mbti;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            mbti = br.readLine().split(" ");
            if (n > 32){
                sb.append('0' + "\n");
                continue;
            }

            int[][] board = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (i==j)
                        board[i][j] = 0;
                    else
                        board[i][j] = checkDiffer(mbti[i], mbti[j]);
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    for(int k=j+1; k<n; k++){
                        int sum = board[i][j] + board[i][k] + board[j][k];
                        min = Math.min(min, sum);
                    }
                }
            }
            sb.append(min + "\n");
        }
        System.out.println(sb);
    }

    public static int checkDiffer(String s1, String s2){
        int count = 0;

        if(s1.equals(s2))
            return 0;

        for(int k=0; k<4; k++){
            if (s1.charAt(k) != s2.charAt(k))
                count++;
        }

        return count;
    }
}