import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int l = Integer.parseInt(input[2]);
        int k = Integer.parseInt(input[3]);
        
        int count, answer = 0;
        int[][] star = new int[k][2];
        for(int i=0; i<k; i++){
            String[] line = br.readLine().split(" ");
            star[i][0] = Integer.parseInt(line[0]);
            star[i][1] = Integer.parseInt(line[1]);
        }
        
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                int x = star[i][0];
                int y = star[j][1];
                
                count = 0;
                for(int[] dot : star){
                    if (x<=dot[0] && x + l >= dot[0] && y<=dot[1] && y + l >= dot[1])
                        count++;
                }
                answer = Math.max(answer, count);
            }
        }
        System.out.println(k - answer);
    }
}