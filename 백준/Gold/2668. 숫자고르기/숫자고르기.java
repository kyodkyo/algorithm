import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(int i=0; i<list.size(); i++)
            sb.append(list.get(i) + "\n");
        System.out.println(list.size() + "\n" + sb);
    }

    public static void dfs(int start, int end){
        if (arr[start] == end)
            list.add(end);

        if (!visited[arr[start]]){
            visited[arr[start]] = true;
            dfs(arr[start], end);
            visited[arr[start]] = false;
        }
    }
}