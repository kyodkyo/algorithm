import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int start, end;
    static int time = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

//        if (start==end)
//            System.out.println(0);
//        else {
            bfs();
//        }
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        boolean[] visited = new boolean[100001];
        visited[start] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if (cur[0] == end) {
                System.out.println(cur[1]);
                return;
            }

            if (cur[0]*2<=100000 && !visited[cur[0]*2]){
                visited[cur[0]*2] = true;
                q.add(new int[]{cur[0]*2, cur[1]});
            }
            if (cur[0]-1>=0 && cur[0]-1<=100000 && !visited[cur[0]-1]){
                visited[cur[0]-1] = true;
                q.add(new int[]{cur[0]-1, cur[1]+1});
            }
            if (cur[0]+1>=0 && cur[0]+1<=100000 && !visited[cur[0]+1]){
                visited[cur[0]+1] = true;
                q.add(new int[]{cur[0]+1, cur[1]+1});
            }
        }
    }
}