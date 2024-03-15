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
        for(int i=0; i<n-1; i++)
            distance[i] = Integer.parseInt(line[i]);

        price = new int[n];
        line = br.readLine().split(" ");
        for(int i=0; i<n; i++)
            price[i] = Integer.parseInt(line[i]);

        int money = distance[0] * price[0];
        System.out.println(minPrice(money));
    }

    public static int minPrice(int money){
        for(int i=1; i< distance.length; i++){
            if (price[i-1] >= price[i])
                money += (price[i] * distance[i]);
            else
                money += (price[i-1] * distance[i]);
        }
        return money;
    }
}