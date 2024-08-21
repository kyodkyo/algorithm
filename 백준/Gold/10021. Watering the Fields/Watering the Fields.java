import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    static class Node{
        int x, y, cost;

        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int n, c;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(line[0]), Integer.parseInt(line[1]), 0);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int cost = (int)Math.pow(nodes[i].x-nodes[j].x, 2) + (int)Math.pow(nodes[i].y-nodes[j].y, 2);
                if (cost >= c)
                    pq.add(new Node(i, j, cost));
            }
        }

        parent = new int[n];
        for(int i=0; i<n; i++)
            parent[i] = i;

        int result = 0;
        int count = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if (find(n.x) == find(n.y))
                continue;

            union(n.x, n.y);
            count++;
            result += n.cost;
        }

        System.out.println(count<n-1? -1 : result);
    }

    public static int find(int n){
        if (n==parent[n])
            return n;
        return parent[n] = find(parent[n]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }
}