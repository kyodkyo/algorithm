import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int[][] wheels = new int[4][8];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        for(int i=0; i<4; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<8; j++)
                wheels[i][j] = Integer.parseInt(line[j]);
        }

        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]) - 1;
            int dir = Integer.parseInt(input[1]);

            rotateAll(num, dir);
        }

        int score = 0;
        for(int i=0; i<4; i++){
            if (wheels[i][0] == 1)
                score += Math.pow(2, i);
        }
        System.out.println(score);
    }

    public static void rotateAll(int num, int dir){
        leftWheel(num-1, -dir);
        rightWheel(num+1, -dir);
        rotate(num, dir);
    }

    public static void leftWheel(int num, int dir){
        if (num < 0)
            return;
        if (wheels[num][2] == wheels[num+1][6])
            return;
        leftWheel(num-1, -dir);
        rotate(num, dir);
    }

    public static void rightWheel(int num, int dir){
        if (num > 3)
            return;
        if (wheels[num][6] == wheels[num-1][2])
            return;
        rightWheel(num+1, -dir);
        rotate(num, dir);
    }

    public static void rotate(int num, int dir){
        if (dir == 1){
            int tmp = wheels[num][7];
            for(int i=7; i>0; i--)
                wheels[num][i] = wheels[num][i-1];
            wheels[num][0] = tmp;
        }
        else {
            int tmp = wheels[num][0];
            for(int i=0; i<7; i++)
                wheels[num][i] = wheels[num][i+1];
            wheels[num][7] = tmp;
        }
    }
}