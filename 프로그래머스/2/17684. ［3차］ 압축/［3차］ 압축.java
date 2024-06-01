import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int seq;
        char c = 'A';
        HashMap<String, Integer> dict = new HashMap<>();
        for(seq=1; seq<27; seq++)
            dict.put(String.valueOf(c++), seq);

        ArrayList<Integer> list = new ArrayList<>();
        while(!dict.containsKey(msg)){
            int i = 0;
            int j = 1;
            String word = msg.substring(i, j);
            while(dict.containsKey(word)) {
                j++;
                word = msg.substring(i, j);
            }

            list.add(dict.get(word.substring(i, j-1)));
            dict.put(word, seq++);

            msg = msg.substring(j-1);
        }
        list.add(dict.get(msg));
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}