import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] levels = new int[n];
        for(int i=0; i<n; i++)
            levels[i] = Integer.parseInt(br.readLine());
        Arrays.sort(levels);

        int sum = 0;
        int cut = (int) Math.round(n * 0.15);
        for(int i=cut; i<n-cut; i++)
            sum += levels[i];

        System.out.println(Math.round((float)sum/(n-2*cut)));
    }
}