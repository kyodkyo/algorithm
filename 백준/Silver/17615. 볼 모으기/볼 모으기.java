import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, red=0, black=0;
    static char[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        for(int i=0; i<n; i++){
            if (input[i] == 'R')
                red++;
        }
        black = n - red;

        System.out.println(Math.min(findMin('R'), findMin('B')));
    }

    public static int findMin(char c){
        int result = Integer.MAX_VALUE;
        int count = c=='R'? red : black;

        int k=0;
        for(int i=0; i<n; i++){
            if (input[i] == c)
                k++;
            else
                break;
        }
        result = Math.min(result, count-k);

        k=0;
        for(int i=n-1; i>=0; i--){
            if (input[i] == c)
                k++;
            else
                break;
        }
        result = Math.min(result, count-k);

        return result;
    }
}