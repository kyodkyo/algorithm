import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int K, N;
    static long max=0;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        System.out.println(binary( ));
    }
    
    public static long binary(){
        long low = 0;
        long high = max + 1;
        
        while (low < high){
            long mid = (low + high) / 2;
            
            long count = 0;
            for(int len : arr)
                count += (len / mid);
            
            if (count >= N)
                low = mid + 1;
            else 
                high = mid;
        }
        
        return low - 1;
    }
}