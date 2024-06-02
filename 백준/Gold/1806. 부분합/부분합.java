import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int[] arr = new int[n+1];
        String[] line = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(line[i]);

        int i = 0, j = 0, sum = 0, len = Integer.MAX_VALUE;
        while(i <= j && j <= n){
            if (sum < s){
                sum += arr[j];
                j++;
            }
            else {
                len = Math.min(len, j - i);
                sum -= arr[i];
                i++;
            }
        }

        System.out.println(len== Integer.MAX_VALUE? 0 : len);
    }
}