import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        String[] line = br.readLine().split(" ");
        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(line[i-1]);

        int left = 1, right = 1;
        int[] nums = new int[100001];
        long count = 0;

        while(left <= n){
            while (right <= n && nums[arr[right]] == 0){
                nums[arr[right]] = 1;
                right += 1;
            }

            count += (right - left);

            nums[arr[left]] -= 1;
            left += 1;
        }
        System.out.println(count);
    }
}

