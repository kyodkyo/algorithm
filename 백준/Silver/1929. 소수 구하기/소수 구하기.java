import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long m = Integer.parseInt(input[0]);
        long n = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        for(long i=m; i<=n; i++){
            if (isPrime(i))
                sb.append(i + "\n");
        }
        System.out.println(sb);
    }

    public static boolean isPrime(long n){
        if (n == 1)
            return false;
        for(long i=2; i*i<=n; i++){
            if (n%i == 0)
                return false;
        }
        return true;
    }
}