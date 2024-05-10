import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
    static class Node{
        int num;
        int cow;

        public Node(int num, int cow){
            this.num = num;
            this.cow = cow;
        }
    }
    static int n, m;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for(int i=0; i<n+1; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            list.get(x).add(new Node(y, c));
            list.get(y).add(new Node(x, c));
        }

        System.out.println(findPath());
    }

    public static int findPath(){
        int[] cows = new int[n+1];
        for(int i=1; i<n+1; i++)
            cows[i] = Integer.MAX_VALUE;

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cow));
        q.add(new Node(1, 0));

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cows[cur.num] >= cur.cow){
                for(Node node : list.get(cur.num)){
                    int cowSum = cur.cow + node.cow;

                    if (cows[node.num] > cowSum){
                        cows[node.num] = cowSum;
                        q.add(new Node(node.num, cowSum));
                    }
                }
            }
        }
        return cows[n];
    }
}