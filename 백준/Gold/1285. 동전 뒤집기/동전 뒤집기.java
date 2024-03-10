import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, min;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++)
                board[i][j] = line.charAt(j);
        }

        min = n*n;
        recur(0, 0);
        System.out.println(min);
    }

    public static void recur(int col, int depth){
        if (depth == n){
            min = Math.min(min, checkT(board));
            return;
        }

        recur(col+1, depth+1);

        for(int i=0; i<n; i++){
            if (board[i][col] == 'H')
                board[i][col] = 'T';
            else
                board[i][col] = 'H';
        }
        recur(col+1, depth+1);
        for(int i=0; i<n; i++){
            if (board[i][col] == 'H')
                board[i][col] = 'T';
            else
                board[i][col] = 'H';
        }
    }

    public static int checkT(char[][] board){
        int result = 0;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++)
               if (board[i][j] == 'T')
                   count++;
            result += (count < n-count? count : n-count);
        }
        return result;
    }
}