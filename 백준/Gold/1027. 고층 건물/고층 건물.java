import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;

            double minNum = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (arr[j] - arr[i]) / (j - i);
                if (slope < minNum) {
                    count++;
                    minNum = (double) (arr[i] - arr[j]) / (i - j);
                }
            }

            double maxNum = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < n; j++) {
                double slope = (double) (arr[j] - arr[i]) / (j - i);
                if (maxNum < slope) {
                    count++;
                    maxNum = slope;
                }
            }
            
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
