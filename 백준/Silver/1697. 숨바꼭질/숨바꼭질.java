import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if (n==k)
            System.out.println(0);
        else
            System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(n);
        visited[n] = true;

        int size = 0;
        int time = 0;
        while (size >= 0){
            time++;
            size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
                visited[cur] = true;

                if (cur-1==k || cur+1==k || cur*2==k)
                    return time;
                if (cur-1>=0 && !visited[cur-1]) {
                    visited[cur-1] = true;
                    q.add(cur-1);
                }
                if (cur+1<=100000 && !visited[cur+1]) {
                    visited[cur+1] = true;
                    q.add(cur+1);
                }
                if (cur*2<=100000 && !visited[cur*2]) {
                    visited[cur*2] = true;
                    q.add(cur*2);
                }
            }
        }
        return time;
    }
}