import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, m, b;
    static int min = 256, max=0;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        b = Integer.parseInt(input[2]);

        map = new int[n][m];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(line[j]);
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        
        makeLand();
        System.out.println(sb);
    }

    public static void makeLand(){
        int[] result = {Integer.MAX_VALUE, 0}; // time, high
        for(int i=min; i<=max; i++){
            int block = b;
            int time = 0;

            for(int x=0; x<n; x++){
                for(int y=0; y<m; y++){
                    if (map[x][y] < i){
                        block -= (i - map[x][y]);
                        time += (i - map[x][y]);
                    }
                    else {
                        block += (map[x][y] - i);
                        time += ((map[x][y] - i) * 2);
                    }
                }
            }

            if (block>=0 && result[0]>=time){
                result[0] = time;
                result[1] = i;
            }
        }
        sb.append(result[0] + " " + result[1]);
    }
}