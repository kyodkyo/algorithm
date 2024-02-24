import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            String word = br.readLine();
            if (word.length() >= m)
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);        
        }

        List<String> words = new ArrayList<>(hashMap.keySet());
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((int) hashMap.get(o1) != hashMap.get(o2))
                    return Integer.compare(hashMap.get(o2), hashMap.get(o1));
                if (o1.length() != o2.length())
                    return o2.length() - o1.length();
                return o1.compareTo(o2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s : words)
            sb.append(s + "\n");
        System.out.println(sb);
    }
}