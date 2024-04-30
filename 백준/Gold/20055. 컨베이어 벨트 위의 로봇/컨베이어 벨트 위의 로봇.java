import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, k, step = 1;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        belt = new int[2*n + 1];
        robot = new boolean[n + 1];
        input = br.readLine().split(" ");
        for(int i=1; i<=2*n; i++)
            belt[i] = Integer.parseInt(input[i-1]);

        beltMove();
        System.out.println(step);
    }

    public static void beltMove() {
        while(true){
            // 1
            int last = belt[2*n];
            for(int i=2*n; i>1; i--)
                belt[i] = belt[i-1];
            belt[1] = last;

            for(int i=n; i>1; i--)
                robot[i] = robot[i-1];
            robot[1] = false;
            robot[n] = false;

            // 2
            for(int i=n-1; i>0; i--){
                if (robot[i] && !robot[i+1] && belt[i+1] >= 1){
                    robot[i] = false;
                    robot[i+1] = true;
                    belt[i+1]--;
                }
            }
            robot[n] = false;

            // 3
            if (belt[1] > 0) {
                robot[1] = true;
                belt[1]--;
            }

            // 4
            int count = 0;
            for(int i=1; i<=2*n; i++)
                if (belt[i] == 0)
                    count++;

            if (count >= k)
                break;

            step++;
        }
    }
}
