import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n, m;
    static ArrayList<Integer>[] relations;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        relations = new ArrayList[n];
        for(int i=0; i<n; i++)
            relations[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]) - 1;
            int y = Integer.parseInt(line[1]) - 1;
            relations[x].add(y);
            relations[y].add(x);
        }

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<n; i++){
            int bacon = bfs(i);
            if (min > bacon){
                min = bacon;
                idx = i;
            }
        }
        System.out.println(idx + 1);
    }

    public static int bfs(int cur){
        Queue<Integer> q = new LinkedList<>();
        q.add(cur);

        int[] bacon = new int[n];
        Arrays.fill(bacon, -1);
        bacon[cur] = 0;

        int count = 0;
        while(!q.isEmpty()){
            int start = q.poll();

            for(int friend : relations[start]){
                if (bacon[friend] == -1){
                    bacon[friend] = bacon[start] + 1;
                    q.add(friend);
                    count += bacon[friend];
                }
            }
        }
        return count;
    }
}