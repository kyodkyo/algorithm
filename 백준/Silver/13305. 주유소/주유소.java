import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[] distance;
    static int[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        distance = new int[n-1];
        String[] line = br.readLine().split(" ");
        for(int j=0; j<n-1; j++)
            distance[j] = Integer.parseInt(line[j]);

        price = new int[n];
        line = br.readLine().split(" ");
        for(int j=0; j<n; j++)
            price[j] = Integer.parseInt(line[j]);

        long money = 0;
        long minPrice = price[0];
        for(int i = 0; i < n-1; i++){
            minPrice = Math.min(minPrice, price[i]);
            money += distance[i] * minPrice;
        }
        System.out.println(money);
    }
}
