import java.io.*;
import java.util.Arrays;

public class Main{
    static int n, min[][], max[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        min =  new int[n][n];
        max = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }

        char[] input = br.readLine().toCharArray();
        for(int i=0; i<n; i+=2){
            min[i][i] = input[i] - '0';
            max[i][i] = input[i] - '0';
        }

        for(int j=2; j<n; j+=2){
            for(int i=0; i<n-j; i+=2){
                for(int k=2; k<=j; k+=2){
                    char op = input[i+k-1];
                    int[] tmp = new int[4];

                    tmp[0] = calc(max[i][i+k-2], max[i+k][i+j], op);
                    tmp[1] = calc(min[i][i+k-2], max[i+k][i+j], op);
                    tmp[2] = calc(max[i][i+k-2], min[i+k][i+j], op);
                    tmp[3] = calc(min[i][i+k-2], min[i+k][i+j], op);
                    Arrays.sort(tmp);
                    max[i][i+j] = Math.max(max[i][i+j], tmp[3]);
                    min[i][i+j] = Math.min(min[i][i+j], tmp[0]);
                }
            }
        }

        bw.write(String.valueOf(max[0][n-1]));
        bw.close();
        br.close();
    }

    public static int calc(int n1, int n2, char op){
        int res = 0;

        switch (op){
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
        }
        return res;
    }
}