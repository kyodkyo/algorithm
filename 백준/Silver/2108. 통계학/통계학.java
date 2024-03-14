import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] nums = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            sum += k;
            nums[i] = k;
            hashMap.put(k, hashMap.getOrDefault(k, 0) + 1);
        }

        int[] value = hashMap.values().stream().mapToInt(i->i).toArray();
        Arrays.sort(value);

        ArrayList<Integer> list = new ArrayList<>();
        for(int key : hashMap.keySet()){
            if (hashMap.get(key) == value[value.length-1])
                list.add(key);
        }
        Collections.sort(list);

        int freq;
        if (list.size() == 1)
            freq = list.get(0);
        else
            freq = list.get(1);


        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(sum/(float)n) + "\n");
        sb.append(nums[n/2] + "\n");
        sb.append(freq + "\n");
        sb.append(nums[n-1] - nums[0]);
        System.out.println(sb);
    }
}