import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] board = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=n; j++)
                board[i][j] = board[i][j-1] + Integer.parseInt(input[j-1]);
        }

        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int sum = 0;
            for (int x = x1; x <= x2; x++)
                    sum += (board[x][y2] - board[x][y1-1]);
            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}