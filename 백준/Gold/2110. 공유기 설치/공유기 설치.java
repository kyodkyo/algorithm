import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] house = new int[n];
        for(int i=0; i<n; i++)
            house[i] = Integer.parseInt(br.readLine());
        Arrays.sort(house);

        int l = 1, r = house[n-1];
        while (l <= r){
            int mid = (l + r) / 2;

            int pos = 0, count = 1;
            for(int i=0; i<n; i++){
                if (house[i] - house[pos] >= mid){
                    count++;
                    pos = i;
                }
            }

            if (count < c)
                r = mid - 1;
            else
                l = mid + 1;
        }
        System.out.println(l-1);
    }
}