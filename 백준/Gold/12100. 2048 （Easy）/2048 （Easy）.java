import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, result = 0;
    static int[][] input;
    static int[] arr = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        input = new int[n][n];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<n; j++)
                input[i][j] = Integer.parseInt(line[j]);
        }

        recur(0);
        System.out.println(result);
    }


    public static void recur(int depth) {
        if (depth == 5) {
            int[][] copy = copyBoard();

            for(int i=0; i<5; i++){
                if (arr[i]==0)
                    copy = up(copy);
                else if (arr[i]==1)
                    copy = down(copy);
                else if (arr[i]==2)
                    copy = right(copy);
                else
                    copy = left(copy);
            }
            findMax(copy);
            return;
        }

        for(int i=0; i<4; i++){
            arr[depth] = i;
            recur(depth + 1);
        }
    }
    
    public static int[][] copyBoard(){
        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copy[i][j]=input[i][j];
            }
        }
        return copy;
    }

    public static void findMax(int[][] board){
        int max = 0;
        for(int[] row : board){
            for(int val : row)
                max = Math.max(max, val);
        }
        result = Math.max(result, max);
    }

    public static int[][] up(int[][] board){
        for(int col=0; col<n; col++) {
            int now = 0;
            for (int i = 1; i < n; i++) {
                if (board[i][col] != 0) {
                    if (board[now][col] == 0){
                        board[now][col] = board[i][col];
                        board[i][col] = 0;
                    }
                    else{
                        if (board[now][col] == board[i][col]){
                            board[now][col] *= 2;
                            board[i][col] = 0;
                            now++;
                        }
                        else{
                            now++;
                            int temp = board[i][col];
                            board[i][col] = 0;
                            board[now][col] = temp;
                        }
                    }
                }
            }
        }
        return board;
    }

    public static int[][] down(int[][] board){
        for(int col=0; col<n; col++){
            int now = n-1;
            for(int i=n-2; i>=0; i--){
                if(board[i][col] != 0){
                    if (board[now][col]==0){
                        board[now][col] = board[i][col];
                        board[i][col] = 0;
                    }
                    else{
                        if (board[now][col]==board[i][col]){
                            board[now][col] *= 2;
                            board[i][col] = 0;
                            now--;
                        }
                        else{
                            now--;
                            int temp = board[i][col];
                            board[i][col] = 0;
                            board[now][col] = temp;
                        }
                    }
                }
            }
        }
        return board;
    }

    public static int[][] right(int[][] board){
        for(int row=0; row<n; row++){
            int now = n-1;
            for(int i=n-2; i>=0; i--){
                if (board[row][i] != 0){
                    if (board[row][now]==0){
                        board[row][now] = board[row][i];
                        board[row][i] = 0;
                    }
                    else{
                        if (board[row][now]==board[row][i]){
                            board[row][now] *= 2;
                            board[row][i] = 0;
                            now--;
                        }
                        else{
                            now--;
                            int temp = board[row][i];
                            board[row][i] = 0;
                            board[row][now] = temp;
                        }
                    }
                }
            }
        }
        return board;
    }

    public static int[][] left(int[][] board){
        for(int row=0; row<n; row++){
            int now = 0;
            for(int i=1; i<n; i++){
                if (board[row][i] != 0){
                    if (board[row][now]==0){
                        board[row][now] = board[row][i];
                        board[row][i] = 0;
                    }
                    else{
                        if (board[row][now]==board[row][i]){
                            board[row][now] *= 2;
                            board[row][i] = 0;
                            now++;
                        }
                        else{
                            now++;
                            int temp = board[row][i];
                            board[row][i] = 0;
                            board[row][now] = temp;
                        }
                    }
                }
            }
        }
        return board;
    }
}