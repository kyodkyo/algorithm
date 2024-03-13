import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int K, N;
    static long low, high;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        arr = new int[K];
        low = 1;
        high = 0;
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }

        System.out.println(binary());
    }

    public static long binary(){
        long mid = (low + high) / 2;

        while (low <= high){
            long count = 0;
            for(int len : arr)
                count += (len / mid);

            if (count >= N)
                low = mid + 1;
            else
                high = mid - 1;

            mid = (low + high) / 2;
        }
        return mid;
    }
}
