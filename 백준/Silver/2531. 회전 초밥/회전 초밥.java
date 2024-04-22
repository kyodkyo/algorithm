import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, d, k, coupon;
    static int[] belts, sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        coupon = Integer.parseInt(input[3]);

        belts = new int[n];
        for(int i=0; i<n; i++)
            belts[i] = Integer.parseInt(br.readLine());

        sushi = new int[d+1];
        System.out.println(findMax());
    }

    public static int findMax(){
        int count = 0;
        for(int i=0; i<k; i++){
            int choice = belts[i];
            if (sushi[choice] == 0)
                count++;
            sushi[choice] += 1;
        }

        int max = count;
        for(int i=0; i<n; i++){
            if (count >= max){
                if (sushi[coupon] == 0)
                    max = count + 1;
                else
                    max = count;
            }

            int choice = belts[i];
            sushi[choice]--;
            if (sushi[choice] == 0)
                count--;

            if (sushi[belts[(i+k)%n]] == 0)
                count++;
            sushi[belts[(i+k)%n]]++;
        }
        return max;
    }
}