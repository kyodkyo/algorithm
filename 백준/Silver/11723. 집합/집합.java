import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        while(n-- > 0){
            String[] line = br.readLine().split(" ");
            String command = line[0];

            if (command.equals("all")){
                q.clear();
                for(int i=1; i<=20; i++)
                    q.add(i);
                continue;
            }
            else if (command.equals("empty")){
                q.clear();
                continue;
            }

            int num = Integer.parseInt(line[1]);
            if (command.equals("add"))
                q.add(num);
            else if (command.equals("remove"))
                q.remove(num);
            else if (command.equals("check")){
                if (q.contains(num))
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
            }
            else if (command.equals("toggle")){
                if (q.contains(num))
                    q.remove(num);
                else
                    q.add(num);
            }

        }
        System.out.println(sb);
    }
}