import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    static class ShortRoute {
        int end, dis;

        public ShortRoute(int end, int dis){
            this.end = end;
            this.dis = dis;
        }
    }
    static ArrayList<ArrayList<ShortRoute>> shortcuts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int des = Integer.parseInt(line[1]);

        for(int i=0; i<=des; i++)
            shortcuts.add(new ArrayList<>());

        while(n-- > 0){
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int len = Integer.parseInt(line[2]);
            if (end-start <= len || des < end)
                continue;
            shortcuts.get(start).add(new ShortRoute(end, len));
        }
        findMin(des);
    }

    public static void findMin(int des){
        int[] arr = new int[des+1];
        for(int i=1; i<=des; i++)
            arr[i] = i;

        for(int start=0; start<des; start++){
            if (arr[start+1] > arr[start] + 1)
                arr[start+1] = arr[start] + 1;

            for(ShortRoute route : shortcuts.get(start)){
                if (arr[start] + route.dis < arr[route.end])
                    arr[route.end] = arr[start] + route.dis;
            }
        }
        System.out.println(arr[des]);
    }
}