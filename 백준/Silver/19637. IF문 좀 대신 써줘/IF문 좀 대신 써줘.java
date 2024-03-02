import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static class Level{
        String name;
        int value;

        public Level(String name, int value){
            this.name = name;
            this.value = value;
        }
    }
    static List<Level> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split(" ");
            list.add(new Level(line[0], Integer.parseInt(line[1])));
        }

        for(int i=0; i<m; i++)
            searchLevel(Integer.parseInt(br.readLine()));
        System.out.println(sb);
    }

    public static void searchLevel(int cur){
        int left = 0;
        int right = list.size()-1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (list.get(mid).value < cur)
                left = mid + 1;
            else
                right = mid - 1;
        }
        sb.append(list.get(left).name + "\n");
    }
}