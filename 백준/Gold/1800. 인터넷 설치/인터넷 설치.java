import javax.swing.event.MenuDragMouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    static int n, p, k, answer = Integer.MAX_VALUE;
    static ArrayList<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        p = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<p; i++){
            String[] line = br.readLine().split(" ");
            int c1 = Integer.parseInt(line[0]);
            int c2 = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);

            list[c1].add(new int[]{c2, cost});
            list[c2].add(new int[]{c1, cost});
        }

        divide(0, 1000000);

        System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
    }

    public static void divide(int start, int end){
        while(start <= end){
            int mid = (start + end)/2;

            if (bfs(mid)){
                answer = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
    }

    public static boolean bfs(int x){
        Deque<int[]> stack = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+1][k+1];

        stack.push(new int[]{1, k});
        while (!stack.isEmpty()){
            int[] cur = stack.pop();

            if(cur[0] == n)
                return true;

            if (visited[cur[0]][cur[1]])
                continue;

            visited[cur[0]][cur[1]] = true;
            for(int[] a : list[cur[0]]){
                if (a[1] <= x)
                    stack.push(new int[]{a[0], cur[1]});
                else if (cur[1] > 0)
                    stack.push(new int[]{a[0], cur[1] - 1});

            }
        }
        return false;
    }
}