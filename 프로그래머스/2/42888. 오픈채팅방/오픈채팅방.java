import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        int count = 0;
        HashMap<String, String> hashMap = new HashMap<>();
        
        for(String str : record){
            String[] pstr = str.split(" ");
            if (pstr[0].equals("Enter") || pstr[0].equals("Change"))
                hashMap.put(pstr[1], pstr[2]);
            if (pstr[0].equals("Change"))
                count++;
        }

        int i = 0;
        String[] result = new String[record.length - count];
        
        for(String str : record){
            String[] pstr = str.split(" ");
            if (pstr[0].equals("Enter"))
                result[i++] = hashMap.get(pstr[1]) + "님이 들어왔습니다.";
            else if (pstr[0].equals("Leave"))
                result[i++] = hashMap.get(pstr[1]) + "님이 나갔습니다.";
        }

        return result;
    }
}