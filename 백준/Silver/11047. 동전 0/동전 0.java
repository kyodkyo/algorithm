import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int money = Integer.parseInt(line[1]);

        int[] values = new int[n];
        for(int i=n-1; i>=0; i--)
            values[i] = Integer.parseInt(br.readLine());

        int count = 0;
        while(true){
            if (money == 0)
                break;

            for(int k : values){
                if (k <= money){
                    money -= k;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}