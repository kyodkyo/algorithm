import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if (board[i][k]==1 && board[k][j]==1)
                        board[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] row : board){
            for(int t : row)
                sb.append(t + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}