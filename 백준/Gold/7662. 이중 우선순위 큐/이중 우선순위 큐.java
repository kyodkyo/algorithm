import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            while(k-- > 0){
                String[] line = br.readLine().split(" ");
                String command = line[0];
                int num = Integer.parseInt(line[1]);

                if(command.equals("I"))
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

                else if (command.equals("D")) {
                    if (treeMap.isEmpty())
                        continue;

                    if (num == 1){
                        int max = treeMap.lastKey();
                        if (treeMap.get(max) == 1)
                            treeMap.remove(max);
                        else
                            treeMap.put(max, treeMap.get(max)-1);
                    }
                    else if (num == -1){
                        int min = treeMap.firstKey();
                        if (treeMap.get(min) == 1)
                            treeMap.remove(min);
                        else
                            treeMap.put(min, treeMap.get(min)-1);
                    }
                }

            }
            if (treeMap.isEmpty())
                sb.append("EMPTY\n");
            else
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
        }
        System.out.println(sb);
    }
}