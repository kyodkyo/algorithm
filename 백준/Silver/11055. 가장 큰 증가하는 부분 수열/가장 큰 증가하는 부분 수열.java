import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = Arrays.copyOf(arr, arr.length);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}