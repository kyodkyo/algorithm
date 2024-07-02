import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       TreeMap<String, Integer> map = new TreeMap<>();
        for(String s :  records){
            String[] info = s.split(" |:");

            int time = (Integer.parseInt(info[0]) * 60) + Integer.parseInt(info[1]);
            if (info[3].equals("IN"))
                time *= -1;

            map.put(info[2], map.getOrDefault(info[2], 0) + time);
        }

        int i = 0;
        int end = 23 * 60 + 59;
        int[] result = new int[map.size()];
        for(String num : map.keySet()){
            if (map.get(num) <= 0)
                map.put(num, map.get(num) + end);
            int time = map.get(num);
            int fee = fees[1];
            if (time > fees[0])
                fee += Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            result[i++] = fee;
        }
        
        return result;
    }
}