import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, count=0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth){
        if (depth==n){
            count++;
            return;
        }

        for(int row=0; row<n; row++){
            arr[depth] = row;
            if (checkMap(depth))
                nQueen(depth+1);
        }
    }

    public static boolean checkMap(int col){
        for(int i=0; i<col; i++)
            if (arr[i]==arr[col] || Math.abs(col-i)==Math.abs(arr[col]-arr[i]))
                return false;
        return true;
    }
}