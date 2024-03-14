import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static class Document{
        int i;
        int important;

        public Document(int i, int important){
            this.i = i;
            this.important = important;
        }
    }
    static int max;
    static Queue<Document> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int total = Integer.parseInt(input[0]);
            int findIdx = Integer.parseInt(input[1]);

            String[] line = br.readLine().split(" ");
            max = 0;
            q = new LinkedList<>();
            for(int j=0; j<total; j++){
                q.add(new Document(j, Integer.parseInt(line[j])));
                max = Math.max(max, Integer.parseInt(line[j]));
            }

            sb.append(findDocument(findIdx) + "\n");
        }
        System.out.println(sb);
    }

    public static int findDocument(int findIdx){
        int count = 0;
        while (true){
            if ( q.peek().important==max && q.peek().i==findIdx){
                count++;
                break;
            }

            if (q.peek().important < max)
                q.add(q.poll());
            else {
                q.poll();
                findMax();
                count++;
            }
        }
        return count;
    }

    public static void findMax(){
        max = 0;
        for(Document document : q)
            max = Math.max(max, document.important);
    }
}