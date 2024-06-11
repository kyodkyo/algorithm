import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] tuples = s.substring(2, s.length()-2).split("\\}.\\{");
        Arrays.sort(tuples, Comparator.comparingInt(String::length));

        List<Integer> result = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        
        for(String tuple : tuples){
            String[] arr = tuple.split(",");
            
            for(String num : arr){
                int n = Integer.parseInt(num);
                if (hashSet.add(n))
                    result.add(n);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}