import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int F, S, G, up, down;
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        up = Integer.parseInt(input[3]);
        down = Integer.parseInt(input[4]);
        building = new int[F+1];

        String result = bfs();
        if (S==G)
            System.out.println(0);
        else
            System.out.println(result);
    }

    public static String bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        building[S] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            if (now == G)
                return String.valueOf(building[now] - 1);

            if (now + up <= F && building[now + up] == 0) {
                building[now + up] = building[now] + 1;
                q.add(now + up);
            }

            if (now - down >= 1 && building[now - down] == 0) {
                building[now - down] = building[now] + 1;
                q.add(now - down);
            }
        }
        return "use the stairs";
    }
}