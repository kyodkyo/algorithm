import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N, L, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        map = new int[N][N];

        for(int i = 0; i<N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j<N; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }

        int count = 0;
        for(int i = 0; i<N; i++){
            if (isPossible(i, 0, true)) //행
                count++;
            if (isPossible(0, i, false))
                count++;
        }
        System.out.println(count);
    }

    public static boolean isPossible(int x, int y, boolean row){
        int[] height = new int[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i<N; i++){
            if (row)
                height[i] = map[x][i];
            else
                height[i] = map[i][y];
        }

        for(int i = 0; i<N -1; i++){
            int hdiff = height[i] - height[i+1];

            if (hdiff == 0)
                continue;
            else if (hdiff == 1){
                for(int j=i+1; j<=i+L; j++){
                    if (j>=N || height[i+1] != height[j] || visited[j])
                        return false;
                    visited[j] = true;
                }
            }
            else if (hdiff == -1){
                for(int j=i; j>i-L; j--){
                    if (j<0 || height[i] != height[j] || visited[j])
                        return false;
                    visited[j] = true;
                }
            }
            else
                return false;
        }
        return true;
    }
}
