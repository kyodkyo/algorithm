import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(line[i]);

        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;
        int left = 0, right = n-1;

        while (left < right){
            int ln = arr[left];
            int rn = arr[right];
            int sum = ln + rn;

            if (Math.abs(sum) < diff){
                diff = Math.abs(sum);
                result[0] = ln;
                result[1] = rn;
            }

            if (sum == 0){
                result[0] = ln;
                result[1] = rn;
                break;
            }

            if (sum > 0)
                right--;
            else if (sum < 0)
                left++;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
