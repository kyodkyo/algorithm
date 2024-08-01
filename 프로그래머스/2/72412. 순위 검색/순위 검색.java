import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    static HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
    static ArrayList<Integer> score = new ArrayList<>();
    
    public int[] solution(String[] info, String[] query) {
        for(String s : info)
            dfs(0, "", s.split(" "));

        for(ArrayList<Integer> list : hashMap.values())
            Collections.sort(list);

        int[] answer = new int[query.length];
        int i = 0;
        for(String s : query){
            String[] data = s.split(" and ");
            String[] str = data[3].split(" ");
            int target = Integer.parseInt(str[1]);
            data[3] = str[0];

            String key = String.join("", data);
            if (hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                int start = 0;
                int end = list.size() - 1;

                while (start <= end){
                    int mid = (start + end) / 2;

                    if (list.get(mid) < target)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
                answer[i] = list.size() - start;
            }
            i++;
        }
        return answer;
    }
    
    public static void dfs(int depth, String query, String[] info){
        if (depth == 4){
            if (!hashMap.containsKey(query)){
                score = new ArrayList<>();
                score.add(Integer.parseInt(info[4]));
                hashMap.put(query, score);
            }
            else
                hashMap.get(query).add(Integer.parseInt(info[4]));
            return;
        }
        dfs(depth + 1, query + "-", info);
        dfs(depth + 1, query + info[depth], info);
    }
}