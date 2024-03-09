import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static class Comp{
        int num;
        String command;

        public Comp (int num, String command){
            this.num = num;
            this.command = command;
        }
    }
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            boolean[] visited = new boolean[10000];
            visited[start] = true;
            Queue<Comp> q = new LinkedList<>();
            q.add(new Comp(start, ""));

            bfs(visited, q, end);
        }
        System.out.println(sb);
    }

    public static void bfs(boolean[] visited, Queue<Comp> q, int end){
        while(!q.isEmpty()){
            Comp comp = q.poll();

            if (comp.num == end) {
                sb.append(comp.command + "\n");
                return;
            }

            int d = (comp.num*2)%10000;
            int s = comp.num==0? 9999 : comp.num-1;
            int l = comp.num%1000*10 + comp.num/1000;
            int r = comp.num%10*1000 + comp.num/10;

            if (!visited[d]){
                q.add(new Comp(d, comp.command+"D"));
                visited[d] = true;
            }
            if (!visited[s]){
                q.add(new Comp(s, comp.command+"S"));
                visited[s] = true;
            }
            if (!visited[l]){
                q.add(new Comp(l, comp.command+"L"));
                visited[l] = true;
            }
            if (!visited[r]){
                q.add(new Comp(r, comp.command+"R"));
                visited[r] = true;
            }
        }
    }
}