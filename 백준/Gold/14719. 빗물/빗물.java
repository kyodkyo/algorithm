import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, m;
    static int[][] blocks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        blocks = new int[n][m];

        String[] line = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            int h = Integer.parseInt(line[i]);
            for(int j=n-1; j>=n-h; j--)
                blocks[j][i] = 1;
        }

        int sum = 0;

        int row = 0;
        while(row < n){
            int left = 0;
            int right = m-1;

            while (left < m && blocks[row][left] != 1) 
                left++;
            while (-1 < right && blocks[row][right] != 1) 
                right--;

            if (left < right){
                for(int i=left; i<=right; i++){
                    if (blocks[row][i] == 0)
                        sum++;
                }
            }
            row++;
        }
        System.out.println(sum);
    }
}