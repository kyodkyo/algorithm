import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static long[] distance;
    static long[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int j = 0;
        distance = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens())
            distance[j++] = Integer.parseInt(st.nextToken());

        j = 0;
        price = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens())
            price[j++] = Integer.parseInt(st.nextToken());

        long money = 0;
        long minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++){
            if (minPrice > price[i])
                minPrice = price[i];
            money += (long) distance[i] * minPrice;
        }
        System.out.println(money);
    }

}